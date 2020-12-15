package com.medcine.base.entity.num;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "排号信息")
public class Numeral implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "排号id")
    @TableId(type = IdType.AUTO)
    private Long numId;  //排号id

    @ApiModelProperty(value = "机构编码")
    @NotNull(message = "机构编码不能为空")
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "机构名称")
    @NotNull(message = "机构名称不能为空")
    private String orgName;  //机构名称

    @ApiModelProperty(value = "科室编码")
    @NotNull(message = "科室编码不能为空")
    private String departNo;  //科室编码

    @ApiModelProperty(value = "科室名称")
    @NotNull(message = "科室名称不能为空")
    private String departName;  //科室名称

    @ApiModelProperty(value = "医生编号")
    @NotNull(message = "医生编号不能为空")
    private String doctorNo;  //医生编号

    @ApiModelProperty(value = "医生姓名")
    @NotNull(message = "医生姓名不能为空")
    private String name;  //医生姓名

    @ApiModelProperty(value = "当前号", example = "11")
    private Integer nowNum;  //当前号

    @ApiModelProperty(value = "排号日期", example = "2020-11-04")
    @NotNull(message = "排号日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date numDate;  //排号日期

    @ApiModelProperty(value = "取号时间", example = "2020-11-04 14:41:00")
    @NotNull(message = "取号时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date takeNumTime;  //取号时间

}