package com.qing.corejavolume.common.utils;

import java.util.Date;

/**
 * DateTimeUtils
 *
 * <p>
 *
 * @author: sunQB
 * @date: 2021-06-18 18:03
 * @since: JDK-1.8
 */
public class DateTimeUtils {

    /**
     * 时区：东八区（中国）
     */
    public static final String TIME_ZONE_CN = "GMT+8";

    /**
     * 连接符
     */
    public static final String LINK_STRING_BLACK = " ";
    public static final String LINK_STRING_DASH = "-";
    public static final String LINK_STRING_COLON = ":";

    /**
     * 日期格式
     */
    public static final String FORMAT_JAVA_Y = "yyyy";
    public static final String FORMAT_JAVA_Y_M = "yyyy-MM";
    public static final String FORMAT_JAVA_Y_M_D = "yyyy-MM-dd";

    public static final String FORMAT_JAVA_Y_CN = "yyyy年";
    public static final String FORMAT_JAVA_Y_M_CN = "yyyy年MM月";
    public static final String FORMAT_JAVA_Y_M_D_CN = "yyyy年MM月dd日";

    /**
     * 时间格式
     */
    public static final String FORMAT_JAVA_H = "HH";
    public static final String FORMAT_JAVA_H_M = "HH:mm";
    public static final String FORMAT_JAVA_H_M_S = "HH:mm:ss";

    /**
     * 常用日期时间给格式
     */
    public static final String FORMAT_JAVA_Y_M_D__H = "yyyy-MM-dd HH";
    public static final String FORMAT_JAVA_Y_M_D__H_M = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_JAVA_Y_M_D__H_M_S = "yyyy-MM-dd HH:mm:ss";


    /**
     * 对比两个 Date 是否相等
     *
     * @param newDate 1
     * @param oldDate 2
     * @return boolean
     */
    public static boolean compareDate(Date newDate, Date oldDate) {
        if (newDate == null && oldDate == null) {
            return true;
        } else if (newDate == null || oldDate == null) {
            return false;
        }
        return newDate.compareTo(oldDate) == 0;
    }
}
