package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.User;
import com.nzr.animalap.queryVo.UserQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User checkUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User adminLogin(@Param("username") String username, @Param("password") String password);

    User checkrepeat(String username);

    int signup(User user);

    User getByUsername(String username);

    int updatePassword(@Param("id") int id,@Param("password") String md5Password);

    List<UserQuery> nicknameList();
}