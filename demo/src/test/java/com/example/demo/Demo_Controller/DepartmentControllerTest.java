package com.example.demo.Demo_Controller;

import com.example.demo.Demo_Service.DepartmentServiceImple;
import com.example.demo.Entity.Department;
import com.example.demo.ErrorException.DepartmentNotFoundExcetion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentServiceImple departmentServiceImple;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .deptCode(23)
                .deptName("Bsc")
                .deptId(12L).build();
    }

    @Test
    void addDept() throws Exception {
        Department inputdepartment = Department.builder()
                .deptCode(23)
                .deptName("Bcs").build();
        Mockito.when(departmentServiceImple.addDept(inputdepartment)).thenReturn(department);

        mockMvc.perform(post("/addDep").contentType(MediaType.APPLICATION_JSON).content(
                "{\n" +
                        "    \"deptName\":\"Bsc\",\n" +
                        "    \"deptCode\":\"23\"\n" +
                        "}"
        )).andExpect(status().isOk());
    }

    @Test
    void fetchById() throws Exception {
         Mockito.when(departmentServiceImple.fetchById(12L)).thenReturn(Optional.ofNullable(department));

         mockMvc.perform(get("/getId/12")
                         .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.deptName")
                         .value(department.getDeptName()));
    }
}