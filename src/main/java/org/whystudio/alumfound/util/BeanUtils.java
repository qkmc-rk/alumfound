package org.whystudio.alumfound.util;

import com.google.common.base.CaseFormat;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现Bean与Map类型的转换
 */
public final class BeanUtils {

    /**
     * todo 过滤了空值属性，是否合理待定
     * @param object
     * @param <V>
     * @return
     */
    public static final <V> Map<String, Object> beanToMap(V object) {
        Map<String, Object> result = new HashMap<>();
        if (object != null) {
            Map<String, Object> map = BeanMap.create(object);

            map.forEach((s, o) -> {
                if (map.get(s) != null) {
                    String key = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, s);
                    result.put(key, o);
                }
            });
        }
        return result;
    }

    public static final <V> V mapToBean(Map<String, Object> map, Class<V> clazz) {
        try {
            Constructor<V> constructor = ClassUtils.getConstructorIfAvailable(clazz);
            V bean = constructor.newInstance();
            //实现下划线转驼峰命名;
            Map<String, Object> result = new HashMap<>();
            map.forEach((s, o) -> {
                String key = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, s);
                result.put(key, o);
            });

            BeanMap.create(bean).putAll(result);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
