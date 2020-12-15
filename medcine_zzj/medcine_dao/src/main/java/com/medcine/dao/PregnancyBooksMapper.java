package com.medcine.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medcine.base.entity.book.PregnancyBooks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wkq
 * @since 2020-11-16
 */
@Mapper
public interface PregnancyBooksMapper extends BaseMapper<PregnancyBooks> {

    /**
     * 根据健康卡卡号获取主键code
     *
     * @param healthCardNo
     * @author wkq
     * @date 2020/11/16 14:02
     * @return java.lang.String
     */
    @Select("select NewlyDiagnosedCode newlyDiagnosedCode from PregnancyBooks where HealthCardNo = #{healthCardNo}")
    String getNewlyDiagnosedCodeByHealthCardNo(@Param("healthCardNo") String healthCardNo);
}
