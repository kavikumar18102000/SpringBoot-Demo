package com.example.demo.Demo_Repository;

import com.example.demo.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {

    public Department findByDeptCode(int deptCode); //Creating our own function
    public Department findByDeptName(String deptName);
}
