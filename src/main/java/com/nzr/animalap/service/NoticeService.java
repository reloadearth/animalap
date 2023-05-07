package com.nzr.animalap.service;

import com.nzr.animalap.pojo.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> list();

    List<Notice> search(String keyword);

    int add(Notice notice);

    int remove(Integer id);

    Notice getById(Integer id);

    int edit(Notice notice);

    List<Notice> list1();
}
