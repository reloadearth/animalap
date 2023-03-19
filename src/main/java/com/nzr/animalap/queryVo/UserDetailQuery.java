package com.nzr.animalap.queryVo;

import com.nzr.animalap.pojo.Avatar;
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
    private Integer avatarId;
    private Integer flag;
    private String phone;
    private boolean status;
    private Avatar avatar;
}
