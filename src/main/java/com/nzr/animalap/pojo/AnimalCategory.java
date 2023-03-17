package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class AnimalCategory {
    private Integer id;
    private String categoryName;
    private Date createtime;
    private Date updatetime;
}
