package com.honeybee.shardingjdbc.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.honeybee.shardingjdbc.entity.Book;
import com.honeybee.shardingjdbc.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lovely
 * @version 1.0
 * on 2020/8/27
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookList() {
        return bookMapper.selectList(Wrappers.<Book>lambdaQuery());
    }

    @Override
    public boolean saveBook(Book book) {
        return super.save(book);
    }
}
