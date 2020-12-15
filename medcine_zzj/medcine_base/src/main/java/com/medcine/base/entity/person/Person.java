package com.medcine.base.entity.person;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "人员信息")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "人员id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "人员工号" ,required = true)
    @NotEmpty(message = "人员工号不能为空")
    private String personNo;

    @ApiModelProperty(value = "姓名" ,required = true)
    @NotEmpty(message = "姓名不能为空")
    private String name;  //姓名

    @ApiModelProperty(value = "性别" ,required = true)
    @NotNull(message = "性别不能为空")
    private Long sex;  //性别

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    @ApiModelProperty(value = "出生年月" ,required = true, example = "1994-06-01")
    @NotNull(message = "出生年月不能为空")
    private Date birthday;  //出生年月

    @ApiModelProperty(value = "身份证号" ,required = true)
    @NotEmpty(message = "身份证号不能为空")
    private String idCardNo;  //身份证号

    @ApiModelProperty(value = "密码" ,required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;  //密码

    @ApiModelProperty(value = "介绍" ,required = true)
    @NotEmpty(message = "介绍不能为空")
    private String introduce;  //介绍

    @ApiModelProperty(value = "机构编码", required = true)
    @NotEmpty(message = "机构编码不能为空")
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "机构名称", required = true)
    @NotEmpty(message = "机构名称不能为空")
    private String orgName;  //机构名称

    @ApiModelProperty(value = "科室编码" ,required = true)
    @NotEmpty(message = "科室编码不能为空")
    private String departNo;  //科室编码

    @ApiModelProperty(value = "科室名称" ,required = true)
    @NotEmpty(message = "科室名称不能为空")
    private String departName;  //科室名称

    @ApiModelProperty(value = "行政级别")
    private Long xzLevel;  //行政级别

    @ApiModelProperty(value = "技术级别" ,required = true, example = "1001211")
    @NotNull(message = "技术级别不能为空")
    private Long jxLevel;  //技术级别

    @ApiModelProperty(value = "联系方式" ,required = true)
    @NotEmpty(message = "联系方式不能为空")
    private String tel;  //联系方式

    @ApiModelProperty(value = "在岗状态" ,required = true, example = "1")
    @NotNull(message = "在岗状态不能为空")
    private Long zgState;  //在岗状态

    @ApiModelProperty(value = "是否参与排号" ,required = true, example = "1")
    @NotNull(message = "是否参与排号不能为空")
    private Integer isNum;  //是否参与排号

    @ApiModelProperty(value = "人员图片")
    private String imgArray;  //人员图片

    @ApiModelProperty(value = "人员等级")
    private Integer permissions = 1;
}