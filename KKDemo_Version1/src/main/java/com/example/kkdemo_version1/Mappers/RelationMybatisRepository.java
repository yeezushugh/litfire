package com.example.kkdemo_version1.Mappers;

import com.example.kkdemo_version1.Model.Relation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
relations
		primary key(relations_first_id, relations_second_id)
		long		long		int
		relations_first_id	relations_second_id	relations_type
		refers to users_id	refers to users_id
* */
public interface RelationMybatisRepository {
    @Select("SELECT * FROM relations")
    public List<Relation> findAll();

    @Select("SELECT * FROM relations WHERE relations_first_id = #{id} OR relations_second_id = #{id}")
    public Relation findById(long id);

    @Delete("DELETE FROM relations WHERE relations_first_id = #{id} OR relations_second_id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO relations(relations_first_id, relations_second_id, relations_type) " +
            " VALUES (#{firstId}, #{secondId}, #{type})")
    public int insert(Relation relation);

    @Update("UPDATE users set relations_type=#{username}, WHERE relations_first_id = #{firstId} OR relations_second_id = #{secondId}")
    public int update(Relation relation);
}
