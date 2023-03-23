package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.Agreement;
import com.nzr.animalap.queryVo.AgreementQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgreementMapper {
    List<AgreementQuery> list();

    List<AgreementQuery> search(String keyword);

    Agreement getById(Integer id);

    int update(Agreement agreement);
}
