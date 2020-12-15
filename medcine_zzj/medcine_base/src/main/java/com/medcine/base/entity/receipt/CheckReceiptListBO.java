package com.medcine.base.entity.receipt;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wkq
 * @since 2020-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("报告单列表")
public class CheckReceiptListBO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("报告单id")
    private String receiptMainSN;

    @ApiModelProperty("患者姓名")
    private String name;

    @ApiModelProperty("检查科室")
    private String appDept;

    @ApiModelProperty("检查项目")
    private String checkItems;

    @ApiModelProperty("检查时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime extTime2;

    @ApiModelProperty("打印标志")
    private Integer isPrint;
}
