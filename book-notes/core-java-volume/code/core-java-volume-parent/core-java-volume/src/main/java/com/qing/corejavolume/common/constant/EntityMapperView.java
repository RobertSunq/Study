package com.qing.corejavolume.common.constant;

import java.util.List;

/**
 * EntityMapperView
 * viewObject 映射器
 * <p>
 *
 * @param <V> 映射对象 viewObject
 * @param <E> 实体对象 entityObject
 * @author: sunQB
 * @date: 2021-06-18 18:42
 * @since: JDK-1.8
 */
public interface EntityMapperView<V, E> {
    /**
     * 单一映射 V-->E
     *
     * @param vo V
     * @return E
     */
    E toEntity(V vo);

    /**
     * 单一映射 E-->V
     *
     * @param entity E
     * @return V
     */
    V toVo(E entity);

    /**
     * 多条数据映射 V-->E
     *
     * @param voList voList
     * @return entityList
     */
    List<E> toEntity(List<V> voList);

    /**
     * 多条数据映射 E-->V
     *
     * @param entityList entityList
     * @return voList
     */
    List<V> toVo(List<E> entityList);
}
