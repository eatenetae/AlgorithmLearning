package com.example.algorithmlearning.controller;

import com.example.algorithmlearning.entity.User;
import com.example.algorithmlearning.mapper.UserMapper;
import com.example.algorithmlearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //分页查询
    //接口路径：/user/page
    //RequestParam接受 ?pageNum=1&pageSize=10
    //前端使用/user/page?pageNum=1&pageSize=10这个url之后，对应的值映射到这里来
    //limit第一个参数 = (pageNum - 1) * pageSize
    @GetMapping("/page")
    public Map<String, Object> FindPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String username) {
        pageNum = (pageNum - 1)*pageSize;
        List<User> data = userMapper.selectPage(pageNum,pageSize,username);
        Integer total = userMapper.selectTotal(username);
        Map<String,Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

}
