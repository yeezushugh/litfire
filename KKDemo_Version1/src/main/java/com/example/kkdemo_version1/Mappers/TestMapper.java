package com.example.kkdemo_version1.Mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    int selectFromTest(int id);
}
