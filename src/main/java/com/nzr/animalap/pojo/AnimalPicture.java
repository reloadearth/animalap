package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class AnimalPicture {
    private Integer id;
    private Integer animalId;
    private String address;
}
