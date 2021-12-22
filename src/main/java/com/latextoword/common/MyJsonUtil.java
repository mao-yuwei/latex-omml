package com.latextoword.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maoyuwei on 2017/8/24.
 * JSON工具类
 */
public class MyJsonUtil {
    private static ObjectMapper mapper;
    @SuppressWarnings("unused")
    /**
     * 初始化
     */
    private static void init(){
        if(mapper==null){
            mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
        }
    }

    /**
     * json转实体
     * @param jsonString json字符串
     * @param clazz 实体类
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        try {
            init();
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
        	e.printStackTrace();
            return null;
        }
    }

    /**
     * 实体转json
     * @param object 实体类
     * @return json字符串
     */
    public static String toJson(Object object) {
        try {
            init();
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        init();
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
    
    
    @SuppressWarnings("rawtypes")
	public static List json4List(String jsonString, JavaType javaType){
        try {
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @SuppressWarnings("rawtypes")
	public static Map jsontoMap(String jsonString, JavaType javaType){
        try {
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //将json 转化为List<Map<String,Object>> 类型
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public static List jsontoListMapObject(String jsonString){
    	 init();
         JavaType inner=mapper.getTypeFactory().constructParametrizedType(HashMap.class, Map.class,String.class,Object.class);
         JavaType javaType=mapper.getTypeFactory().constructParametricType(List.class,inner);
        try {
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public static List jsontoListMapClazz(String jsonString,Class<?> clazz){
   	 init();
        JavaType inner=mapper.getTypeFactory().constructParametrizedType(HashMap.class, Map.class,String.class,clazz);
        JavaType javaType=mapper.getTypeFactory().constructParametricType(List.class,inner);
       try {
           return mapper.readValue(jsonString, javaType);
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }
   }
    @SuppressWarnings({ "rawtypes", "deprecation" })
    public static List jsontoListClazz(String jsonString,Class<?> clazz){
        init();
        JavaType javaType=mapper.getTypeFactory().constructParametricType(List.class,clazz);
        try {
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
