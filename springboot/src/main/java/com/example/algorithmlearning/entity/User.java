package com.example.algorithmlearning.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String nickname;


}
