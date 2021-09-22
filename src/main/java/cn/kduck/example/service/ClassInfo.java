package cn.kduck.example.service;

import cn.kduck.core.service.ValueMap;

import java.util.Map;

public class ClassInfo extends ValueMap {

    /**班级ID*/
    public static final String CLASS_ID = "classId";
    /**班级名称*/
    public static final String CLASS_NAME = "className";
    /**班号*/
    public static final String CLASS_NO = "classNo";

    public ClassInfo() {}

    public ClassInfo(Map<String, Object> map) {
        super(map);
    }

    public void setClassId(Long classId) {
        super.setValue(CLASS_ID, classId);
    }

    public Long getClassId() {
        return super.getValueAsLong(CLASS_ID);
    }

    public void setClassName(String className) {
        super.setValue(CLASS_NAME, className);
    }

    public String getClassName() {
        return super.getValueAsString(CLASS_NAME);
    }

    public void setClassNo(String classNo) {
        super.setValue(CLASS_NO, classNo);
    }

    public String getClassNo() {
        return super.getValueAsString(CLASS_NO);
    }
}
