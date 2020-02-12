package com.elastic.repositiry;

import com.elastic.bean.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author non human
 * on 2020/2/12
 */
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {

}
