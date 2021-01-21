package com.albatross.dao;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class UserInfoDaoTest {

    @Resource
    private UserInfoDao userInfoDao;

    @Test
    public void total() {
        System.out.println(userInfoDao.total());
    }
}