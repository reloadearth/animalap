package com.nzr.animalap.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Message {
    private int id;
    private String content;
    private int sender;
    private int recipient;
    private Date createtime;
    private boolean status;

    private String sendername;
    private String recipientname;
}
