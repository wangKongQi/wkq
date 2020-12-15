package com.medcine.base.entity.code;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "字典信息")
public class BasyWjtCodeDic implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典id")
    @TableId
    private Long codeId;

    @ApiModelProperty(value = "字典Code")
    private String code;

    @ApiModelProperty(value = "字典名称")
    private String codeName;

    @ApiModelProperty(value = "拼音简码")
    private String pyCode;

    @ApiModelProperty(value = "字典类型")
    private String type;

    @ApiModelProperty(value = "父code")
    private String parentCode;
}