package com.medcine.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medcine.base.entity.receipt.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author wkq
 * @since 2020-11-13
 */
@Mapper
public interface CheckReceiptMainMapper extends BaseMapper<CheckReceiptMain> {

    List<CheckReceiptListBO> getListByCard(@Param("idCardNo") String idCardNo);

    CheckReceiptBO getInfo(@Param("receiptMainSN") String receiptMainSN);

    List<CheckReceiptDetail> getDatailList(@Param("receiptMainSN") String receiptMainSN);

    @Update("update CheckReceiptMain set IsPrint = #{isPrint} where ReceiptMainSN = #{receiptMainSN}")
    Integer updateIsPrint(@Param("receiptMainSN") String receiptMainSN,@Param("isPrint") Integer isPrint);
}
