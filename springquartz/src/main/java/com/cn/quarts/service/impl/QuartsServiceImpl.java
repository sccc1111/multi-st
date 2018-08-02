package com.cn.quarts.service.impl;

import com.cn.quarts.model.Cron;
import com.cn.quarts.service.QuartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by songbo on 2018/7/26.
 */
@Service(value="quartsServiceImpl")
public class QuartsServiceImpl implements QuartsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cron> findAll() {
        String sql = "Select id,name,tgroup,description,className,expression,status from sys_cron";
        RowMapper<Cron> rowMapper = new BeanPropertyRowMapper<Cron>(Cron.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public int add(Cron cron) {
        String sql = "Insert into sys_cron (name,tgroup,description,className,expression,status,createTime) values(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,cron.getName(),cron.getTgroup(),cron.getDescription(),cron.getClassName(),cron.getExpression(),cron.getStatus(),new Date());
    }

    @Override
    public int update(Cron cron) {
        String sql = "update sys_cron set name = ? ,tgroup = ?,description = ?,className = ?,expression=?,status = ? where id = ?";
        return jdbcTemplate.update(sql,cron.getName(),cron.getTgroup(),cron.getDescription(),cron.getClassName(),cron.getExpression(),cron.getStatus(),cron.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM sys_cron where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Cron findById(int id) {
        String sql = "Select id,name,tgroup,description,className,expression,status from sys_cron where id = ?";
        RowMapper<Cron> rowMapper = new BeanPropertyRowMapper<Cron>(Cron.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
}
