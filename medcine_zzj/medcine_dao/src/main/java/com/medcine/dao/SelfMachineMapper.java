package com.medcine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medcine.base.entity.zzj.SelfMachine;
import com.medcine.base.entity.zzj.SelfMachineQO;
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
public interface SelfMachineMapper extends BaseMapper<SelfMachine> {

    List<SelfMachine> pageQuery(SelfMachineQO qo);

    Integer getCount(SelfMachineQO qo);

    @Update("update self_machine set is_delete = #{isDelete} where id = #{id}")
    Integer updateStateById(@Param("id") Long id, @Param("isDelete") Integer isDelete);

    @Update("update self_machine set is_delete = #{isDelete} where org_no = #{orgNo}")
    Integer updateStateByOrgNo(@Param("orgNo") String orgNo, @Param("isDelete") Integer isDelete);

    @Select("select top 1 * from self_machine where org_no = #{orgNo} and machine_no = #{machineNo} and is_delete = #{isDelete}")
    SelfMachine selectByOne(String orgNo, String machineNo, Integer isDelete);

    @Update("update self_machine set org_no = #{orgNo,jdbcType=VARCHAR}, org_name = #{orgName,jdbcType=VARCHAR} where org_no = #{oldOrgNo,jdbcType=VARCHAR}")
    Integer updateOrgInfo(@Param("orgNo") String orgNo, @Param("orgName") String orgName, @Param("oldOrgNo") String oldOrgNo);
}
