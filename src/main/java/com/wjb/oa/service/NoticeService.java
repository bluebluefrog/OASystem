package com.wjb.oa.service;

import com.wjb.oa.dao.NoticeDao;
import com.wjb.oa.entity.Notice;
import com.wjb.oa.utils.MyBatisUtils;

import java.util.List;

public class NoticeService {
    public List<Notice> getNoticeList(Long receiverId) {
        return (List) MyBatisUtils.executeQuery(sqlSession -> {
            NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
            return noticeDao.selectByReceiverId(receiverId);
        });
    }
}
