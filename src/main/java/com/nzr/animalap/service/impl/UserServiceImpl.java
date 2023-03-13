package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.UserMapper;
import com.nzr.animalap.mapper.VcodeMapper;
import com.nzr.animalap.pojo.User;
import com.nzr.animalap.pojo.Vcode;
import com.nzr.animalap.service.UserService;
import com.nzr.animalap.utils.MD5Utils;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    private VcodeMapper vcodeMapper;

    @Override
    public User checkUsernameAndPassword(String username, String password) {
        String md5Password = MD5Utils.code(password);
        User user = userMapper.checkUsernameAndPassword(username,md5Password);
        return user;
    }

    @Override
    public User adminLogin(String username, String password) {
        String md5Password = MD5Utils.code(password);
        User user = userMapper.adminLogin(username,md5Password);
        return user;
    }

    @Override
    public User checkrepeat(String username) {
        return userMapper.checkrepeat(username);
    }

    @Override
    public int signup(User user) {
        if(userMapper.checkrepeat(user.getUsername()) != null){
            return 0;
        }
        String md5password = MD5Utils.code(user.getPassword());
        user.setPassword(md5password);
        Date now = new Date();
        user.setCreatetime(now);
        user.setUpdatetime(now);
        StringBuilder s = new StringBuilder("rc_");
        for(int i=0;i<8;i++){
            char a = (char)((26*Math.random())+97);
            s.append(a);
        }
        user.setNickname(s.toString());
        user.setFlag(0);
        user.setStatus(true);
        return userMapper.signup(user);
    }

    @Override
    public int setVcode(Vcode vcode) {
        vcode.setCreatetime(new Date());
        return vcodeMapper.add(vcode);
    }

    @Override
    public Vcode getVcode( int userId) {
        return vcodeMapper.getNew(userId);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public int forgot(String username, String vcode, String password) {
        User user = userMapper.getByUsername(username);
        Vcode okVcode = vcodeMapper.getNew(user.getId());
        String md5Password = MD5Utils.code(password);
        long newTime = new Date().getTime();
        long oldTime = okVcode.getCreatetime().getTime();
        if((newTime-oldTime)/1000/60 > 5){
            return 11;
        }
        if(!vcode.equals(okVcode.getVcode())){
            return 22;
        }
        if(md5Password.equals(user.getPassword())){
            return 33;
        }

        return userMapper.updatePassword(user.getId(),md5Password);
    }

}
