package com.wjb.oa.dao;

import com.wjb.oa.entity.Notice;
import com.wjb.oa.utils.MyBatisUtils;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Date;

public class NoticeDaoTest extends TestCase {

    @Test
    public void testInsert(){
        MyBatisUtils.updateQuery(sqlSession -> {
            NoticeDao dao = sqlSession.getMapper(NoticeDao.class);
            Notice notice = new Notice();
            notice.setReceiverId(2l);
            notice.setContent("测试消息");
            notice.setCreateTime(new Date());
            dao.insert(notice);
            return null;
        });
    }
}