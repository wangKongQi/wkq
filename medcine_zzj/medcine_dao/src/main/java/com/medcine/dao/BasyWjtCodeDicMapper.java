package com.medcine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medcine.base.entity.code.BasyWjtCodeDic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wkq
 * @date 2020/11/5 9:01
 */
@Mapper
public interface BasyWjtCodeDicMapper extends BaseMapper<BasyWjtCodeDic> {

    List<BasyWjtCodeDic> selectByList(@Param("type") String type, @Param("parentCode") String parentCode);
}
