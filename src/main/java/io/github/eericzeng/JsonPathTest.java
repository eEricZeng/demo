package io.github.eericzeng;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.jayway.jsonpath.JsonPath;

/**
 * fastjson与json-path在复杂json上使用jsonpath语法对比。
 *
 * @author zengguang 2019年8月7日
 *
 */
public class JsonPathTest {

    /**
     * json对象如下所示：
     * <pre>
     * {
     *   "store": {
     *       "book": [{
     *           "title": "Java虚拟机",
     *           "price": 20
     *       }, {
     *           "title": "Head First 设计模式",
     *           "price": 72
     *       }, {
     *           "title": "重构：改善既有代码的设计",
     *           "isbn": "123",
     *           "price": 38
     *       }, {
     *           "title": "Spring实践4",
     *           "isbn": "321",
     *           "price": 32
     *       }, {
     *           "title": "图解HTTP",
     *           "isbn": "543",
     *           "price": 25
     *       }],
     *       "bicycle": {
     *           "color": "red",
     *           "price": 219
     *       }
     *   }
     * }
     * </pre>
     * 
     * @param args
     */
    public static void main(String[] args) {
        String json = "{\"store\": {\"book\": [{\"title\": \"Java虚拟机\",\"price\": 20}, {\"title\": \"Head First 设计模式\",\"price\": 72}, {\"title\": \"重构：改善既有代码的设计\",\"isbn\": \"123\",\"price\": 38}, {\"title\": \"Spring实践4\",\"isbn\": \"321\",\"price\": 32}, {\"title\": \"图解HTTP\",\"isbn\": \"543\",\"price\": 25}],\"bicycle\": {\"color\": \"red\",\"price\": 219}}}";
        
        String jsonPath = "$['store']['book'][:-1]['price','title']";
        Object obj = JSONPath.read(json, jsonPath);
        System.out.println(obj);

        jsonPath = "$.store.book.[*].['title', 'price']";
        obj = JsonPath.parse(json).read(jsonPath);
        String str = JSONObject.toJSONString(obj);
        System.out.println(str);
    }
}
