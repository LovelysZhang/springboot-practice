package com.elastic.repositiry;

import com.elastic.SpringBootElasticSearchApplication;
import com.elastic.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
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