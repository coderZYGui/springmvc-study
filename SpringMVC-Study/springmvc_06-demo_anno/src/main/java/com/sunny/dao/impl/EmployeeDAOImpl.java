package com.sunny.dao.impl;

import com.sunny.dao.IEmployeeDAO;
import com.sunny.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public void save(Employee e) {
        jdbcTemplate.update("INSERT INTO employee (username,password,age,hiredate) VALUES (?,?,?,?)", e.getUsername(),
                e.getPassword(), e.getAge(), e.getHiredate());
    }

    public void update(Employee e) {
        jdbcTemplate.update("UPDATE employee SET username= ?,password=?,age = ?,hiredate=? WHERE id= ?",
                e.getUsername(), e.getPassword(), e.getAge(), e.getHiredate(), e.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);
    }


    public Employee get(Long id) {
        String sql = "SELECT id,username,password,age,hiredate FROM employee WHERE id = ?";

        List<Employee> list = jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setUsername(rs.getString("username"));
                e.setPassword(rs.getString("password"));
                e.setAge(rs.getInt("age"));
                e.setHiredate(rs.getDate("hiredate"));
                return e;
            }
        });

        return list.size() == 1 ? list.get(0) : null;
    }


    public List<Employee> listAll() {
    	String sql = "SELECT id,username,password,age,hiredate FROM employee";
        List<Employee> listAll = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Employee>() {
                    public Employee mapRow(ResultSet rs, int i) throws SQLException {
                        Employee e = new Employee();
                        e.setId(rs.getLong("id"));
                        e.setUsername(rs.getString("username"));
                        e.setPassword(rs.getString("password"));
                        e.setAge(rs.getInt("age"));
                        e.setHiredate(rs.getDate("hiredate"));
                        return e;
                    }
                });

        return listAll;
    }

    public Employee login(String username, String password) {

        String sql = "SELECT id,username,password,age,hiredate FROM employee WHERE username = ? AND password = ?";

        List<Employee> list = jdbcTemplate.query(sql, new Object[]{username, password}, new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setUsername(rs.getString("username"));
                e.setPassword(rs.getString("password"));
                e.setAge(rs.getInt("age"));
                e.setHiredate(rs.getDate("hiredate"));
                return e;
            }
        });

        return list.size() == 1 ? list.get(0) : null;
    }

}
