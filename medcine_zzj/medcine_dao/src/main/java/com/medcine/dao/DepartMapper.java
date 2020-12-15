package com.medcine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medcine.base.entity.depart.Depart;
import com.medcine.base.entity.depart.DepartAndroid;
import com.medcine.base.entity.depart.DepartAndroidBO;
import com.medcine.base.entity.depart.DepartQO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author wkq
 * @date 2020/11/2 17:20
 */
@Mapper
public interface DepartMapper extends BaseMapper<Depart> {

    List<Depart> pageByQuery(DepartQO qo);

    Integer getCount(DepartQO qo);

    List<DepartAndroid> getList(@Param("orgNo") String orgNo, @Param("categoryCode") Long categoryCode);

    List<DepartAndroidBO> getByClassify(@Param("orgNo") String orgNo, @Param("categoryCode") Long categoryCode, @Param("classifyCode") String classifyCode);

    @Update("update depart set is_delete = #{isDelete} where id = #{id}")
    Integer updateStateById(@Param("id") Long id, @Param("isDelete") Integer isDelete);

    @Update("update depart set is_delete = #{isDelete} where org_no = #{orgNo}")
    Integer updateStateByOrgNo(@Param("orgNo") String orgNo, @Param("isDelete") Integer isDelete);

    @Select("select top 1 * from depart where org_no = #{orgNo,jdbcType=VARCHAR} and depart_no = #{departNo,jdbcType=VARCHAR} and is_delete = #{isDelete} ")
    Depart selectByOne(@Param("orgNo") String orgNo, @Param("departNo") String departNo, @Param("isDelete") Integer isDelete);

    @Update("update depart set org_no = #{orgNo,jdbcType=VARCHAR}, org_name = #{orgName,jdbcType=VARCHAR} where org_no = #{oldOrgNo,jdbcType=VARCHAR}")
    Integer updateOrgInfo(@Param("orgNo") String orgNo, @Param("orgName") String orgName, @Param("oldOrgNo") String oldOrgNo);
}
