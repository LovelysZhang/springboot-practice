package com.honeybee.shardingjdbc.service;

import com.honeybee.shardingjdbc.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lovely
 * @version 1.0
 * on 2020/8/27
 */
public interface BookService {

    List<Book> getBookList();

    boolean saveBook(Book book);
}
