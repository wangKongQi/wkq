package com.medcine.base.entity.num;

import com.medcine.utils.form.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "排号分页请求参数")
public class NumeralPageQO extends PageForm<NumeralPageQO> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构编码")
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "科室编码")
    private String departNo;  //科室编码

    @ApiModelProperty(value = "医生编号")
    private String doctorNo;  //医生编号

    @ApiModelProperty(value = "排号日期", example = "2020-11-04")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date numDate;  //排号日期

    @ApiModelProperty(hidden = true)
    private Date numDateEnd;  //排号日期
}