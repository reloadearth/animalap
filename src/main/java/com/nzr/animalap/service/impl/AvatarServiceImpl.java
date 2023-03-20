package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.AvatarMapper;
import com.nzr.animalap.pojo.Avatar;
import com.nzr.animalap.service.AvatarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AvatarServiceImpl implements AvatarService {

    private AvatarMapper avatarMapper;

    @Override
    public List<Avatar> list() {
        return avatarMapper.list();
    }

    @Override
    public int add(Avatar avatar) {
        avatar.setCreatetime(new Date());
        return avatarMapper.insert(avatar);
    }

    @Override
    public int remove(int id) {
        return avatarMapper.delete(id);
    }

    @Override
    public int edit(Avatar avatar) {
        return avatarMapper.update(avatar);
    }

    @Override
    public Avatar getById(int id) {
        return avatarMapper.getById(id);
    }

    @Override
    public List<Avatar> search(String keyword) {
        String okKeyword = '%' + keyword + '%';
        return avatarMapper.search(okKeyword);
    }
}
