package com.jit.demo.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by db on 16-12-24.
 * zxl 这边的处理还是蛮给力的啊
 *
 */
public class JacksonUtils {
    public static ObjectMapper objectMapper;
    private final static Logger LOGGER = LoggerFactory.getLogger(JacksonUtils.class);
    /**
     * 使用泛型方法,把json字符串转转为相应的javabean对象
     */
    public static <T> T readValue(String jsonStr, Class<T> valueType){
        if (objectMapper == null){
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(jsonStr,valueType);
        } catch (IOException e) {
            LOGGER.error("输入有误，请输入正确格式的内容：（查看在线设备请输入：showdevice）",e);
        }
        return null;
    }


    /**
     * 把jaavabean转换为json字符串
     */
    public static String toJson(Object object){
        if (objectMapper == null){
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
