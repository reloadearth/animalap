package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Animal {
    private Integer id;
    private String animalName;
    private Integer age;
    private String gender;
    private String color;
    private String nature;
    private String health;
    private Integer categoryId;
    private Integer userId;
    private boolean status;
    private Date createtime;
    private Date updatetime;
    private String description;
    private String firstpicture;
    private Integer grade;

    private User user;
    private AnimalCategory type;
}
