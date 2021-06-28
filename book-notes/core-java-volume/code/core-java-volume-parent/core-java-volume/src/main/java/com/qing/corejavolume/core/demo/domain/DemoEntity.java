package com.qing.corejavolume.core.demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qing.corejavolume.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * DemoEntity
 * 示例实体 (Data Object)
 * <p>
 *
 * @author: sunQB
 * @date: 2021-06-18 19:15
 * @since: JDK-1.8
 */

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("DEMO")
public class DemoEntity extends BaseEntity {


    /**
     * 用户姓名
     */
    @NotBlank(message = "用户姓名不能为空")
    @TableField(value = "USER_NAME")
    private String userName;

    /**
     * 用户编码
     */
    @NotBlank(message = "用户编码")
    @TableField(value = "USER_CODE")
    private String userCode;

    /**
     * 联系电话
     */
    @TableField(value = "TELEPHONE")
    private String telephone;

}
