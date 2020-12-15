package com.medcine.base.entity.person;

import com.medcine.utils.form.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "人员信息")
public class PersonQO extends PageForm<PersonQO> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "人员工号")
    private String personNo;  //人员工号

    @ApiModelProperty(value = "姓名")
    private String name;  //姓名

    @ApiModelProperty(value = "身份证号")
    private String idCardNo;  //身份证号

    @ApiModelProperty(value = "科室编码")
    private String departNo;  //科室编码

    @ApiModelProperty(value = "机构编码")
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "行政级别", example = "1000212")
    private Long xzLevel;  //行政级别

    @ApiModelProperty(value = "技术级别", example = "1")
    private Long jxLevel;  //技术级别

    @ApiModelProperty(value = "联系方式")
    private String tel;  //联系方式

    @ApiModelProperty(value = "在岗状态", example = "1")
    private Long zgState;  //在岗状态

    @ApiModelProperty(value = "是否参与排号", example = "1")
    private Integer isNum;  //是否参与排号

}