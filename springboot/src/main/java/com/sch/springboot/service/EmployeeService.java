package com.sch.springboot.service;

import com.sch.springboot.dto.Employee;
import com.sch.springboot.repository.JdbcTemplateEmployeeRepository;
import com.sch.springboot.repository.JpaEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeService {

     private JpaEmployeeRepository employeeRepository;

     @Autowired
     public EmployeeService(JpaEmployeeRepository jpaEmployeeRepository) {
         this.employeeRepository = jpaEmployeeRepository;
     }

//    private final JdbcTemplateEmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeService(JdbcTemplateEmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    //사원리스트
    public List<Employee> findAll(){
        return employeeRepository.selectAll();
    }

    //사원등록
    public int register(Employee employee) {
        return employeeRepository.insert(employee);
    }
}
