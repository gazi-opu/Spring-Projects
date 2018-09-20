package com.datasoft.DemoApplication.repository;

import com.datasoft.DemoApplication.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<User> findAll(){
        String query = "Select * from user";

        try{
           return  jdbcTemplate.query(query,new UserRowMapper());
        }catch (DataAccessException dae){
            dae.printStackTrace();
            dae.getLocalizedMessage();
        }
        return new ArrayList<>();
    }

    class UserRowMapper implements RowMapper<User>{
        @Nullable
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("ID"));
            user.setUsrName(resultSet.getString("Username"));
            user.setPassword(resultSet.getString("Password"));
            user.setFirstName(resultSet.getString("First Name"));
            user.setMiddleName(resultSet.getString("Middle Name"));
            user.setLastName(resultSet.getString("Last Name"));
            return user;
        }
    }

}