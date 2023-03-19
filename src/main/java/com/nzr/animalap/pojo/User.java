package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private Date createtime;
    private Date updatetime;
    private Integer avatarId;
    private Integer flag;
    private String phone;
    private boolean status;
    private String description;
}
