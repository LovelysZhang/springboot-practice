package com.albatross.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoDaoTest {

    @Resource
    private UserInfoDao userInfoDao;
    @Test
    public void total() {
        System.out.println(userInfoDao.total());
    }
}