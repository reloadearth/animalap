package com.nzr.animalap.queryVo;

import com.nzr.animalap.pojo.AnimalCategory;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class AnimalQuery {
    private int id;
    private String animalName;
    private Date updatetime;
    private String firstpicture;
    private boolean status;

    private String nickname;
    private AnimalCategory category;
}
