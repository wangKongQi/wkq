package com.medcine.base.entity.org;

import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel("机构分页信息")
public class OrgPageBO implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty("机构id")
    private Long id;

    @ApiModelProperty(value = "机构编码", required = true)
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "机构名称", required = true)
    private String orgName;  //机构名称

    @ApiModelProperty(value = "机构图片id", required = true)
    private String imgArray;  //机构图片

    @ApiModelProperty(value = "机构图片路径", required = true)
    private List<String> imgPaths;  //机构图片

    @ApiModelProperty(value = "机构地址", required = true)
    private String orgAddress;  //机构地址

    @ApiModelProperty(value = "机构负责人")
    private String orgHeadName;   //机构负责人

    @ApiModelProperty(value = "机构联系方式", required = true)
    private String tel;  //机构联系方式

    @ApiModelProperty(value = "是否启用" , example = "1")
    private Integer isDelete;  //是否启用

    @ApiModelProperty(value = "机构简介", required = true)
    private String orgDesc;  //机构简介
}