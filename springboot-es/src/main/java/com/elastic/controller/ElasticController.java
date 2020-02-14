package com.elastic.controller;

import com.elastic.bean.Book;
import com.elastic.repositiry.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author non human
 * on 2020/2/12
 */
@RestController
public class ElasticController {


    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    public ElasticController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/save")
    public void save(String id) {
        // 请求 http://localhost:9200/zzz/book/1 查看是否保存成功
        bookRepository.save(new Book(id));
    }

    @GetMapping("/save2")
    public void save2(String id) {

        elasticsearchTemplate.createIndex(Book.class);
    }
}
