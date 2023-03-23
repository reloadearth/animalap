package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.AgreementMapper;
import com.nzr.animalap.pojo.Agreement;
import com.nzr.animalap.queryVo.AgreementQuery;
import com.nzr.animalap.service.AgreementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private AgreementMapper agreementMapper;
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
}
