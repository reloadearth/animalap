package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class AgreementProgress {
    private Integer id;
    private Integer userId;
    private Integer agreementId;
    private Integer animalId;
    private Date createtime;
    private boolean status;

    private String username;
    private String agreementname;
    private String animalname;
}
