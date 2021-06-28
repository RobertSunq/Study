package com.qing.corejavolume.core.demo.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * DemoEntityVo
 * 示例实体 -- 显示层对象 (View Object)
 * <p>
 *
 * @author: sunQB
 * @date: 2021-06-18 19:16
 * @since: JDK-1.8
 */
@Data
public class DemoEntityVo {

    /**
     * 主键id
     */
    private String id;

    /**
     * 排序值
     */
    private Long sortValue;

    /**
     * 创建人Id
     */
    private String createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人Id
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 标志位
     */
    private String sysFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 联系电话
     */
    private String telephone;


}
