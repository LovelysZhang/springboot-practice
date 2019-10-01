package com.albatross.db;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author non human
 * on 2019/10/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class H2Test {

    @Autowired
    private DataSource dataSource;
    @Test
    public void contextLoad() throws SQLException {
        log.info("{}",dataSource.getConnection());
    }
}
