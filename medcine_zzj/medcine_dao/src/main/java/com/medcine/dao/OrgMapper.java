package com.medcine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medcine.base.entity.org.Org;
import com.medcine.base.entity.org.OrgPageBO;
import com.medcine.base.entity.org.OrgQO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author wkq
 * @date 2020/11/2 17:22
 */
@Mapper
public interface OrgMapper extends BaseMapper<Org> {

    List<OrgPageBO> pageQuery(OrgQO qo);

    Integer getCount(OrgQO qo);

    @Update("update org set is_delete = #{isDelete} where id = #{id}")
    Integer updateState(@Param("id") Long id, @Param("isDelete") Integer isDelete);

    @Select("select top 1 * from org where org_no = #{orgNo} and is_delete = #{isDelete}")
    Org selectByOrgNo(@Param("orgNo") String orgNo, @Param("isDelete") Integer isDelete);
}
