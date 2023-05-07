package com.nzr.animalap.service;

import com.nzr.animalap.pojo.Opinion;
import com.nzr.animalap.pojo.User;
import com.nzr.animalap.pojo.Vcode;
import com.nzr.animalap.queryVo.UserDetailQuery;
import com.nzr.animalap.queryVo.UserList;

import java.util.List;

public interface UserService {
    User checkUsernameAndPassword(String username, String password);

    User adminLogin(String username, String password);

    User checkrepeat(String username);

    int signup(User user);
    int setVcode(Vcode vcode);
    User getByUsername(String username);

    int forgot(String username, String vcode, String password);

    Object nicknameList();

    List<UserDetailQuery> detailList();

    int add(User user);

    int remove(int id);

    User getById(int id);

    int edit(User user);

    List<UserDetailQuery> search(String keyword);

    List<UserList> rch(String keyword);

    List<Opinion> getOpinion();

    Opinion getOpinionByUserId(Integer id);


    int userEdit(User user, String opinion);
}
