package com.nzr.animalap.service.impl;

import com.nzr.animalap.dto.AgreementCount;
import com.nzr.animalap.mapper.AgreementMapper;
import com.nzr.animalap.mapper.AnimalMapper;
import com.nzr.animalap.pojo.Agreement;
import com.nzr.animalap.pojo.Animal;
import com.nzr.animalap.pojo.Notice;
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

    /**
     * 申请领养
     * @param agreement
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int add(Agreement agreement) {
        //判断是存在申请进行中
        AgreementCount agreementCount = agreementMapper.listByUserId(agreement.getUserId());
        if(agreementCount.getCount() >=1){
            return 3;
        }
        Animal animal = animalMapper.getById(agreement.getAnimalId());
        //判断小动物当前状态
        if(!animal.isStatus()){
            return 4;
        }
        animal.setStatus(false);
        animalMapper.update(animal);
        agreement.setTest1(0);
        agreement.setTest2(0);
        agreement.setTest3(0);
        agreement.setFlag(true);
        return agreementMapper.insert(agreement);
    }

    /**
     * 通过用户id查询申请记录
     * @param userId
     * @return
     */
    @Override
    public List<AgreementQuery> listByUserId(Integer userId) {
        return agreementMapper.listByUserId1(userId);
    }

    @Override
    public int withdraw(Integer id) {
        return agreementMapper.withdraw(id);
    }

}
