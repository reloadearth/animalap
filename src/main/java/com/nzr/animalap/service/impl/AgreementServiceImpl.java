package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.AgreementMapper;
import com.nzr.animalap.mapper.AnimalMapper;
import com.nzr.animalap.pojo.Agreement;
import com.nzr.animalap.pojo.Animal;
import com.nzr.animalap.queryVo.AgreementQuery;
import com.nzr.animalap.service.AgreementService;
import com.nzr.animalap.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private AgreementMapper agreementMapper;

    private AnimalMapper animalMapper;
    @Override
    public List<AgreementQuery> list() {
        return agreementMapper.list();
    }

    @Override
    public List<AgreementQuery> search(String keyword) {
        String okKeyword = '%'+ keyword +'%';
        return agreementMapper.search(okKeyword);
    }

    @Override
    public Agreement getById(Integer id) {
        return agreementMapper.getById(id);
    }

    @Override
    public int edit(Agreement agreement) {
        return agreementMapper.update(agreement);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int add(Agreement agreement) {
        Animal animal = animalMapper.getById(agreement.getAnimalId());
        animal.setStatus(false);
        animalMapper.update(animal);
        agreement.setTest1(0);
        agreement.setTest2(0);
        agreement.setTest3(0);
        agreement.setFlag(true);
        return agreementMapper.insert(agreement);
    }
}
