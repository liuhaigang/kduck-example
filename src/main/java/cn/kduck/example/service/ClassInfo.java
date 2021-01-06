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

    public ClassInfo() {
    }

    public ClassInfo(Map<String, Object> map) {
        super(map);
    }

    /**
     * 设置 班级ID
     *
     * @param classId 班级ID
     */
    public void setClassId(long classId) {
        super.setValue(CLASS_ID, classId);
    }

    /**
     * 获取 班级ID
     *
     * @return 班级ID
     */
    public long getClassId() {
        return super.getValueAsLong(CLASS_ID);
    }

    /**
     * 设置 班级名称
     *
     * @param className 班级名称
     */
    public void setClassName(String className) {
        super.setValue(CLASS_NAME, className);
    }

    /**
     * 获取 班级名称
     *
     * @return 班级名称
     */
    public String getClassName() {
        return super.getValueAsString(CLASS_NAME);
    }

    /**
     * 设置 班号
     *
     * @param classNo 班号
     */
    public void setClassNo(String classNo) {
        super.setValue(CLASS_NO, classNo);
    }

    /**
     * 获取 班号
     *
     * @return 班号
     */
    public String getClassNo() {
        return super.getValueAsString(CLASS_NO);
    }
}
