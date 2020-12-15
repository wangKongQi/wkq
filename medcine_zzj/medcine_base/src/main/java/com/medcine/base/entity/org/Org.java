package com.medcine.base.entity.org;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("机构信息")
public class Org implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("机构id")
    private Long id;

    @ApiModelProperty(value = "机构编码", required = true)
    @NotEmpty(message = "机构编码不能为空")
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "机构名称", required = true)
    @NotEmpty(message = "机构名称不能为空")
    private String orgName;  //机构名称

    @ApiModelProperty(value = "机构图片", required = true)
    private String imgArray;  //机构图片

    @ApiModelProperty(value = "机构地址", required = true)
    @NotEmpty(message = "机构地址不能为空")
    private String orgAddress;  //机构地址

    @ApiModelProperty(value = "机构负责人")
    private String orgHeadName;   //机构负责人

    @ApiModelProperty(value = "机构联系方式", required = true)
    @NotEmpty(message = "机构联系方式不能为空")
    private String tel;  //机构联系方式

    @ApiModelProperty(value = "是否删除" , example = "1")
    private Integer isDelete;  //是否删除

    @ApiModelProperty(value = "机构简介", required = true)
    @NotEmpty(message = "机构简介不能为空")
    private String orgDesc;  //机构简介
}