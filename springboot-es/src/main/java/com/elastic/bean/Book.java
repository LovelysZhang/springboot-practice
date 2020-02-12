package com.elastic.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.StringJoiner;

/**
 * @author non human
 * on 2020/2/11
 */
@Getter
@Setter
@Document(indexName = "zzz", type = "book")
public class Book {
    @Id
    private String id;
    private String bookName;
    private String author;

    public Book(String id) {
        this.id = id;
        this.bookName = "bookName";
        this.author = "author";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"bookName\":\"")
                .append(bookName).append('\"');
        sb.append(",\"author\":\"")
                .append(author).append('\"');
        sb.append('}');
        return sb.toString();
    }

    /**
     * jackson的反序列化需要无参构造函数
     */
    public Book() {
    }

    public static void main(String[] args) {
        System.out.println(new Book("22"));
    }
}
