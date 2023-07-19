package com.example.demo.Demo_Service;

import com.example.demo.Demo_Repository.DepartmentRepository;
import com.example.demo.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImpleTest {
    @Autowired
    private DepartmentServiceImple departmentServiceImple; //we need the object of the service to test the different
    // function

    @MockBean
    private DepartmentRepository departmentRepository; // for mocking the repository
    @BeforeEach //this function is called before all the test cases called
    void setUp() {
        Department department = Department.builder()
                .deptId(4L)
                .deptName("nursing")
                .deptCode(15).build();

        Mockito.when(departmentRepository.findByDeptName("nursing")).thenReturn(department); // this is called when
        // findByName is called from the repository
    }

    @Test //annotate all the method with test
    @DisplayName("Get Data based on valid department name")
    public void whenValid_department_thenDepartmentFound(){
        String depName = "nursing";
        Department found = departmentServiceImple.findByName(depName);

        //test cases for positive scenarios...
        assertEquals(depName,found.getDeptName()); //checks whether both the name matches, if the test case is passed.
        
        //NOTE: write the test cases for all the positive and the negative scenarios..
    }
}