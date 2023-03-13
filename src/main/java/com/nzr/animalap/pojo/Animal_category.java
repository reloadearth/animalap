package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Animal_category {
    private int id;
    private String name;
    private Date createtime;
}
