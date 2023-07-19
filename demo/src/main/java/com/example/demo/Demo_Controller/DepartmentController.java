package com.example.demo.Demo_Controller;


import com.example.demo.Demo_Service.DepartmentServiceImple;
import com.example.demo.Entity.Department;
import com.example.demo.ErrorException.DepartmentNotFoundExcetion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired //--> injects the object in the container to the referenced variable.
    private DepartmentServiceImple departmentServiceImple;


    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/addDep")
    public Department addDept(@RequestBody Department department){ //request body converts the fetched data to department
        // form. The data sent might in the form of JSON or XML
        return departmentServiceImple.addDept(department);


    }

    @GetMapping("/list")
    public List<Department> getList(){
        LOGGER.info("inside the getlist function of Department Controller");
        return departmentServiceImple.getList();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteByid(@PathVariable Long id){
        return departmentServiceImple.deleteById(id);
    }

    @GetMapping("/getId/{id}")
    public Optional<Department> fetchById(@PathVariable("id") Long id) throws DepartmentNotFoundExcetion {
        return departmentServiceImple.fetchById(id);
    }


    @PutMapping("/updateDept/{id}")
    public Department updateDepartment(@PathVariable Long id,@RequestBody Department department){
        return departmentServiceImple.updateDepartment(id,department);
    }

    @GetMapping("/find/{code}")
    public Department findByCode(@PathVariable("code") int DeptCode){
        return departmentServiceImple.findByCode(DeptCode);
    }

    @GetMapping("/findName/{name}")
    public Department findByName(@PathVariable("name") String name){
        return departmentServiceImple.findByName(name);
    }
}
