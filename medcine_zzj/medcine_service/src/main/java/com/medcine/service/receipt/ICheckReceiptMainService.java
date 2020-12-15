package com.medcine.service.receipt;


import com.medcine.base.entity.receipt.CheckReceiptBO;
import com.medcine.base.entity.receipt.CheckReceiptListBO;
import com.medcine.base.entity.receipt.CheckReceiptMainUpdatePrintStateDTO;

import java.util.List;

/**
 * @author wkq
 * @since 2020-11-13
 */
public interface ICheckReceiptMainService {

    /**
     * 根据身份证号去查询报告单
     *
     * @param idCardNo
     * @author wkq
     * @date 2020/11/11 15:18
     * @return java.util.List<com.medcine.base.entity.lis.GWLISReportPageBO>
     */
    List<CheckReceiptListBO> getListByCard(String idCardNo) throws Exception;

    /**
     * 妇幼获取报告单详情
     *
     * @param receiptMainSN
     * @author wkq
     * @date 2020/11/11 15:44
     * @return
     */
    CheckReceiptBO getInfo(String receiptMainSN) throws Exception;

    /**
     * 编辑打印状态
     *
     * @param dto
     * @author wkq
     * @date 2020/11/30 16:56
     * @return java.lang.Integer
     */
    Integer updateIsPrint(CheckReceiptMainUpdatePrintStateDTO dto);
}
