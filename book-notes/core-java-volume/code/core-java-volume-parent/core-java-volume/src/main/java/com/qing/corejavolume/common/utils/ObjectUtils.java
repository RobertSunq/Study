package com.qing.corejavolume.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.qing.corejavolume.common.utils.CommonUtils.compareBigDecimal;
import static com.qing.corejavolume.common.utils.DateTimeUtils.compareDate;

/**
 * ObjectUtils
 * 对象工具类
 * <p>
 *
 * @author: sunQB
 * @date: 2021-06-22 20:21
 * @since: JDK-1.8
 */
@Slf4j
public class ObjectUtils {

    /**
     * 对比两个实体是否相等
     * 目前仅支持对  String Date BigDecimal 三个类型的对比，其他类型调用其对应的equals()方法
     * @param newObj 新的实体对象
     * @param oldObj 老的实体对象
     * @param filterColumnName 过滤字段名称字符串逗号连接
     * @return String
     */
    public static Boolean caseInfoWhetherModify(Object newObj, Object oldObj,String filterColumnName) {
        // 都为空则为未修改
        if (newObj == null && oldObj == null) {
            return true;
        }
        // 其中一个为空，则为修改
        else if (newObj == null || oldObj == null) {
            return false;
        }
        /// 开始判断所有的业务字段

        // 过滤条件为null的时候不做过滤
        if(null == filterColumnName){
            filterColumnName = "";
        }
        Set<String> filterSet = new HashSet<>(Arrays.asList(filterColumnName.split(",")));
        try {
            // 获取实体对象的指定过滤条件的属性
            Field[] fields = getAllFields(newObj, filterSet);
            for (Field field : fields) {
                // 不调用 访问安全检查
                field.setAccessible(true);
                // 对字段分类型对比
                if (field.getType() == String.class) {
                    if (!StringUtils.equals((String) field.get(newObj), (String) field.get(oldObj))) {
                        return false;
                    }
                }
                else if (field.getType() == BigDecimal.class){
                    if(!compareBigDecimal((BigDecimal) field.get(newObj),(BigDecimal)field.get(oldObj))){
                        return false;
                    }
                }
                else if (field.getType() == Date.class) {
                    if (!compareDate((Date) field.get(newObj), (Date) field.get(oldObj))) {
                        return false;
                    }
                }
                else {
                    if (field.get(newObj).equals(field.get(oldObj)) ) {
                        return false;
                    }
                }
            }
        } catch (IllegalAccessException e){
            log.error(e.toString());
        }
        return true;
    }


    /**
     * 获取指定对象的所有属性，包括父类，并根据过滤条件删除指定属性
     * @param object 对象实体
     * @param filter 过滤条件
     * @return Field[]
     */
    public static Field[] getAllFields(Object object , Set<String> filter) {
        // 获取当前对象实体
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        // 遍历获取本身以及所有父类的属性
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        // 根据filter过滤条件删除不需要的属性
        List<Field> fieldListFilter = fieldList.stream().filter(e -> !filter.contains(e.getName())).collect(Collectors.toList());
        Field[] fields = new Field[fieldListFilter.size()];
        fieldListFilter.toArray(fields);
        return fields;
    }
}
