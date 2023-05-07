package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.Opinion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionMapper {
    public List<Opinion> getOpinion();

    public Opinion getOpinionByUserId(Integer id);

    int insert(Opinion opinion);
}
