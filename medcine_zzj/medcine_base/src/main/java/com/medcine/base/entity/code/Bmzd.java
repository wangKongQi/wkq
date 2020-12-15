package com.medcine.base.entity.code;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wkq
 * @date 2020/11/2 17:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Bmzd implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;  //字典编码

    private String name;  //字典名称

    private Integer level;  //等级

    private String parentCode; //上级编码

    private String remark;  //备注

    private Integer isDelete; //是否启用

    private Integer sort;  //排序

}