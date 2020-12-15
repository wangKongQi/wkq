package com.medcine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medcine.base.entity.num.DoctorBO;
import com.medcine.base.entity.num.Numeral;
import com.medcine.base.entity.num.NumeralPageQO;
import com.medcine.base.entity.num.NumeralQO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author wkq
 * @date 2020/11/2 17:21
 */
@Mapper
public interface NumeralMapper extends BaseMapper<Numeral> {

    Integer getNum(NumeralQO qo);

    List<Numeral> pageQuery(NumeralPageQO qo);

    Integer getCount(NumeralPageQO qo);

    @Select("select person_no doctorNo, name from person where org_no = #{orgNo,jdbcType=VARCHAR} and depart_no = #{departNo,jdbcType=VARCHAR}")
    List<DoctorBO> getDoctorList(@Param("orgNo") String orgNo, @Param("departNo") String departNo);

    @Update("update numeral set is_delete = #{isDelete} where depart_no = #{departNo}")
    Integer updateStateByDepartNo(@Param("departNo") String departNo, @Param("isDelete") Integer isDelete);

    @Update("update numeral set is_delete = #{isDelete} where org_no = #{orgNo}")
    Integer updateStateByOrgNo(@Param("orgNo") String orgNo, @Param("isDelete") Integer isDelete);

    @Update("update numeral set is_delete = #{isDelete} where doctor_no = #{doctorNo}")
    Integer updateStateByDoctorNo(@Param("doctorNo") String doctorNo, @Param("isDelete") Integer isDelete);

    @Update("update numeral set org_no = #{orgNo,jdbcType=VARCHAR}, org_name = #{orgName,jdbcType=VARCHAR} where org_no = #{oldOrgNo,jdbcType=VARCHAR}")
    Integer updateOrgInfo(@Param("orgNo") String orgNo, @Param("orgName") String orgName, @Param("oldOrgNo") String oldOrgNo);

    @Update("update numeral set " +
            "depart_no = #{departNo,jdbcType=VARCHAR}, depart_name = #{departName,jdbcType=VARCHAR} " +
            "where org_no = #{orgNo,jdbcType=VARCHAR} and depart_no = #{oldDepartNo,jdbcType=VARCHAR}")
    Integer updateDepartInfo(@Param("departNo") String departNo, @Param("departName") String departName,
                             @Param("oldDepartNo") String oldDepartNo, @Param("orgNo") String orgNo);

    @Update("update numeral set " +
            "doctor_no = #{personNo,jdbcType=VARCHAR}, name = #{name,jdbcType=VARCHAR} " +
            "where org_no = #{orgNo,jdbcType=VARCHAR} and depart_no = #{departNo,jdbcType=VARCHAR}" +
            " and doctor_no = #{oldPersonNo,jdbcType=VARCHAR}")
    Integer updatePersonInfo(@Param("personNo") String personNo, @Param("name") String name, @Param("orgNo") String orgNo,
                             @Param("departNo") String departNo, @Param("oldPersonNo") String oldPersonNo);
}
