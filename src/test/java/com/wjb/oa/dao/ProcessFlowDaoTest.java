package com.wjb.oa.dao;

import com.wjb.oa.entity.ProcessFlow;
import com.wjb.oa.utils.MyBatisUtils;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Date;

public class ProcessFlowDaoTest extends TestCase {
    @Test
    public void testInsert(){
        MyBatisUtils.updateQuery(sqlSession -> {
            ProcessFlowDao dao = sqlSession.getMapper(ProcessFlowDao.class);
            ProcessFlow flow = new ProcessFlow();
            flow.setFormId(3l);
            flow.setOperatorId(2l);
            flow.setAction("audit");
            flow.setReason("approved");
            flow.setReason("同意");
            flow.setCreateTime(new Date());
            flow.setAuditTime(new Date());
            flow.setOrderNo(1);
            flow.setState("ready");
            flow.setIsLast(1);
            dao.insert(flow);
            return null;
        });
    }
}