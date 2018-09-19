package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Configuration.class)
public class ConfigurationTest {
    @Autowired
    Connection con;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getConnection() {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT 1+1")){
            while (rs.next())
                Assert.assertEquals(2, rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}