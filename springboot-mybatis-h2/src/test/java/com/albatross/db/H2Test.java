package com.albatross.db;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author lovely
 * on 2019/10/1
 */
@SpringBootTest
@Slf4j
public class H2Test {

    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoad() throws SQLException {
        log.info("{}", dataSource.getConnection());
    }
}
