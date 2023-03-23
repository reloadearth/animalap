package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Post {
    private Integer id;
    private Integer userId;
    private String content;
    private Date createtime;
    private boolean flag;

    private String nickname;

}
