package cn.kduck.example.service;

import cn.kduck.core.service.ValueMap;

import java.util.Map;

public class StudentInfo extends ValueMap {

    /**学生ID*/
    public static final String STUDENT_ID = "studentId";
    /**班级ID*/
    public static final String CLASS_ID = "classId";
    /**学生姓名*/
    public static final String NAME = "name";
    /**学生性别*/
    public static final String GENDER = "gender";
    /**学号*/
    public static final String STUDENT_NO = "studentNo";

    public StudentInfo() {}

    public StudentInfo(Map<String, Object> map) {
        super(map);
    }

    public void setStudentId(long studentId) {
        super.setValue(STUDENT_ID, studentId);
    }

    public Long getStudentId() {
        return super.getValueAsLong(STUDENT_ID);
    }

    public void setClassId(Long classId) {
        super.setValue(CLASS_ID, classId);
    }

    public long getClassId() {
        return super.getValueAsLong(CLASS_ID);
    }

    public void setName(String name) {
        super.setValue(NAME, name);
    }

    public String getName() {
        return super.getValueAsString(NAME);
    }

    public void setGender(Integer gender) {
        super.setValue(GENDER, gender);
    }

    public Integer getGender() {
        return super.getValueAsInteger(GENDER);
    }

    public void setStudentNo(Integer studentNo) {
        super.setValue(STUDENT_NO, studentNo);
    }

    public Integer getStudentNo() {
        return super.getValueAsInteger(STUDENT_NO);
    }
}
