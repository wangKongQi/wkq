package com.medcine.base.entity.receipt;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wkq
 * @since 2020-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CheckReceiptDetials")
public class CheckReceiptDetials implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CheckReceiptDetialsNo", type = IdType.AUTO)
    private String CheckReceiptDetialsNo;

    @TableField("ItemValueKind")
    private String ItemValueKind;

    @TableField("Instrument")
    private String Instrument;

    @TableField("ItemCode")
    private String ItemCode;

    @TableField("OldId")
    private Long OldId;

    @TableField("ItemValue")
    private String ItemValue;

    @TableField("ItemSN")
    private String ItemSN;

    @TableField("ItemUnit")
    private String ItemUnit;

    @TableField("ResultTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime ResultTime;

    @TableField("ItemNameAs")
    private String ItemNameAs;

    @TableField("ItemValue1")
    private String ItemValue1;

    @TableField("OrderBy")
    private Long OrderBy;

    @TableField("CheckMethod")
    private String CheckMethod;

    @TableField("CheckMan")
    private String CheckMan;

    @TableField("ItemValueDesc")
    private String ItemValueDesc;

    @TableField("OldSource")
    private String OldSource;

    @TableField("ItemValueFlag")
    private String ItemValueFlag;

    @TableField("ItemName")
    private String ItemName;

    @TableField("OldTime")
    private LocalDateTime OldTime;

    @TableField("ItemValue2")
    private String ItemValue2;

    @TableField("ReceiptMainSN")
    private String ReceiptMainSN;

    @TableField("ItemRanges")
    private String ItemRanges;

    @TableField("TestMan")
    private String TestMan;


}
