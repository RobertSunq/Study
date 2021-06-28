package com.qing.corejavolume.common.utils;

import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;

/**
 * CommonUtils
 * 公共工具类 (暂时未进行分类的统一放入这里)
 * <p>
 *
 * @author: sunQB
 * @date: 2021-06-22 20:09
 * @since: JDK-1.8
 */
public class CommonUtils {



    /**
     * 对比两个 BigDecimal 是否相等
     *
     * @param newBigDecimal 1
     * @param oldBigDecimal 2
     * @return boolean
     */
    public static boolean compareBigDecimal(BigDecimal newBigDecimal, BigDecimal oldBigDecimal) {
        if (newBigDecimal == null && oldBigDecimal == null) {
            return true;
        } else if (newBigDecimal == null || oldBigDecimal == null) {
            return false;
        }
        return newBigDecimal.compareTo(oldBigDecimal) == 0;
    }

}
