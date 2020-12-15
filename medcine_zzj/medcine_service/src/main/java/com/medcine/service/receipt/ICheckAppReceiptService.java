package com.medcine.service.receipt;

import com.baomidou.mybatisplus.extension.service.IService;
import com.medcine.base.entity.receipt.CheckAppReceipt;
import com.medcine.base.entity.receipt.CheckReceiptListBO;

import java.util.List;

/**
 * @author wkq
 * @since 2020-11-16
 */
public interface ICheckAppReceiptService extends IService<CheckAppReceipt> {

    /**
     * 根据健康卡卡号获取报告单
     *
     * @param healthCardNo
     * @author wkq
     * @date 2020/11/16 14:06
     * @return java.util.List<com.medcine.base.entity.receipt.CheckReceiptListBO>
     */
    List<CheckReceiptListBO> getListByHealthCardNo(String healthCardNo) throws Exception;

    /**
     * 根据条码号获取报告单
     *
     * @param receiptAppCode
     * @author wkq
     * @date 2020/11/16 14:06
     * @return java.util.List<com.medcine.base.entity.receipt.CheckReceiptListBO>
     */
    List<CheckReceiptListBO> getListByReceiptAppCode(String receiptAppCode) throws Exception;
}
