package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private Date createtime;
    private Date updatetime;
    private String avatar;
    private int flag;
    private String phone;
    private boolean status;
}
