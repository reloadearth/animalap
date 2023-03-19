package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Avatar {
    private Integer id;
    private String avatarName;
    private String address;
    private Date createtime;
    private boolean flag;
}
