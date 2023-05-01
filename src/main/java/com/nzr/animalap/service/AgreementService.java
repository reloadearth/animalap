package com.nzr.animalap.service;

import com.nzr.animalap.pojo.Agreement;
import com.nzr.animalap.queryVo.AgreementQuery;

import java.util.List;

public interface AgreementService {
    List<AgreementQuery> list();

    List<AgreementQuery> search(String keyword);

    Agreement getById(Integer id);

    int edit(Agreement agreement);

    int add(Agreement agreement);
}
