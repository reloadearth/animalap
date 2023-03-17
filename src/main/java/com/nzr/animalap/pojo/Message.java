package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Message {
    private Integer id;
    private String content;
    private Integer sender;
    private Integer recipient;
    private Date createtime;
    private boolean status;

    private String sendername;
    private String recipientname;
}
