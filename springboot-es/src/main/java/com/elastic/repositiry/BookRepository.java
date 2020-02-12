package com.elastic.repositiry;

import com.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author non human
 * on 2020/2/11
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    List<Book> findByBookNameLike(String bookName);
}
