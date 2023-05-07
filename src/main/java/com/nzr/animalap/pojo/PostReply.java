package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class PostReply {
    private Integer id;
    private Integer userId;
    private String content;
    private Date createtime;
    private Integer postId;
    private boolean flag;

    private User user;
    private Post post;
}
