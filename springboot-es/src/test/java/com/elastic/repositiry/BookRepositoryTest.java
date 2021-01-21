package com.elastic.repositiry;

import com.elastic.SpringBootElasticSearchApplication;
import com.elastic.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(classes = SpringBootElasticSearchApplication.class)
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void save() {
        bookRepository.save(new Book("22"));
    }

    @Test
    public void search() {
        // 模糊查询
        List<Book> list = bookRepository.findByBookNameLike("bookName");
        list.forEach(System.out::println);

    }
}