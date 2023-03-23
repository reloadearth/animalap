package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.PostMapper;
import com.nzr.animalap.mapper.PostReplyMapper;
import com.nzr.animalap.pojo.Post;
import com.nzr.animalap.pojo.PostReply;
import com.nzr.animalap.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostMapper postMapper;

    private PostReplyMapper replyMapper;

    @Override
    public List<Post> list() {
        return postMapper.list();
    }

    @Override
    public List<Post> search(String keyword) {
        String okKeyword = '%' + keyword + '%';
        return postMapper.search(okKeyword);
    }

    @Override
    public int banned(Integer id) {
        return postMapper.banned(id);
    }

    @Override
    public int unblock(Integer id) {
        return postMapper.unblock(id);
    }

    @Override
    public List<PostReply> list2() {
        return replyMapper.list();
    }

    @Override
    public List<PostReply> search2(String keyword) {
        String okKeyword = '%' + keyword + '%';
        return replyMapper.search(okKeyword);
    }

    @Override
    public int banned2(Integer id) {
        return replyMapper.banned(id);
    }

    @Override
    public int unblock2(Integer id) {
        return replyMapper.unblock(id);
    }
}
