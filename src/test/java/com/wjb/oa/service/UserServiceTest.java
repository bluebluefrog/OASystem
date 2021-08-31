package com.wjb.oa.service;

import com.wjb.oa.entity.Node;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class UserServiceTest extends TestCase {

    private UserService userService=new UserService();

    @Test
    public void testCheckLogin() {
        userService.checkLogin("uu", "1234");
    }
    @Test
    public void testCheckLogin2() {
        userService.checkLogin("m8", "1234");
    }
    @Test
    public void testCheckLogin3() {
        userService.checkLogin("m8", "test");
    }
}