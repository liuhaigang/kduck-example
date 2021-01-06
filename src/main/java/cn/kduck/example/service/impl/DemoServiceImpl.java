package cn.kduck.example.service.impl;

import cn.kduck.core.dao.query.QuerySupport;
import cn.kduck.core.service.DefaultService;
import cn.kduck.core.service.Page;
import cn.kduck.core.service.ParamMap;
import cn.kduck.example.query.DemoQuery;
import cn.kduck.example.service.ClassInfo;
import cn.kduck.example.service.DemoService;
import cn.kduck.example.service.StudentInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl extends DefaultService implements DemoService {

    @Override
    public void addClass(ClassInfo classInfo) {
        super.add(CODE_CLASS,classInfo);
    }

    @Override
    public void addStudent(Long classId, StudentInfo studentInfo) {
        Assert.notNull(classId,"班级ID不能为null");

        studentInfo.setClassId(classId);

        super.add(CODE_STUDENT,studentInfo);
    }

    @Override
    public void updateStudent(StudentInfo studentInfo) {
        super.update(CODE_STUDENT,studentInfo);
    }

    @Override
    public void deleteStudent(String[] studentId) {
        super.delete(CODE_STUDENT,studentId);
    }

    @Override
    public StudentInfo getStudent(String studentId) {
        return super.getForBean(CODE_STUDENT,studentId,StudentInfo::new);
    }

    @Override
    public List<StudentInfo> listStudent(String studentName, Page page) {
        Map<String, Object> paramMap = ParamMap.create("studentName", studentName).toMap();
        QuerySupport query = super.getQuery(DemoQuery.class, paramMap);
        return super.listForBean(query,page,StudentInfo::new);
    }
}
