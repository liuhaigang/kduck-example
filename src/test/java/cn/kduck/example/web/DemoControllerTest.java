package cn.kduck.example.web;

import cn.kduck.core.web.json.JsonObject;
import cn.kduck.example.service.StudentInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;
import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
//@AutoConfigureWebTestClient
@TestMethodOrder(MethodName.class)
class DemoControllerTest {

//    @Autowired
//    private WebTestClient webClient;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<JsonObject> json;

    @Test
    void addClass() throws Exception{
        MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.post("/example/class/add")
                .characterEncoding("UTF-8")
                .param("className","模拟班级")
                .param("classNo","模拟班号");
        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("0"))
                .andExpect(jsonPath("data").isNotEmpty());
//                .andExpect(content().string("SUCCESS"));
    }

    @Test
    void addStudent()  throws Exception{
        Long classId = addClassForOtherTests();
        MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.post("/example/student/add")
                .characterEncoding("UTF-8")
                .param("name","张三")
                .param("studentNo","317")
                .param("gender","1")
                .param("classId",""+classId);
        this.mvc.perform(postRequest)
                .andExpect(jsonPath("code").value("0"))
                .andExpect(jsonPath("data").isNotEmpty());
    }

    @Test
    void updateStudent() throws Exception{
        Long classId = addClassForOtherTests();
        Long studentId = addStudentForOtherTests(classId);

        MockHttpServletRequestBuilder putRequest = MockMvcRequestBuilders.put("/example/student/update")
                .characterEncoding("UTF-8")
                .param("name","李四")
                .param("studentId",""+studentId);
        this.mvc.perform(putRequest)
                .andExpect(jsonPath("code").value("0"));

        StudentInfo updatedStudent = getStudentForOtherTests(studentId);
        assertThat(updatedStudent.getName()).isEqualTo("李四");
    }

    @Test
    void deleteStudent()throws Exception{
    }

    @Test
    void getStudent() throws Exception{
//        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.get("/example/class/get")
//                .param("studentId",""+studentId);
//        MvcResult result = this.mvc.perform(getRequest)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("code").value("0"))
//                .andExpect(jsonPath("data").isNotEmpty())
//                .andReturn();
    }

    @Test
    void listStudent() throws Exception{
    }

    private StudentInfo getStudentForOtherTests(Long studentId) throws Exception {
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.get("/example/student/get")
                .characterEncoding("UTF-8")
                .param("studentId",""+studentId);
        MvcResult result = this.mvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("0"))
                .andExpect(jsonPath("data").isNotEmpty())
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        response.setCharacterEncoding("UTF-8");
        JsonObject jsonObject = json.parse(response.getContentAsString()).getObject();
        return new StudentInfo((Map)jsonObject.getData());
    }

    private Long addClassForOtherTests() throws Exception {
        MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.post("/example/class/add")
                .characterEncoding("UTF-8")
                .param("className","模拟班级")
                .param("classNo","模拟班号");
        MvcResult result = this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("0"))
                .andExpect(jsonPath("data").isNotEmpty())
                .andReturn();

        JsonObject jsonObject = json.parse(result.getResponse().getContentAsString()).getObject();
        return (Long)jsonObject.getData();
    }

    private Long addStudentForOtherTests(Long classId) throws Exception {
        MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.post("/example/student/add")
                .characterEncoding("UTF-8")
                .param("name","张三")
                .param("studentNo","317")
                .param("gender","1")
                .param("classId",""+classId);
        MvcResult result = this.mvc.perform(postRequest)
                .andExpect(jsonPath("code").value("0"))
                .andReturn();
        JsonObject jsonObject = json.parse(result.getResponse().getContentAsString()).getObject();
        return (Long)jsonObject.getData();
    }
}