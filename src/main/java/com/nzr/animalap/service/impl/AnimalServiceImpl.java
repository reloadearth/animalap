package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.AnimalMapper;
import com.nzr.animalap.pojo.Animal;
import com.nzr.animalap.queryVo.AnimalList;
import com.nzr.animalap.queryVo.AnimalQuery;
import com.nzr.animalap.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int add(Animal animal) {
        Date now = new Date();
        animal.setCreatetime(now);
        animal.setUpdatetime(now);
        return animalMapper.insert(animal);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int remove(int id) {
        return animalMapper.delete(id);
    }

    @Override
    public Animal getById(int id) {
        return animalMapper.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public int edit(Animal animal) {
        animal.setUpdatetime(new Date());
        return animalMapper.update(animal);
    }

    @Override
    public List<AnimalList> animalListV() {
        return animalMapper.animalListV();
    }

    @Override
    public Animal getDetailById(Integer id) {
        return animalMapper.getDetailById(id);
    }

    @Override
    public List<AnimalList> rch(String keyword) {
        String okKeyword = '%' + keyword + '%';
        return animalMapper.rch(okKeyword);
    }
}
