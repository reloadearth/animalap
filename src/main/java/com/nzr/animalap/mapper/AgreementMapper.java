package com.nzr.animalap.mapper;

import com.nzr.animalap.dto.AgreementCount;
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

    int insert(Agreement agreement);

    AgreementCount listByUserId(Integer userId);

    List<AgreementQuery> listByUserId1(Integer userId);

    int withdraw(Integer id);
}
