package com.medcine.base.entity.num;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wkq
 * @date 2020/12/2 8:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "科室医生信息")
public class DoctorBO implements Serializable {

    @ApiModelProperty(value = "医生编号")
    private String doctorNo;  //医生编号

    @ApiModelProperty(value = "医生姓名")
    private String name;  //医生姓名
}
