package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.Avatar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarMapper {

    List<Avatar> list();

    int insert(Avatar avatar);

    int delete(int id);

    int update(Avatar avatar);

    Avatar getById(int id);

    List<Avatar> search(String keyword);
}
