package com.core;

import com.alibaba.fastjson.JSON;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author non human
 * on 2020/3/30
 */
public class StandardEvaluationContextTest {
//    static String str = "{\"gid\":\"\",\"marketFirst\":2,\"pid\":\"10010\",\"userName\":\"\",\"login\":false,\"vid\":\"80011216\",\"uid\":\"3BE45C5D-D820-4040-9D4C-2E82AFD7476D\",\"model\":\"\",\"cid\":\"C1001\"}";
    static String str = "{\"gid\":\"3F344DE7-157C-39EC-0A8E-7712778D1279\",\"activeTime\":24,\"channel\":3,\"marketFirst\":1,\"pid\":\"10010\",\"userName\":\"faezlnd8411\",\"login\":true,\"vid\":\"80011216\",\"uid\":\"A669124B-D66C-47DE-96A8-CDD272C0D3DC\",\"model\":\"iPhone10,3\",\"mobileLevel\":0,\"cid\":\"C1001\"}";
    static List<String> list = Arrays.asList("(#activeTime<=24 and #marketFirst==1)", "#activeTime<=24 and (#marketFirst==1 and #channel==3)");

    static {
        map = new HashMap<>();
//        map.put("gid", "");
//        map.put("marketFirst", 2);
//        map.put("pid", "10010");
//        map.put("userName", "");

    }

    private static Map<String, Object> map;

    private static Map maps;

    public static void main(String[] args) {
        maps = (Map) JSON.parse(str);
        EvaluationContext ctx = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();
        maps.forEach((key, object) -> ctx.setVariable(String.valueOf(key), object));

        Map<String, Boolean> result = new HashMap<>();
        list.forEach(item -> {
            result.put(item, parser.parseExpression(item).getValue(ctx, Boolean.class));
        });
        System.out.println(result);
    }
}
