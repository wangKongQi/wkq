package com.medcine.base.entity.zzj;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SelfMachine implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自助机id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "自助机编码", required = true)
    @NotEmpty(message = "自助机编码不能为空")
    private String machineNo;//自助机编码

    @ApiModelProperty(value = "自助机名称", required = true)
    @NotEmpty(message = "自助机名称不能为空")
    private String machineName;  //名称

    @ApiModelProperty(value = "厂家", required = true)
    @NotEmpty(message = "厂家不能为空")
    private String factory;  //厂家

    @ApiModelProperty(value = "型号", required = true)
    @NotEmpty(message = "型号不能为空")
    private String model;  //型号

    @ApiModelProperty(value = "取号小票", required = true)
    @NotEmpty(message = "取号小票不能为空")
    private String numReceipts;  //取号小票

    @ApiModelProperty(value = "报告单", required = true)
    @NotEmpty(message = "报告单不能为空")
    private String report;  //报告单

    @ApiModelProperty(value = "机构编号", required = true)
    @NotEmpty(message = "机构编号不能为空")
    private String orgNo;  //机构编号

    @ApiModelProperty(value = "机构名称", required = true)
    @NotEmpty(message = "机构名称不能为空")
    private String orgName;  //机构名称

    @ApiModelProperty(value = "是否启用" , example = "1")
    private Integer isDelete;  //是否启用
}