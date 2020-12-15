package com.medcine.controller;


import com.medcine.base.entity.receipt.CheckReceiptBO;
import com.medcine.base.entity.receipt.CheckReceiptListBO;
import com.medcine.base.entity.receipt.CheckReceiptMainUpdatePrintStateDTO;
import com.medcine.service.receipt.ICheckAppReceiptService;
import com.medcine.service.receipt.ICheckReceiptMainService;
import com.medcine.utils.common.ResultVoUtil;
import com.medcine.utils.enums.ResultEnum;
import com.medcine.utils.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wkq
 * @since 2020-11-11
 */
@RestController
@RequestMapping("/gw/lis/report")
@Api(tags = "报告单")
@CrossOrigin
public class ReportMainController {

    @Resource
    private ICheckReceiptMainService checkService;

    @Resource
    private ICheckAppReceiptService appReceiptService;

    @ApiOperation("根据身份证号获取报告单列表")
    @GetMapping("/list/one")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = CheckReceiptListBO.class)
    )
    public ResultVo getListByIdCardNo(@RequestParam("idCardNo") String idCardNo) throws Exception {
        if (StringUtils.isEmpty(idCardNo)) {
            return ResultVoUtil.error("身份证号不能为空");
        }
        return ResultVoUtil.success(checkService.getListByCard(idCardNo));
    }

    @ApiOperation("根据健康卡卡号获取报告单列表")
    @GetMapping("/list/two")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = CheckReceiptListBO.class)
    )
    public ResultVo getListByBarCode(@RequestParam("healthCardNo") String healthCardNo) throws Exception {
        if (StringUtils.isEmpty(healthCardNo)) {
            return ResultVoUtil.error("健康卡卡号不能为空");
        }
        return ResultVoUtil.success(appReceiptService.getListByHealthCardNo(healthCardNo));
    }

    @ApiOperation("根据条码号获取报告单列表")
    @GetMapping("/list/three")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = CheckReceiptListBO.class)
    )
    public ResultVo getListByReceiptAppCode(@RequestParam("receiptAppCode") String receiptAppCode) throws Exception {
        if (StringUtils.isEmpty(receiptAppCode)) {
            return ResultVoUtil.error("条码号不能为空");
        }
        return ResultVoUtil.success(appReceiptService.getListByReceiptAppCode(receiptAppCode));
    }

    @ApiOperation("获取打印详情")
    @GetMapping("/get")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = CheckReceiptBO.class)
    )
    public ResultVo getInfo(@RequestParam("receiptMainSN") String receiptMainSN) throws Exception {
        return ResultVoUtil.success(checkService.getInfo(receiptMainSN));
    }

    @ApiOperation("打印编辑")
    @PutMapping("/update/isPrint")
    public ResultVo updateIsPrint(@Validated @RequestBody CheckReceiptMainUpdatePrintStateDTO dto) throws Exception {
        Integer n = checkService.updateIsPrint(dto);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else {
            return ResultVoUtil.error(ResultEnum.UPDATE_ERROR);
        }
    }

}
