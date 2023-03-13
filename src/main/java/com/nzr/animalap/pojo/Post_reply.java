package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Post_reply {
    private int id;
    private int userId;
    private String content;
    private Date createtime;
    private int parentId;
    private boolean status;

    private User user;
    private User parentUser;
}
