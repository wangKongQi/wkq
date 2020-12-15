package com.medcine.base.entity.zzj;

import com.medcine.utils.form.PageForm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SelfMachineQO extends PageForm<SelfMachineQO> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自助机编码")
    private String machineNo;//自助机编码

    @ApiModelProperty(value = "自助机名称")
    private String machineName;  //名称

    @ApiModelProperty(value = "厂家")
    private String factory;  //厂家

    @ApiModelProperty(value = "型号")
    private String model;  //型号

    @ApiModelProperty(value = "取号小票")
    private String numReceipts;  //取号小票

    @ApiModelProperty(value = "报告单")
    private String report;  //报告单

    @ApiModelProperty(value = "机构编号")
    private String orgNo;  //机构编号

    @ApiModelProperty(value = "机构名称")
    private String orgName;  //机构编号
}