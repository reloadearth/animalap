package com.nzr.animalap.queryVo;

import com.nzr.animalap.pojo.Post;
import com.nzr.animalap.pojo.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class PostReplyList {
    private Integer id;
    private Integer userId;
    private String content;
    private Date createtime;
    private Integer postId;
    private boolean flag;

    private String nickname;
    private String avatar;
}
