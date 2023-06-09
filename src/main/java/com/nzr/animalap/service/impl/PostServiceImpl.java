package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.PostMapper;
import com.nzr.animalap.mapper.PostReplyMapper;
import com.nzr.animalap.pojo.Post;
import com.nzr.animalap.pojo.PostReply;
import com.nzr.animalap.queryVo.PostDetail;
import com.nzr.animalap.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int banned(Integer id) {
        return postMapper.banned(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
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
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int banned2(Integer id) {
        return replyMapper.banned(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int unblock2(Integer id) {
        return replyMapper.unblock(id);
    }

    @Override
    public List<Post> rch(String keyword) {
        String okKeyword = '%' + keyword + '%';
        return postMapper.rch(okKeyword);
    }

    @Override
    public PostDetail getById(Integer id) {
        PostDetail postDetail = new PostDetail();
        Post post = postMapper.getById(id);
        List<PostReply> replyList = replyMapper.getByPostId(id);
        postDetail.setId(id);
        postDetail.setTitle(post.getTitle());
        postDetail.setContent(post.getContent());
        postDetail.setAvatar(post.getAvatar());
        postDetail.setNickname(post.getNickname());
        postDetail.setCreatetime(post.getCreatetime());
        postDetail.setReplyCount(post.getReplyCount());
        postDetail.setUserId(post.getUserId());
        postDetail.setNickname(post.getNickname());
        postDetail.setReplyList(replyList);
        return postDetail;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int newReply(PostReply postReply) {
        postReply.setCreatetime(new Date());
        postReply.setFlag(true);
        return replyMapper.insert(postReply);
    }

    /**
     * 查询用户自己发布的帖子
     * @param userId
     * @return
     */
    @Override
    public List<Post> listByUserId(Integer userId) {
        return postMapper.listByUserId(userId);
    }
}
