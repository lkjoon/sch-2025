package com.sch.springboot.repository;

import com.sch.springboot.dto.Dwitter;
import com.sch.springboot.dto.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaEmployeeRepository implements EmployeeRepositoryInterface {

    private final EntityManager em;

    @Autowired
    public JpaEmployeeRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> selectAll(){
        return em.createQuery("select m from Employee m", Employee.class)
                .getResultList();
    }

    @Override
    public int insert(Employee employee){
        em.persist(employee);
        return employee.getSno();
    }


}

