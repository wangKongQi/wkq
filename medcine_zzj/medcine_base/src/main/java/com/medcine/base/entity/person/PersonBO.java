package com.medcine.base.entity.person;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "医生信息")
public class PersonBO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "人员工号" ,required = true)
    private String personNo;

    @ApiModelProperty(value = "姓名" ,required = true)
    private String name;  //姓名

    @ApiModelProperty(value = "介绍" ,required = true)
    private String introduce;  //介绍

    @ApiModelProperty(value = "技术级别" ,required = true)
    private Long jxLevel;  //技术级别

    @ApiModelProperty(value = "技术级别名称" ,required = true)
    private String jxLevelName;  //技术级别

    @ApiModelProperty(value = "人员图片")
    private List<String> imgPaths;;  //人员图片
}