package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Animal {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String color;
    private String nature;
    private String health;
    private int typeId;
    private int userId;
    private boolean status;
    private Date createtime;
    private Date updatetime;
    private String description;
    private String firstpicture;
    private int level;

    private User user;
    private Animal_category type;
}
