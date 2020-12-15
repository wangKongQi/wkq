package com.medcine.base.entity.depart;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author wkq
 * @date 2020/11/2 17:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "科室信息")
public class Depart implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "科室id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "科室编码" ,required = true)
    @NotEmpty(message = "科室编码不能为空")
    private String departNo;//科室编码

    @ApiModelProperty(value = "科室名称" ,required = true)
    @NotEmpty(message = "科室名称不能为空")
    private String departName;  //科室名称

    @ApiModelProperty(value = "科室类别编码" ,required = true, example = "10021")
    @NotNull(message = "科室类别编码不能为空")
    private Long categoryCode;  //科室类别

    @ApiModelProperty(value = "科室类别名称" ,required = true)
    @NotNull(message = "科室类别名称不能为空")
    private String categoryName;  //科室类别

    @ApiModelProperty(value = "科室分类编码" ,required = true)
    @NotNull(message = "科室类别编码不能为空")
    private String classifyCode;  //科室分类

    @ApiModelProperty(value = "科室分类名称" ,required = true)
    @NotNull(message = "科室分类名称不能为空")
    private String classifyName;  //科室分类

    @ApiModelProperty(value = "科室负责人")
    @NotEmpty(message = "科室负责人不能为空")
    private String personName;  //科室负责人

    @ApiModelProperty(value = "科室联系电话" ,required = true)
    @NotEmpty(message = "科室联系电话不能为空")
    private String departTel;  //科室联系电话

    @ApiModelProperty(value = "是否参与排号" ,required = true, example = "1")
    @NotNull(message = "是否参与排号不能为空")
    private Integer isNum;  //是否参与排号

    @ApiModelProperty(value = "是否启用" , example = "1")
    private Integer isEnable;  //是否启用

    @ApiModelProperty(value = "科室简介" ,required = true)
    @NotEmpty(message = "科室简介不能为空")
    private String departDesc; //科室简介

    @ApiModelProperty(value = "机构编码", required = true)
    @NotEmpty(message = "机构编码不能为空")
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "机构名称", required = true)
    @NotEmpty(message = "机构名称不能为空")
    private String orgName;  //机构名称
}