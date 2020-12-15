package com.medcine.base.entity.receipt;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wkq
 * @since 2020-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CheckReceiptDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("检验项目名称")
    private String itemName;

    @ApiModelProperty("检验项目结果")
    private String itemValue;

    @ApiModelProperty("结果提示")
    private String itemValueFlag;

    @ApiModelProperty("检验项目单位")
    private String itemUnit;

    @ApiModelProperty("参考值")
    private String itemRanges;

}
