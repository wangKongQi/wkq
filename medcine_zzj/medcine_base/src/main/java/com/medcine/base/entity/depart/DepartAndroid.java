package com.medcine.base.entity.depart;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author wkq
 * @date 2020/11/2 17:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "科室目录信息")
public class DepartAndroid implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "科室类别编码" ,required = true)
    private Long categoryCode;  //科室类别

    @ApiModelProperty(value = "科室类别名称" ,required = true)
    private String categoryName;  //科室类别

    @ApiModelProperty(value = "科室分类编码" ,required = true)
    private String classifyCode;  //科室分类

    @ApiModelProperty(value = "科室分类名称" ,required = true)
    private String classifyName;  //科室分类

    @ApiModelProperty(value = "科室集合" ,required = true)
    private List<DepartAndroidBO> departs;
}