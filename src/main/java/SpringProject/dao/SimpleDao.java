package SpringProject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SimpleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SimpeObject> index() {
        return jdbcTemplate.query("Select * From employee", new BeanPropertyRowMapper<>(SimpeObject.class));
    }

}
