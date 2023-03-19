package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.Avatar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarMapper {

    List<Avatar> list();
}
