package com.elastic.bean;

import io.searchbox.annotations.JestId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 检索一篇文章
 *
 * @author non human
 * on 2020/2/11
 */
@Getter
@Setter
@Builder
public class Article {
    /**
     * @JestId 标识为主键
     */
    @JestId
    private Integer id;

    private String author;

    private String title;

    private String content;

}
