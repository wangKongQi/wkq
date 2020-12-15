package com.medcine.base.entity.person;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "修改密码")
public class UpdatePassWordDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @NotNull(message = "人员id不能为空")
    private Long id;  //人员工号

    @ApiModelProperty(value = "密码")
    @NotNull(message = "密码不能为空")
    private String password;
}