package com.nzr.animalap.service;

import com.nzr.animalap.pojo.Avatar;

import java.util.List;

public interface AvatarService {
    List<Avatar> list();

    int add(Avatar avatar);

    int remove(int id);

    int edit(Avatar avatar);

    Avatar getById(int id);

    List<Avatar> search(String keyword);
}
