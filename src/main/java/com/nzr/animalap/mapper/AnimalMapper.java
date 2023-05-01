package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.Animal;
import com.nzr.animalap.queryVo.AnimalList;
import com.nzr.animalap.queryVo.AnimalQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalMapper {
    List<AnimalQuery> animalQueryList();

    List<AnimalQuery> search(String keyword);

    int insert(Animal animal);

    int delete(int id);

    Animal getById(int id);

    int update(Animal animal);

    List<AnimalList> animalListV();

    Animal getDetailById(Integer id);

    List<AnimalList> rch(String keyword);
}
