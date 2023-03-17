package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.AnimalCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalCategoryMapper {

    List<AnimalCategory> categoryList();
}
