package SpringProject.dao;

import SpringProject.object.Department;
import SpringProject.object.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Employee> employeeRowMapper = (resultSet, rowNum) -> {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt(1));
        employee.setName(resultSet.getString(2));
        employee.setLogin(resultSet.getString(3));
        employee.setPassword(resultSet.getString(4));
        employee.setDepartment_name(resultSet.getString(5));
        return employee;
    };

    public List<Employee> index(int page) {
        return jdbcTemplate.query("Select e.id, e.name, e.login, e.password, d.name FROM employee e, department d where department_id = d.id ORDER BY e.name limit 5 offset "+((page-1)*5) ,employeeRowMapper);
    }
    public List<Employee> index() {
        return jdbcTemplate.query("Select e.id, e.name, e.login, e.password, d.name FROM employee e, department d where department_id = d.id",employeeRowMapper);
    }

    public void save(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee(name,login,password,department_id) VALUES(?,?,?,?)",
                employee.getName(),
                employee.getLogin(),
                employee.getPassword(),
                employee.getDepartment_id());
    }
    public void delete(int ID) {
        jdbcTemplate.update("DELETE FROM employee WHERE id = ?", ID);
    }
}
