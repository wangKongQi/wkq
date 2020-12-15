package com.medcine.service.receipt.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medcine.base.entity.receipt.CheckAppReceipt;
import com.medcine.base.entity.receipt.CheckReceiptListBO;
import com.medcine.dao.CheckAppReceiptMapper;
import com.medcine.dao.PregnancyBooksMapper;
import com.medcine.service.receipt.ICheckAppReceiptService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkq
 * @since 2020-11-16
 */
@Service
@DS("WeiKangaqfybj")
public class CheckAppReceiptServiceImpl extends ServiceImpl<CheckAppReceiptMapper, CheckAppReceipt> implements ICheckAppReceiptService {

    @Resource
    private CheckAppReceiptMapper checkAppReceiptMapper;

    @Resource
    private PregnancyBooksMapper pregnancyBooksMapper;

    @Override
    @DS("slave_1")
    public List<CheckReceiptListBO> getListByHealthCardNo(String healthCardNo) throws Exception {
        //根据健康卡卡号获取信息
        String newlyDiagnosedCode = pregnancyBooksMapper.getNewlyDiagnosedCodeByHealthCardNo(healthCardNo);
        List<CheckReceiptListBO> list = null;
        if (StringUtils.isNoneEmpty(newlyDiagnosedCode)) {
            String CZPHBId = "CZPHBId:" + newlyDiagnosedCode;
            String FZPHBId = "FZPHBId:" + newlyDiagnosedCode;
            list = checkAppReceiptMapper.getListByHealthCardNo(CZPHBId, FZPHBId);
        }
        return list;
    }

    @Override
    @DS("slave_1")
    public List<CheckReceiptListBO> getListByReceiptAppCode(String receiptAppCode) throws Exception {
        return checkAppReceiptMapper.getListByReceiptAppCode(receiptAppCode);
    }
}
