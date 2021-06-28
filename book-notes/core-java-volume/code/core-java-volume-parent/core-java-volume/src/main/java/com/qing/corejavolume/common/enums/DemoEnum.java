package com.qing.corejavolume.common.enums;

import lombok.Getter;

/**
 * DemoEnum
 * 示例枚举
 * <p>
 *
 * @author: sunQB
 * @date: 2021-06-18 18:46
 * @since: JDK-1.8
 */
@Getter
public enum DemoEnum {
    /**
     * demo 此处注释必须存在
     * code -- 编码
     * vale -- 值
     * desc -- 注释
     */
    Demo("Demo", "0","示例");

    private final String code;

    private final String value;

    private final String desc;

    DemoEnum(String code, String value, String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "DemoEnum{" +
                "code='" + code + '\'' +
                ", value='" + value + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

}
