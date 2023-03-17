package com.nzr.animalap.queryVo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class UserDetailQuery {
    private Integer id;
    private String username;
    private String nickname;
    private Date updatetime;
    private String avatar;
    private Integer flag;
    private String phone;
    private boolean status;
}
