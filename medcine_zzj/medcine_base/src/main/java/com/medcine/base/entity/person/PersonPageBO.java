package com.medcine.base.entity.person;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "人员分页信息")
public class PersonPageBO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "人员id")
    @TableId
    private Long id;

    @ApiModelProperty(value = "人员工号" ,required = true)
    private String personNo;

    @ApiModelProperty(value = "姓名" ,required = true)
    private String name;  //姓名

    @ApiModelProperty(value = "性别" ,required = true)
    private Long sex;  //性别

    @ApiModelProperty(value = "出生年月" ,required = true, example = "1994-06-01")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date birthday;  //出生年月

    @ApiModelProperty(value = "身份证号" ,required = true)
    private String idCardNo;  //身份证号

    @ApiModelProperty(value = "密码" ,required = true)
    private String password;  //密码

    @ApiModelProperty(value = "介绍" ,required = true)
    private String introduce;  //介绍

    @ApiModelProperty(value = "机构编码", required = true)
    private String orgNo;  //机构编码

    @ApiModelProperty(value = "机构名称", required = true)
    private String orgName;  //机构名称

    @ApiModelProperty(value = "科室编码" ,required = true)
    private String departNo;  //科室编码
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "科室名称" ,required = true)
    private String departName;  //科室名称

    @ApiModelProperty(value = "行政级别" ,required = true, example = "1001201")
    private Long xzLevel;  //行政级别

    @ApiModelProperty(value = "技术级别" ,required = true, example = "1001211")
    private Long jxLevel;  //技术级别

    @ApiModelProperty(value = "联系方式" ,required = true)
    private String tel;  //联系方式

    @ApiModelProperty(value = "在岗状态" ,required = true, example = "1")
    private Integer zgState;  //在岗状态

    @ApiModelProperty(value = "是否参与排号" ,required = true, example = "1")
    private Integer isNum;  //是否参与排号

    @ApiModelProperty(value = "人员图片", required = true)
    private String imgArray;  //人员图片

    @ApiModelProperty(value = "人员图片路径", required = true)
    private List<String> imgPaths;  //人员图片

    @ApiModelProperty(value = "人员等级", required = true)
    private Integer permissions;
}