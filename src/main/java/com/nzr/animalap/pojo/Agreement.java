package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Agreement {
    private int id;
    private int userId;
    private int animalId;
    private String identitycard;
    private String phone;
    private String qq;
    private String email;
    private String wechat;
    private String address;

    private User user;
    private Animal animal;
}
