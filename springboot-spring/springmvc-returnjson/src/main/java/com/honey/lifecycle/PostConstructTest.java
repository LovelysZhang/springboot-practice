package com.honey.lifecycle;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lovely
 * @version 1.0
 * on 2021/4/2
 */
public abstract class PostConstructTest {

    protected static List<String> list = new ArrayList<>();

    @PostConstruct
    public void initialize() {
        registerAdPartition(list);
    }


    protected abstract void registerAdPartition(List<String> list);

}
