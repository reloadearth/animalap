package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.PostReply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostReplyMapper {

    List<PostReply> list();

    List<PostReply> search(String okKeyword);

    int banned(Integer id);

    int unblock(Integer id);
}
