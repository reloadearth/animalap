package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Agreement {
    private Integer id;
    private Integer userId;
    private Integer animalId;
    private String idCard;
    private String realname;
    private String phone;
    private String qq;
    private String email;
    private String wechat;
    private String address;
    private Date createtime;
    private Date updatetime;
    private Integer test1;
    private Integer test2;
    private Integer test3;
    private boolean flag;

}
