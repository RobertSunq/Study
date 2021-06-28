package com.qing.corejavolume.core.demo.domain.mapping;

import com.qing.corejavolume.common.constant.EntityMapperView;
import com.qing.corejavolume.core.demo.domain.DemoEntity;
import com.qing.corejavolume.core.demo.domain.vo.DemoEntityVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * DemoEntityMapping
 *
 * <p>
 *
 * @author: sunQB
 * @date: 2021-06-18 17:29
 * @since: JDK-1.8
 */

@Mapper(componentModel = "spring", uses = {})
public interface DemoEntityMapping extends EntityMapperView<DemoEntityVo, DemoEntity> {




    @Override
    @Mappings({
            @Mapping(source = "createUser", target = "sysCreateUser"),
            @Mapping(source = "createTime", target = "sysCreateTime"),
            @Mapping(source = "updateUser", target = "sysUpdateUser"),
            @Mapping(source = "updateTime", target = "sysUpdateTime"),
            @Mapping(source = "name", target = "userName")
    })
    DemoEntity toEntity(DemoEntityVo vo);


    @Override
    @Mappings({
            @Mapping(source = "sysCreateUser", target = "createUser"),
            @Mapping(source = "sysCreateTime", target = "createTime"),
            @Mapping(source = "sysUpdateUser", target = "updateUser"),
            @Mapping(source = "sysUpdateTime", target = "updateTime"),
            @Mapping(source = "userName", target = "name")
    })
    DemoEntityVo toVo(DemoEntity entity);

}
