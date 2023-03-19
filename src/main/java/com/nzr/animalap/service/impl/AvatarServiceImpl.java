package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.AvatarMapper;
import com.nzr.animalap.pojo.Avatar;
import com.nzr.animalap.service.AvatarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AvatarServiceImpl implements AvatarService {

    private AvatarMapper avatarMapper;

    @Override
    public List<Avatar> list() {
        return avatarMapper.list();
    }
}
