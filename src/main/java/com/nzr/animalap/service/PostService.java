package com.nzr.animalap.service;

import com.nzr.animalap.pojo.Post;
import com.nzr.animalap.pojo.PostReply;

import java.util.List;

public interface PostService {
    List<Post> list();

    List<Post> search(String keyword);

    int banned(Integer id);

    int unblock(Integer id);

    List<PostReply> list2();

    List<PostReply> search2(String keyword);

    int banned2(Integer id);

    int unblock2(Integer id);
}
