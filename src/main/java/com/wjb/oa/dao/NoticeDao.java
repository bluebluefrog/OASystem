package com.wjb.oa.dao;

import com.wjb.oa.entity.LeaveForm;
import com.wjb.oa.entity.Notice;

import java.util.List;

public interface NoticeDao {
    public void insert(Notice notice);

    public List<Notice> selectByReceiverId(Long receiverId);
}
