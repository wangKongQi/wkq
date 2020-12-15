package com.medcine.base.entity.org;

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
@ApiModel(value = "机构信息请求参数")
public class OrgQO extends PageForm<OrgQO> {

    @ApiModelProperty(value = "机构编码")
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "机构名称")
    private String orgName;  //机构名称

    @ApiModelProperty(value = "机构联系方式")
    private String tel;  //机构联系方式
}