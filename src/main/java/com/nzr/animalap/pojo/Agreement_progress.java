package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Agreement_progress {
    private int id;
    private int userId;
    private int agreementId;
    private int animalId;
    private Date createtime;
    private boolean status;

    private String username;
    private String agreementname;
    private String animalname;
}
