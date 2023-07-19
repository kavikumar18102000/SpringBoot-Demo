package com.example.demo.Demo_Service;

import com.example.demo.Demo_Repository.DepartmentRepository;
import com.example.demo.Entity.Department;
import com.example.demo.ErrorException.DepartmentNotFoundExcetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImple{

    @Autowired
    public DepartmentRepository departmentRepository;

    public Department addDept(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getList(){
        ArrayList<Department> l = new ArrayList<>();
        departmentRepository.findAll().forEach(l::add);
        return l;
    }

    public String deleteById(Long id){
        departmentRepository.deleteById(id);
        return "Deleted" + id + "Successfully....";
    }

    public Optional<Department> fetchById(Long id) throws DepartmentNotFoundExcetion {
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()){
            throw new DepartmentNotFoundExcetion("Department Not found...");
        }

        return department;
    }

    public Department updateDepartment(Long id,Department department){
        Department existing = departmentRepository.findById(id).get();
        existing.setDeptName(department.getDeptName());
        existing.setDeptCode(department.getDeptCode());
        departmentRepository.save(existing);
        return existing;
    }

    public Department findByCode(int DeptCode){
        return departmentRepository.findByDeptCode(DeptCode);
    }

    public Department findByName(String deptName){
        return departmentRepository.findByDeptName(deptName);
    }
}
