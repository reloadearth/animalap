package com.nzr.animalap.service;

import com.nzr.animalap.pojo.Animal;
import com.nzr.animalap.queryVo.AnimalQuery;

import java.util.List;

public interface AnimalService {
    List<AnimalQuery> animalList();

    List<AnimalQuery> search(String keyword);

    int add(Animal animal);

    int remove(int id);

    Animal getById(int id);

    int edit(Animal animal);
}
