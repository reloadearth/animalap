package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.AnimalMapper;
import com.nzr.animalap.pojo.Animal;
import com.nzr.animalap.queryVo.AnimalQuery;
import com.nzr.animalap.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private AnimalMapper animalMapper;

    @Override
    public List<AnimalQuery> animalList() {
        return animalMapper.animalQueryList();
    }

    @Override
    public List<AnimalQuery> search(String keyword) {
        String keywordMax = "%"+keyword+"%";
        return animalMapper.search(keywordMax);
    }

    @Override
    public int add(Animal animal) {
        Date now = new Date();
        animal.setCreatetime(now);
        animal.setUpdatetime(now);
        return animalMapper.insert(animal);
    }

    @Override
    public int remove(int id) {
        return animalMapper.delete(id);
    }

    @Override
    public Animal getById(int id) {
        return animalMapper.getById(id);
    }

    @Override
    public int edit(Animal animal) {
        animal.setUpdatetime(new Date());
        return animalMapper.update(animal);
    }
}
