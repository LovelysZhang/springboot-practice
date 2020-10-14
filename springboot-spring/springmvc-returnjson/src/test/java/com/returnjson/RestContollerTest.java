package com.returnjson;

import com.BaseTest;

import java.util.HashMap;

/**
 * @author lovely
 * @version 1.0
 * on 2020/9/11
 */
public class RestContollerTest extends BaseTest {

    private static final HashMap<String, Object> INFO;

    static {
        INFO = new HashMap<String, Object>();
        INFO.put("name", "galaxy");
        INFO.put("age", "70");
    }


}
