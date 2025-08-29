package com.sch.springboot.repository;

import com.sch.springboot.dto.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcTemplateEmployeeRepository2 {
    //사원객체를 저장하는 List<Employee>
    private List<Employee> list = new ArrayList<Employee>();
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateEmployeeRepository2(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /** 사원 등록 */
//    @Override
    public int insert(Employee employee) {
        String sql = "insert into employee (name, address, department) VALUES (?, ?, ?)";
        int rows = jdbcTemplate.update(sql, employee.getName(), employee.getAddress(), employee.getDepartment());
        return rows;
    }

    /** 사원 리스트 조회 */
//    @Override
    public List<Employee> selectAll() {
        String sql = "SELECT sno, name, address, department FROM employee";
        return jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Employee.class));
    }
}
