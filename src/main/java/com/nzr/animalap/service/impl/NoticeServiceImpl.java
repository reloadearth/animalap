package com.nzr.animalap.service.impl;

import com.nzr.animalap.mapper.NoticeMapper;
import com.nzr.animalap.pojo.Notice;
import com.nzr.animalap.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> list() {
        return noticeMapper.list();
    }

    @Override
    public List<Notice> search(String keyword) {
        String okKeyword = '%'+ keyword +'%';
        return noticeMapper.search(okKeyword);
    }

    @Override
    public int add(Notice notice) {
        notice.setCreatetime(new Date());
        return noticeMapper.insert(notice);
    }

    @Override
    public int remove(Integer id) {
        return noticeMapper.delete(id);
    }

    @Override
    public Notice getById(Integer id) {
        return noticeMapper.getById(id);
    }

    @Override
    public int edit(Notice notice) {
        return noticeMapper.update(notice);
    }
}
