package com.nzr.animalap.queryVo;

import com.nzr.animalap.pojo.PostReply;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class PostDetail {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private Date createtime;
    private boolean flag;
    private Integer postId;

    private String nickname;
    private String avatar;
    private Integer replyCount;
    private List<PostReply> replyList;
}
