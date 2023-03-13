package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.Vcode;
import org.springframework.stereotype.Repository;

@Repository
public interface VcodeMapper {
    int add(Vcode vcode);
    Vcode getNew(int userId);
}
