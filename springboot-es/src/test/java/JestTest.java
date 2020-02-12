import com.elastic.SpringBootElasticSearchApplication;
import com.elastic.bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author non human
 * on 2020/2/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootElasticSearchApplication.class)
public class JestTest {

    @Autowired
    JestClient jestClient;

    private void executeCommand(Index index) {

    }

    @Test
    public void save() {
        // 1、给ES中索引（保存）一个文档
        Article article = Article.builder()
                .id(1).author("烽火戏诸侯")
                .title("雪中悍刀行")
                .content("此处省略一万字")
                .build();
        // 构建一个索引功能
        Index index = new Index.Builder(article).index("novel").type("swordsman").build();
        try {
            DocumentResult result = jestClient.execute(index);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 检查是否存储成功 http://localhost:9200/novel/swordsman/1
    }

    @Test
    public void search() {
        // 查询表达式
        String json = "{\n" +
                "    \"query\": {\n" +
                "        \"match\": {\n" +
                "            \"content\": \"一万字\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        // 构建搜索功能
        Search search = new Search.Builder(json).addIndex("novel").addType("swordsman").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
