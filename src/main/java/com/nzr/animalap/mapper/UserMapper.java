package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User checkUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User adminLogin(@Param("username") String username, @Param("password") String md5Password);

    User checkrepeat(String username);

    int signup(User user);

    User getByUsername(String username);

    int updatePassword(@Param("id") int id,@Param("password") String md5Password);
}