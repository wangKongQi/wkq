package com.medcine.base.entity.receipt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author wkq
 * @date 2020/11/30 16:53
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "编辑打印状态")
public class CheckReceiptMainUpdatePrintStateDTO {

    @ApiModelProperty("报告单id")
    @NotEmpty(message = "报告单id不能为空")
    private String receiptMainSN;

    @ApiModelProperty("打印标志")
    @NotNull(message = "打印标志不能为空")
    private Integer isPrint;

}
