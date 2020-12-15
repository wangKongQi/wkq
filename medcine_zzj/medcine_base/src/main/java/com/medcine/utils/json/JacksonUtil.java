package com.medcine.utils.json;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jackson工具类
 * 对象转json格式数据，json转对象数据
 * @author SuperH
 * @time 2018-07-22
 */

public class JacksonUtil {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    
    static{
    	//序列化的时候序列对象的所有属性
		objectMapper.setSerializationInclusion(Include.ALWAYS);
		
		//反序列化的时候如果多了其他属性,不抛出异常
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		//如果是空对象的时候,不抛异常
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		
		//取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    
	public static String PATTERN_YMD = "yyyy-MM-dd";
	public static String PATTERN_YMD_HMS = "yyyy-MM-dd HH:mm:ss";
	public static String PATTERN_HMS = "HH:mm:ss";
    
    /**
     * 
     */
    public void setDateFormat(String pattern){
    	objectMapper.setDateFormat(new SimpleDateFormat(pattern));
    }

    private JacksonUtil() {

    }
    
    public static ObjectMapper getInstance() {

        return objectMapper;
    }

    /**
     * javaBean,list,array convert to json string
     */
    public static String obj2json(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }
    
    /**
     * object 转指定泛型对象
     */
    public static <T> T obj2pojo(Object obj, Class<T> clazz)
            throws Exception {
        String jsonStr = obj2json(obj);
        return objectMapper.readValue(jsonStr, clazz);
    }
    
    /**
     * object 转指定泛型对象
     */
    public static <T> List<T> obj2List(Object obj, Class<T> clazz)
            throws Exception {
        String jsonStr = obj2json(obj);
        return json2list(jsonStr, clazz);
    }
    
    /**
     * json string convert to javaBean
     */
    public static <T> T json2pojo(String jsonStr, Class<T> clazz)
            throws Exception {
        return objectMapper.readValue(jsonStr, clazz);
    }

    /**
     * json string convert to map
     */
    public static <T> Map<String, Object> json2map(String jsonStr)
            throws Exception {
        return objectMapper.readValue(jsonStr, Map.class);
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz)
            throws Exception {
        Map<String, Map<String, Object>> map = objectMapper.readValue(jsonStr,
                new TypeReference<Map<String, T>>() {
                });
        Map<String, T> result = new HashMap<String, T>();
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz)
            throws Exception {
        List<Map<String, Object>> list = objectMapper.readValue(jsonArrayStr,
                new TypeReference<List<T>>() {
                });
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(map2pojo(map, clazz));
        }
        return result;
    }

    /**
     * map convert to javaBean
     */
    public static <T> T map2pojo(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }

}
