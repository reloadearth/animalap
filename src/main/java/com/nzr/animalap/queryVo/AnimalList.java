package com.nzr.animalap.queryVo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class AnimalList {
    private Integer id;
    private String animalName;
    private String firstpicture;
    private String description;
    private Date updatetime;
}
