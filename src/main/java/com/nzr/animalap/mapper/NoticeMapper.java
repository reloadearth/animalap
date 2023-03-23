package com.nzr.animalap.mapper;

import com.nzr.animalap.pojo.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {

    List<Notice> list();

    List<Notice> search(String keyword);

    int insert(Notice notice);

    int delete(Integer id);

    Notice getById(Integer id);

    int update(Notice notice);
}
