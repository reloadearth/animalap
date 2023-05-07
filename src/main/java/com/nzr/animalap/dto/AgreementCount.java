package com.nzr.animalap.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgreementCount {
    private Integer userId;
    //正在申请个数
    private Integer count;
}
