package com.nzr.animalap.queryVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
public class AgreementQuery {
    private Integer id;
    private String nickname;
    private String animalName;
    private String phone;
    private Date updatetime;
    private Integer test1;
    private Integer test2;
    private Integer test3;
    private boolean flag;
}
