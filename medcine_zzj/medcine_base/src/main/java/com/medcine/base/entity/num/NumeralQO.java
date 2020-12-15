package com.medcine.base.entity.num;

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
public class NumeralQO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构编码")
    @NotNull(message = "机构编码不能为空")
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "科室编码")
    @NotNull(message = "科室编码不能为空")
    private String departNo;  //科室编码

    @ApiModelProperty(value = "医生编号")
    @NotNull(message = "医生编号不能为空")
    private String doctorNo;  //医生编号

    @ApiModelProperty(value = "排号日期", example = "2020-11-04")
    @NotNull(message = "排号日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date numDate;  //排号日期

    @ApiModelProperty(value = "排号日期", example = "2020-11-04")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date numDateEnd;  //排号日期

}