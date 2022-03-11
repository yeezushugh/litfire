package com.example.kkdemo_version1.Mappers;

import com.example.kkdemo_version1.Model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
users
		long	string		string		string 		string
		users_id	users_username	users_first_name	users_last_name	users_email_address
* */
@Mapper
public interface UserMybatisRepository {
    @Select("SELECT * FROM users")
    public List<User> findAll();

    @Select("SELECT * FROM users WHERE users_id = #{id}")
    public User findById(long id);

    @Delete("DELETE FROM users WHERE users_id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO users(users_id, users_username, users_first_name,users_last_name,users_email_address) " +
            " VALUES (#{id}, #{username}, #{firstName}, #{lastName}, #{emailAddress})")
    public int insert(User user);

    @Update("UPDATE users set users_username=#{username}, " +
            " users_first_name=#{firstName},users_last_name=#{lastName}, users_email_address=#{emailAddress} where users_id=#{id}")
    public int update(User user);
}
