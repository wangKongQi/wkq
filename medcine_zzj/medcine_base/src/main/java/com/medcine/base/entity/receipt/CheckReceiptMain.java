package com.medcine.base.entity.receipt;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author wkq
 * @since 2020-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CheckReceiptMain")
public class CheckReceiptMain implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("SampleCode")
    private String SampleCode;

    @TableField("AppDoctor")
    private String AppDoctor;

    @TableField("YBCardNo")
    private String YBCardNo;

    @TableField("Diagnosis")
    private String Diagnosis;

    @TableField("OldTime")
    private LocalDateTime OldTime;

    @TableField("ExeDept")
    private String ExeDept;

    @TableField("ReceiptAppSN")
    private String ReceiptAppSN;

    @TableField("Sex")
    private String Sex;

    @TableField("Age")
    private Integer Age;

    @TableField("AppDeptCode")
    private String AppDeptCode;

    @TableField("OldSource")
    private String OldSource;

    @TableField("IdCardNo")
    private String IdCardNo;

    @TableField("OperateOrganization")
    private Double OperateOrganization;

    @TableField("ReceiptMainName")
    private String ReceiptMainName;

    @TableField("SampleCategory")
    private String SampleCategory;

    @TableField("PayMode")
    private String PayMode;

    @TableField("ReceiptMainIdentity")
    private String ReceiptMainIdentity;

    @TableField("OldId")
    private Long OldId;

    @TableField("ExeDoctor")
    private String ExeDoctor;

    @TableField("Name")
    private String Name;

    @TableField("PersonNum")
    private String PersonNum;

    @TableField("AgeMonth")
    private Integer AgeMonth;

    @TableField("AppTime")
    private LocalDateTime AppTime;

    @TableField("XNHCardNo")
    private String XNHCardNo;

    @TableField("OperatorId")
    private String OperatorId;

    @TableField("ReceiptMainSource")
    private String ReceiptMainSource;

    @TableField("CheckItems")
    private String CheckItems;

    @TableField("ExeDeptCode")
    private String ExeDeptCode;

    @TableField("ReceiptMainCategory")
    private String ReceiptMainCategory;

    @TableId(value = "ReceiptMainSN", type = IdType.AUTO)
    private String ReceiptMainSN;

    @TableField("ReportMan")
    private String ReportMan;

    @TableField("AppDept")
    private String AppDept;

    @TableField("ExeTime2")
    private LocalDateTime ExeTime2;

    @TableField("OperateTime")
    private LocalDateTime OperateTime;

    @TableField("ReceiptMainCode")
    private String ReceiptMainCode;


}
