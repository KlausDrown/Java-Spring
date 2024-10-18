package SpringProject.dao;


import SpringProject.object.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Department> index(int page) {
        return jdbcTemplate.query("Select * From department ORDER BY name limit 5 offset "+((page-1)*5), new BeanPropertyRowMapper<>(Department.class));
    }

    public List<Department> index() {
        return jdbcTemplate.query("Select * From department", new BeanPropertyRowMapper<>(Department.class));
    }

    public void save(Department department) {
        jdbcTemplate.update("INSERT INTO department(name) VALUES(?)", department.getName());
    }
    public void delete(int ID) {
        jdbcTemplate.update("DELETE FROM department WHERE id = ?", ID);
    }
}
