package cn.kduck.example.web;

import cn.kduck.core.service.Page;
import cn.kduck.core.web.json.JsonObject;
import cn.kduck.core.web.json.JsonPageObject;
import cn.kduck.core.web.swagger.ApiField;
import cn.kduck.core.web.swagger.ApiJsonResponse;
import cn.kduck.core.web.swagger.ApiParamRequest;
import cn.kduck.example.service.ClassInfo;
import cn.kduck.example.service.DemoService;
import cn.kduck.example.service.StudentInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/example")
@Api(tags="示例模块")
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    @PostMapping("/class/add")
    @ApiOperation("添加班级")
    @ApiParamRequest({
            @ApiField(name="className",value="班级名称"),
            @ApiField(name="classNo",value="班号")
    })
    public JsonObject addClass(ClassInfo classInfo) {
        demoService.addClass(classInfo);
        return new JsonObject(classInfo.getClassId());
    }

    @PostMapping("/student/add")
    @ApiOperation("添加学生信息")
    @ApiParamRequest({
            @ApiField(name="classId",value="班级ID"),
            @ApiField(name="name",value="学生姓名"),
            @ApiField(name="gender",value="学生性别（1男，2女）",allowableValues = "1,2"),
            @ApiField(name="studentNo",value="学号")

    })
    public JsonObject addStudent(Long classId,StudentInfo studentInfo) {
        demoService.addStudent(classId,studentInfo);
        return new JsonObject(studentInfo.getStudentId());
    }

    @PutMapping("/student/update")
    @ApiOperation("更新学生信息")
    @ApiParamRequest({
            @ApiField(name="studentId",value="学生ID"),
            @ApiField(name="name",value="学生姓名"),
            @ApiField(name="gender",value="学生性别（1男，2女）",allowableValues = "1,2"),
            @ApiField(name="studentNo",value="学号")

    })
    public JsonObject updateStudent(StudentInfo studentInfo) {
        demoService.updateStudent(studentInfo);
        return JsonObject.SUCCESS;
    }

    @PutMapping("/student/delete")
    @ApiOperation("删除学生信息")
    @ApiParamRequest({
            @ApiField(name="ids",value="学生ID",allowMultiple = true)
    })
    public JsonObject deleteStudent(@RequestParam("ids") String[] ids) {
        demoService.deleteStudent(ids);
        return JsonObject.SUCCESS;
    }

    @GetMapping("/student/get")
    @ApiOperation("查看学生信息")
    @ApiParamRequest({
            @ApiField(name="studentId",value="学生ID")
    })
    @ApiJsonResponse({
            @ApiField(name="studentId",value="学生ID"),
            @ApiField(name="name",value="学生姓名"),
            @ApiField(name="gender",value="学生性别（1男，2女）",allowableValues = "1,2"),
            @ApiField(name="studentNo",value="学号")
    })
    public JsonObject getStudent(@RequestParam("studentId") String studentId) {
        StudentInfo student = demoService.getStudent(studentId);
        return new JsonObject(student);
    }

    @GetMapping("/student/list")
    @ApiOperation("分页查询学生信息")
    @ApiParamRequest({
            @ApiField(name="studentName",value="学生姓名")
    })
    @ApiJsonResponse(isArray = true,value={
            @ApiField(name="studentId",value="学生ID"),
            @ApiField(name="name",value="学生姓名"),
            @ApiField(name="gender",value="学生性别（1男，2女）",allowableValues = "1,2"),
            @ApiField(name="studentNo",value="学号")
    })
    public JsonObject listStudent(String studentName, @ApiIgnore Page page) {
        List<StudentInfo> studentInfos = demoService.listStudent(studentName, page);
        return new JsonPageObject(page,studentInfos);
    }
}
