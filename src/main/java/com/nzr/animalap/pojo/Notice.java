package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Notice {
    private Integer id;
    private String title;
    private String content;
    private Date createtime;
    private boolean flag;

}
