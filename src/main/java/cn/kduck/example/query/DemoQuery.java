package cn.kduck.example.query;

import cn.kduck.core.dao.definition.BeanDefDepository;
import cn.kduck.core.dao.definition.BeanEntityDef;
import cn.kduck.core.dao.query.QueryCreator;
import cn.kduck.core.dao.query.QuerySupport;
import cn.kduck.core.dao.sqlbuilder.ConditionBuilder.ConditionType;
import cn.kduck.core.dao.sqlbuilder.SelectBuilder;
import cn.kduck.core.utils.BeanDefUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

import static cn.kduck.example.service.DemoService.CODE_CLASS;
import static cn.kduck.example.service.DemoService.CODE_STUDENT;

@Component
public class DemoQuery implements QueryCreator {

    @Override
    public QuerySupport createQuery(Map<String, Object> paramMap, BeanDefDepository depository) {
        BeanEntityDef classEntityDef = depository.getEntityDef(CODE_CLASS);
        BeanEntityDef studentEntityDef = depository.getEntityDef(CODE_STUDENT);

        SelectBuilder selectBuilder = new SelectBuilder(paramMap);
        selectBuilder.bindFields("c", BeanDefUtils.includeField(classEntityDef.getFieldList(), "className"));
        selectBuilder.bindFields("s", studentEntityDef.getFieldList());

        selectBuilder.from("s", studentEntityDef).innerJoin("c", classEntityDef)
                .where()
                .and("s.NAME", ConditionType.CONTAINS,"studentName");
        return selectBuilder.build();
    }
}
