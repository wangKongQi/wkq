package com.medcine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medcine.base.entity.person.Person;
import com.medcine.base.entity.person.PersonPageBO;
import com.medcine.base.entity.person.PersonQO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wkq
 * @date 2020/11/2 17:22
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {

    List<PersonPageBO> pageQuery(PersonQO qo);

    Person getInfo(@Param("personNo") String personNo, @Param("password") String password);

    Integer getCount(PersonQO qo);

    @Delete("delete from person where org_no = #{orgNo}")
    Integer deleteByOrgNo(@Param("orgNo") String orgNo);

    @Update("update person set is_delete = #{isDelete} where id = #{id}")
    Integer updateStateById(@Param("id") Long id, @Param("isDelete") Integer isDelete);

    @Update("update person set is_delete = #{isDelete} where org_no = #{orgNo}")
    Integer updateStateByOrgNo(@Param("orgNo") String orgNo, @Param("isDelete") Integer isDelete);

    @Update("update person set is_delete = #{isDelete} where depart_no = #{departNo}")
    Integer updateStateByDepartNo(@Param("departNo") String departNo, @Param("isDelete") Integer isDelete);

    @Update("update person set password=#{password} where id=#{id}")
    Integer updatePassword(@Param("id") Long id, @Param("password") String password);

    @Select("select top 1 * from person where org_no = #{orgNo} and depart_no = #{departNo} and person_no = #{personNo} and is_delete = #{isDelete}")
    Person selectByOne(@Param("orgNo") String orgNo, @Param("departNo") String departNo, @Param("personNo") String personNo, @Param("isDelete") Integer isDelete);

    @Update("update person set org_no = #{orgNo,jdbcType=VARCHAR}, org_name = #{orgName,jdbcType=VARCHAR} where org_no = #{oldOrgNo,jdbcType=VARCHAR}")
    Integer updateOrgInfo(@Param("orgNo") String orgNo, @Param("orgName") String orgName, @Param("oldOrgNo") String oldOrgNo);

    @Update("update person set " +
            "depart_no = #{departNo,jdbcType=VARCHAR}, depart_name = #{departName,jdbcType=VARCHAR} " +
            "where org_no = #{orgNo,jdbcType=VARCHAR} and depart_no = #{oldDepartNo,jdbcType=VARCHAR}")
    Integer updateDepartInfo(@Param("departNo") String departNo, @Param("departName") String departName,
                             @Param("oldDepartNo") String oldDepartNo, @Param("orgNo") String orgNo);
}
