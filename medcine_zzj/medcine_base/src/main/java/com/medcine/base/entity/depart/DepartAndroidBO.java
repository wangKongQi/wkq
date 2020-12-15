package com.medcine.base.entity.depart;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wkq
 * @date 2020/11/2 17:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "科室")
public class DepartAndroidBO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "科室编码" ,required = true)
    private String departNo;//科室编码

    @ApiModelProperty(value = "科室名称" ,required = true)
    private String departName;  //科室名称

}