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
* @author wkq
 * @since 2020-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CheckAppReceipt")
public class CheckAppReceipt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ReceiptAppName")
    private String ReceiptAppName;

    @TableField("AppDoctor")
    private String AppDoctor;

    @TableField("XNHCardNo")
    private String XNHCardNo;

    @TableField("OldSource")
    private String OldSource;

    @TableField("Diagnosis")
    private String Diagnosis;

    @TableField("Name")
    private String Name;

    @TableId(value = "ReceiptAppSN", type = IdType.AUTO)
    private String ReceiptAppSN;

    @TableField("CheckPrepare")
    private String CheckPrepare;

    @TableField("OperatorId")
    private String OperatorId;

    @TableField("ReceiptMainIdentity")
    private String ReceiptMainIdentity;

    @TableField("AgeMonth")
    private Integer AgeMonth;

    @TableField("ReceiptAppState")
    private String ReceiptAppState;

    @TableField("AppDeptCode")
    private String AppDeptCode;

    @TableField("SampleCategory")
    private String SampleCategory;

    @TableField("OldId")
    private Long OldId;

    @TableField("CheckItems")
    private String CheckItems;

    @TableField("AppHospId")
    private String AppHospId;

    @TableField("AppTime")
    private LocalDateTime AppTime;

    @TableField("Sex")
    private String Sex;

    @TableField("MedicalHistory")
    private String MedicalHistory;

    @TableField("OldTime")
    private LocalDateTime OldTime;

    @TableField("SendToHospId")
    private String SendToHospId;

    @TableField("TotalMoney")
    private Double TotalMoney;

    @TableField("OperateTime")
    private LocalDateTime OperateTime;

    @TableField("HealthCardNo")
    private String HealthCardNo;

    @TableField("HospZone")
    private String HospZone;

    @TableField("ReceiptAppSource")
    private String ReceiptAppSource;

    @TableField("YBCardNo")
    private String YBCardNo;

    @TableField("BedNo")
    private String BedNo;

    @TableField("ReceiptMainCategory")
    private String ReceiptMainCategory;

    @TableField("PayMode")
    private String PayMode;

    @TableField("OperateOrganization")
    private String OperateOrganization;

    @TableField("Age")
    private Integer Age;

    @TableField("SendToHospName")
    private String SendToHospName;

    @TableField("ReceiptAppCode")
    private String ReceiptAppCode;

    @TableField("AppDept")
    private String AppDept;

    @TableField("IdCardNo")
    private String IdCardNo;


}
