package com.medcine.base.entity.receipt;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wkq
 * @since 2020-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "报告单详情")
public class CheckReceiptBO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "医疗机构名称")
    private String sendToHospName;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "身份证号")
    private String idCardNo;

    @ApiModelProperty(value = "样本号")
    private String sampleCode;

    @ApiModelProperty(value = "开单科室名称")
    private String appDept;

    @ApiModelProperty(value = "床号")
    private String bedNo;

    @ApiModelProperty(value = "诊断名称")
    private String diagnosis;

    @ApiModelProperty(value = "送检医生姓名")
    private String appdoctor;

    @ApiModelProperty(value = "结果医生姓名")
    private String extdoctor;

    @ApiModelProperty(value = "送检时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime appTime;

    @ApiModelProperty(value = "结果时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime exeTime2;

    @ApiModelProperty(value = "报告单项目明细")
    private List<CheckReceiptDetail> details;

}
