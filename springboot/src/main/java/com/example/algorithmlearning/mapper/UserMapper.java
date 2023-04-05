package com.example.algorithmlearning.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.algorithmlearning.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username like concat('%',#{username},'%') limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize, String username);

    @Select("select count(*) from user where username like concat('%',#{username},'%')")
    Integer selectTotal(String username);
}
