package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Vcode {
    private Integer id;
    private String vcode;
    private Integer userId;
    private Date createtime;
}
