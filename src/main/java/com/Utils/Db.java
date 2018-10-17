package com.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class Db {
    @Resource
    private JdbcTemplate dbTemplate;

    @Transactional
    public void init(){
        dbTemplate.execute("create table test(" +
                "id number," +
                "name varchar(100)"+
                "d_create date" +
                ")");

        dbTemplate.update("insert into test(id, name) values(?, ?)", 1, "1");
        dbTemplate.update("insert into test(id, name) values(?, ?)", 2, "2");
    }

    public Integer getCountRows(){
        return dbTemplate.queryForObject("select count(1) from test", Integer.class);

    }

}
