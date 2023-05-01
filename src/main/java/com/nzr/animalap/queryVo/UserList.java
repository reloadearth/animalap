package com.nzr.animalap.queryVo;

import com.nzr.animalap.pojo.Avatar;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class UserList {
    private Integer id;
    private String nickname;
    private Integer avatarId;
    private String description;
    private String address;
}
