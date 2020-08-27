package com.honeybee.shardingjdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.honeybee.shardingjdbc.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lovely
 * @version 1.0
 * on 2020/8/27
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
