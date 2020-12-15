package com.medcine.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medcine.base.entity.receipt.CheckAppReceipt;
import com.medcine.base.entity.receipt.CheckReceiptListBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wkq
 * @since 2020-11-16
 */
@Mapper
public interface CheckAppReceiptMapper extends BaseMapper<CheckAppReceipt> {

    /**
     * 根据健康卡卡号查询报告单
     *
     * @param CZPHBId
     * @param FZPHBId
     * @return java.util.List<com.medcine.base.entity.receipt.CheckReceiptListBO>
     * @author wkq
     * @date 2020/11/16 15:12
     */
    List<CheckReceiptListBO> getListByHealthCardNo(@Param("CZPHBId") String CZPHBId, @Param("FZPHBId") String FZPHBId);

    /**
     * 根据条码号查询报告单
     *
     * @param receiptAppCode
     * @return java.util.List<com.medcine.base.entity.receipt.CheckReceiptListBO>
     * @author wkq
     * @date 2020/11/16 15:12
     */
    List<CheckReceiptListBO> getListByReceiptAppCode(@Param("receiptAppCode") String receiptAppCode);
}
