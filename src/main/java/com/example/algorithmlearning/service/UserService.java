package com.example.algorithmlearning.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.algorithmlearning.entity.User;
import com.example.algorithmlearning.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;

}
