package com.medcine.service.receipt.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.medcine.base.entity.receipt.CheckReceiptBO;
import com.medcine.base.entity.receipt.CheckReceiptDetail;
import com.medcine.base.entity.receipt.CheckReceiptListBO;
import com.medcine.base.entity.receipt.CheckReceiptMainUpdatePrintStateDTO;
import com.medcine.dao.CheckReceiptMainMapper;
import com.medcine.service.receipt.ICheckReceiptMainService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author wkq
 * @since 2020-11-13
 */
@Service
@DS("WeiKangaqfybj")
public class CheckReceiptMainServiceImpl implements ICheckReceiptMainService {

    @Resource
    private CheckReceiptMainMapper checkReceiptMainMapper;

    @Override
    @DS("slave_1")
    public List<CheckReceiptListBO> getListByCard(String idCardNo) throws Exception {
        return checkReceiptMainMapper.getListByCard(idCardNo);
    }

    @Override
    @DS("slave_1")
    public CheckReceiptBO getInfo(String receiptMainSN) throws Exception {
        CheckReceiptBO data = checkReceiptMainMapper.getInfo(receiptMainSN);
        List<CheckReceiptDetail> list = checkReceiptMainMapper.getDatailList(receiptMainSN);
        data.setDetails(list);
        return data;
    }

    @Override
    @DS("slave_1")
    @Transactional
    public Integer updateIsPrint(CheckReceiptMainUpdatePrintStateDTO dto) {
        Integer n = 0;
        Arrays.asList(dto.getReceiptMainSN().split(",")).forEach(receiptMainSN -> {
            //获取图片路径
            if (StringUtils.isNotBlank(receiptMainSN)) {
                checkReceiptMainMapper.updateIsPrint(receiptMainSN, dto.getIsPrint());
            }
        });
        return 1;
    }

//    public static void main(String[] args) {
//        HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
//        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
//        //查找所有的可用的打印服务
//        PrintService[] printService = PrintServiceLookup.lookupPrintServices(flavor, pras);
//
//        for (int i =0; i<printService.length ;i++ )
//        {
//            System.out.println(printService[i].getName());
//        }
//    }
}
