package cn.kduck.example.service;

import cn.kduck.core.service.Page;

import java.util.List;

public interface DemoService {

    String CODE_CLASS = "CLASS_INFO";
    String CODE_STUDENT = "STUDENT_INFO";

    void addClass(ClassInfo classInfo);

    void addStudent(Long classId,StudentInfo studentInfo);

    void updateStudent(StudentInfo studentInfo);

    void deleteStudent(String[] studentId);

    StudentInfo getStudent(String studentId);

    List<StudentInfo> listStudent(String studentName, Page page);
}
