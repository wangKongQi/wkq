package com.medcine.base.entity.depart;

import com.medcine.utils.form.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wkq
 * @date 2020/11/2 17:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "科室信息")
public class DepartQO extends PageForm<DepartQO> {

    @ApiModelProperty(value = "科室编码")
    private String departNo;//科室编码

    @ApiModelProperty(value = "科室名称")
    private String departName;  //科室名称

    @ApiModelProperty(value = "科室类别")
    private Long categoryCode;  //科室类别

    @ApiModelProperty(value = "科室编码")
    private String classifyCode;  //科室编码

    @ApiModelProperty(value = "机构编码", required = true)
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "机构名称", required = true)
    private String orgName;  //机构名称

    @ApiModelProperty(value = "是否启用")
    private Integer isEnable;
}