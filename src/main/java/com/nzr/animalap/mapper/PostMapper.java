package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper {
    List<Post> list();
    
    List<Post> search(String keyword);
    
    int update(Post post);

    int banned(Integer id);

    int unblock(Integer id);
}
