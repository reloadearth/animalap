package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.AnimalCategoryMapper;
import com.nzr.animalap.pojo.AnimalCategory;
import com.nzr.animalap.service.AnimalCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalCategoryServiceImpl implements AnimalCategoryService {

    private AnimalCategoryMapper categoryMapper;

    @Override
    public List<AnimalCategory> animalCategoryList() {
        return categoryMapper.categoryList();
    }
}
