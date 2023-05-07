package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.OpinionMapper;
import com.nzr.animalap.mapper.UserMapper;
import com.nzr.animalap.mapper.VcodeMapper;
import com.nzr.animalap.pojo.Opinion;
import com.nzr.animalap.pojo.User;
import com.nzr.animalap.pojo.Vcode;
import com.nzr.animalap.queryVo.UserDetailQuery;
import com.nzr.animalap.queryVo.UserList;
import com.nzr.animalap.queryVo.UserQuery;
import com.nzr.animalap.service.UserService;
import com.nzr.animalap.utils.MD5Utils;
import com.nzr.animalap.utils.RegexUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    private VcodeMapper vcodeMapper;

    private OpinionMapper opinionMapper;

    @Override
    public User checkUsernameAndPassword(String username, String password) {
        if(RegexUtils.isEmailInvalid(username)||RegexUtils.isPasswordInvalid(password)){
            return null;
        }
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

    /**
     * 注册新用户
     * @param user
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int signup(User user) {
        if(RegexUtils.isEmailInvalid(user.getUsername())||userMapper.checkrepeat(user.getUsername()) != null || RegexUtils.isPasswordInvalid(user.getPassword())){
            return 0;
        }
        String md5password = MD5Utils.code(user.getPassword());
        user.setPassword(md5password);
        Date now = new Date();
        user.setCreatetime(now);
        user.setUpdatetime(now);
        user.setAvatarId(1);
        if(user.getNickname() == null) {
            StringBuilder s = new StringBuilder("rc_");
            for (int i = 0; i < 8; i++) {
                char a = (char) ((26 * Math.random()) + 97);
                s.append(a);
            }
            user.setNickname(s.toString());
        }
        user.setFlag(0);
        user.setStatus(true);
        return userMapper.signup(user);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int setVcode(Vcode vcode) {
        vcode.setCreatetime(new Date());
        return vcodeMapper.add(vcode);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int forgot(String username, String vcode, String password) {

        if(RegexUtils.isPasswordInvalid(password) || RegexUtils.isVcodeInvalid(vcode)){
            return 4;
        }

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

    @Override
    public List<UserQuery> nicknameList() {
        return userMapper.nicknameList();
    }

    @Override
    public List<UserDetailQuery> detailList() {
        return userMapper.detailList();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int add(User user) {
        if(RegexUtils.isEmailInvalid(user.getUsername())||userMapper.checkrepeat(user.getUsername()) != null){
            return 0;
        }
        String md5password = MD5Utils.code("123");
        user.setPassword(md5password);
        Date now = new Date();
        user.setCreatetime(now);
        user.setUpdatetime(now);
        return userMapper.signup(user);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int remove(int id) {
        return userMapper.delete(id);
    }

    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int edit(User user) {
        user.setUpdatetime(new Date());
        return userMapper.update(user);
    }

    @Override
    public List<UserDetailQuery> search(String keyword) {
        String okKeyword = '%' + keyword + '%';
        return userMapper.search(okKeyword);
    }

    @Override
    public List<UserList> rch(String keyword) {
        String okKeyword = '%' + keyword + '%';
        return userMapper.rch(okKeyword);
    }

    /**
     * 获取所有opinion
     * @return
     */
    @Override
    public List<Opinion> getOpinion() {
        return opinionMapper.getOpinion();
    }

    @Override
    public Opinion getOpinionByUserId(Integer id) {
        return opinionMapper.getOpinionByUserId(id);
    }

    @Override
    public int userEdit(User user,String content) {
        Opinion opinion = opinionMapper.getOpinionByUserId(user.getId());
        //距离上次修改时间不到一周
        if(opinion !=null &&(new Date().getTime()-opinion.getCreatetime().getTime())/1000/60/60<=7){
            return 2;
        }
        //没有添加过个性签名
        if(opinion == null){
            opinion = new Opinion();
        }
        opinion.setUserId(user.getId());
        opinion.setContent(content);
        opinion.setCreatetime(new Date());
        opinionMapper.insert(opinion);
        userMapper.update(user);
        return 1;
    }

}
