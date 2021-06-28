package com.qing.corejavolume.common.core.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.qing.corejavolume.common.utils.DateTimeUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * BaseEntity
 * 基础实体对象  -- 系统级
 * <p>
 *
 * @author: sunQB
 * @date: 2021-06-18 19:50
 * @since: JDK-1.8
 */

public class BaseEntity implements Serializable {


    /**
     * 相关注解说明
     * <p>
     * JsonSerialize    序列化
     * 序列化时，需要获取数据，那么需要使用到 getXxx() 方法，所以通常将注解添加到对应的 get 方法上，若使用了 Lombok 需要自己定义相应的 get 方法。
     * 需要使用 using 属性指定处理参数的类，该类需要继承 JsonSerializer 类，并重写 serialize()。
     * <p>
     * JsonDeserialize  反序列化
     * 反序列化时，对参数进行封装，故用到的是 setXxx() 方法，所以通常将注解添加到对应的 set 方法上，若使用了 Lombok 需要自己定义相应的 set 方法。
     * 需要使用 using 属性指定处理参数的类，该类需要继承 JsonDeserializer 类，并重写 deserialize()。
     * <p>
     * serialVersionUID     适用于java序列化机制
     * JAVA序列化的机制：通过判断类的serialVersionUID来验证的版本是否一致。
     * 序列化操作时会把系统当前类的serialVersionUID写入到序列化文件中。
     * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较。
     * 如果相同说明是一致的，就可以进行反序列化，否则就会出现反序列化版本一致的异常，即：InvalidCastException。
     */
    private static final long serialVersionUID = 1L;


    /**
     * 主键id -- 系统字段
     */
    @TableField("ID")
    private String id;

    /**
     * 排序值 -- 系统字段
     */
    @TableField("SORT_VALUE")
    private Long sortValue;

    /**
     * 创建人Id -- 系统字段
     */
    @TableField("SYS_CREATE_USER")
    private String sysCreateUser;

    /**
     * 创建时间 -- 系统字段
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @DateTimeFormat(pattern = DateTimeUtils.FORMAT_JAVA_Y_M_D__H_M_S)
    @JsonFormat(timezone = DateTimeUtils.TIME_ZONE_CN, pattern = DateTimeUtils.FORMAT_JAVA_Y_M_D__H_M_S)
    @TableField("SYS_CREATE_TIME")
    private LocalDateTime sysCreateTime;

    /**
     * 更新人Id -- 系统字段
     */
    @TableField("SYS_UPDATE_USER")
    private String sysUpdateUser;

    /**
     * 更新时间 -- 系统字段
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @DateTimeFormat(pattern = DateTimeUtils.FORMAT_JAVA_Y_M_D__H_M_S)
    @JsonFormat(timezone = DateTimeUtils.TIME_ZONE_CN, pattern = DateTimeUtils.FORMAT_JAVA_Y_M_D__H_M_S)
    @TableField("SYS_UPDATE_TIME")
    private LocalDateTime sysUpdateTime;

    /**
     * 标志位 -- 系统字段
     */
    @TableField("SYS_FLAG")
    private String sysFlag;


    /**
     * 无参构造器
     */
    public BaseEntity() {
    }

    /**
     * 全参构造器
     *
     * @param id            主键id
     * @param sortValue     排序值
     * @param sysCreateUser 创建人Id
     * @param sysCreateTime 创建时间
     * @param sysUpdateUser 更新人Id
     * @param sysUpdateTime 更新时间
     * @param sysFlag       标志位
     */
    public BaseEntity(String id,
                      Long sortValue,
                      String sysCreateUser,
                      LocalDateTime sysCreateTime,
                      String sysUpdateUser,
                      LocalDateTime sysUpdateTime,
                      String sysFlag) {
        this.id = id;
        this.sortValue = sortValue;
        this.sysCreateUser = sysCreateUser;
        this.sysCreateTime = sysCreateTime;
        this.sysUpdateUser = sysUpdateUser;
        this.sysUpdateTime = sysUpdateTime;
        this.sysFlag = sysFlag;
    }

    public static long getSerialVersionUid() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSortValue() {
        return sortValue;
    }

    public void setSortValue(Long sortValue) {
        this.sortValue = sortValue;
    }

    public String getSysCreateUser() {
        return sysCreateUser;
    }

    public void setSysCreateUser(String sysCreateUser) {
        this.sysCreateUser = sysCreateUser;
    }

    public LocalDateTime getSysCreateTime() {
        return sysCreateTime;
    }

    public void setSysCreateTime(LocalDateTime sysCreateTime) {
        this.sysCreateTime = sysCreateTime;
    }

    public String getSysUpdateUser() {
        return sysUpdateUser;
    }

    public void setSysUpdateUser(String sysUpdateUser) {
        this.sysUpdateUser = sysUpdateUser;
    }

    public LocalDateTime getSysUpdateTime() {
        return sysUpdateTime;
    }

    public void setSysUpdateTime(LocalDateTime sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    public String getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
    }


    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                ", sortValue=" + sortValue +
                ", sysCreateUser='" + sysCreateUser + '\'' +
                ", sysCreateTime=" + sysCreateTime +
                ", sysUpdateUser='" + sysUpdateUser + '\'' +
                ", sysUpdateTime=" + sysUpdateTime +
                ", sysFlag='" + sysFlag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseEntity)) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id) &&
                Objects.equals(sortValue, that.sortValue) &&
                Objects.equals(sysCreateUser, that.sysCreateUser) &&
                Objects.equals(sysCreateTime, that.sysCreateTime) &&
                Objects.equals(sysUpdateUser, that.sysUpdateUser) &&
                Objects.equals(sysUpdateTime, that.sysUpdateTime) &&
                Objects.equals(sysFlag, that.sysFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sortValue, sysCreateUser, sysCreateTime, sysUpdateUser, sysUpdateTime, sysFlag);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // todo 待重写
        return super.clone();
    }


}
