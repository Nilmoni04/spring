package com.SpringFrame.SpringJDBCDemo.repo;

import com.SpringFrame.SpringJDBCDemo.model.Nil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Nilrepo {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Nil nil) {
        String sql = "insert into nil (id, name, tech) values (?, ?, ?)";
        int rows = template.update(sql, nil.getId(), nil.getName(), nil.getTech());
        System.out.println(rows + " row/s effected");
    }

    public void delete(Nil nil) {
        String sql = "delete from nil where id = ?";
        int rows = template.update(sql, nil.getId());
        System.out.println(rows + " row/s effected");
    }

    public List<Nil> findAll() {
        String sql = "select * from nil";
        RowMapper<Nil> mapper = new RowMapper<Nil>() {
            @Override
            public Nil mapRow(ResultSet rs, int rowNum) throws SQLException {
                Nil n = new Nil();
                n.setId(rs.getInt(1));
                n.setName(rs.getString(2));
                n.setTech(rs.getString(3));

                return n;
            }
        };
        List<Nil> nil = template.query(sql, mapper);
        return nil;
    }
}
