package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Vcode {
    private int id;
    private String vcode;
    private int userId;
    private Date createtime;
}
