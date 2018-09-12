package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

@Ignore
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
                Assert.assertEquals(2, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}