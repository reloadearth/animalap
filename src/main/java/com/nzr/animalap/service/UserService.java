package com.nzr.animalap.service;

import com.nzr.animalap.pojo.User;
import com.nzr.animalap.pojo.Vcode;

public interface UserService {
    User checkUsernameAndPassword(String username, String password);

    User adminLogin(String username, String password);

    User checkrepeat(String username);

    int signup(User user);
    int setVcode(Vcode vcode);
    Vcode getVcode(int userId);

    User getByUsername(String username);

    int forgot(String username, String vcode, String password);

    Object nicknameList();
}
