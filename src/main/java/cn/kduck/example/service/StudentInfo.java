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

    public StudentInfo() {
    }

    public StudentInfo(Map<String, Object> map) {
        super(map);
    }

    /**
     * 设置 学生ID
     *
     * @param studentId 学生ID
     */
    public void setStudentId(long studentId) {
        super.setValue(STUDENT_ID, studentId);
    }

    /**
     * 获取 学生ID
     *
     * @return 学生ID
     */
    public Long getStudentId() {
        return super.getValueAsLong(STUDENT_ID);
    }

    /**
     * 设置 班级ID
     *
     * @param classId 班级ID
     */
    public void setClassId(Long classId) {
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
     * 设置 学生姓名
     *
     * @param name 学生姓名
     */
    public void setName(String name) {
        super.setValue(NAME, name);
    }

    /**
     * 获取 学生姓名
     *
     * @return 学生姓名
     */
    public String getName() {
        return super.getValueAsString(NAME);
    }

    /**
     * 设置 学生性别
     *
     * @param gender 学生性别
     */
    public void setGender(Integer gender) {
        super.setValue(GENDER, gender);
    }

    /**
     * 获取 学生性别
     *
     * @return 学生性别
     */
    public Integer getGender() {
        return super.getValueAsInteger(GENDER);
    }

    /**
     * 设置 学号
     *
     * @param studentNo 学号
     */
    public void setStudentNo(Integer studentNo) {
        super.setValue(STUDENT_NO, studentNo);
    }

    /**
     * 获取 学号
     *
     * @return 学号
     */
    public Integer getStudentNo() {
        return super.getValueAsInteger(STUDENT_NO);
    }
}
