package net.cnway.springboot06.controller;

import net.cnway.springboot06.bean.Department;
import net.cnway.springboot06.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController  {
    @Autowired
    DepartmentMapper departmentMapper;
    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable("id") Integer id){
        return departmentMapper.getDepartmentById(id);
    }
    @GetMapping("/dept")
    public Department saveDepartment(Department department){
        departmentMapper.insertDepartment(department);
        return  department;
    }
}
