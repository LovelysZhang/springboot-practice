package com.honey.lifecycle;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lovely
 * @version 1.0
 * on 2021/4/2
 */
@Component
public class ConcreteA extends PostConstructTest {

    @Override
    protected void registerAdPartition(List<String> list) {
        list.add(this.getClass().getSimpleName());
    }
}
