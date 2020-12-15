package com.medcine.base.entity.book;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class PregnancyBooks implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "NewlyDiagnosedCode", type = IdType.AUTO)
    private String NewlyDiagnosedCode;

    /**
     * 人员编码
     */
    @TableField("PersonNum")
    private String PersonNum;

    /**
     * 建册日期
     */
    @TableField("VisitsDate")
    private LocalDateTime VisitsDate;

    /**
     * 孕册本号
     */
    @TableField("PregnancyBooksNum")
    private String PregnancyBooksNum;

    /**
     * 姓名
     */
    @TableField("Name")
    private String Name;

    /**
     * 年龄
     */
    @TableField("Age")
    private String Age;

    /**
     * 身份证号
     */
    @TableField("IdCardNo")
    private String IdCardNo;

    /**
     * 是否结案
     */
    @TableField("Closed")
    private String Closed;

    /**
     * 结案时间
     */
    @TableField("ClosedDate")
    private LocalDateTime ClosedDate;

    /**
     * 高危标志
     */
    @TableField("HighRiskSigns")
    private String HighRiskSigns;

    /**
     * 操作员单位
     */
    @TableField("OperateOrganization")
    private Double OperateOrganization;

    /**
     * 医生
     */
    @TableField("Doctor")
    private String Doctor;

    /**
     * 操作人
     */
    @TableField("OperatorId")
    private String OperatorId;

    /**
     * 操作时间
     */
    @TableField("OperateTime")
    private LocalDateTime OperateTime;

    @TableField("FatherIdCardNo")
    private String FatherIdCardNo;

    @TableField("ResidenceAddress")
    private String ResidenceAddress;

    @TableField("WomenPhoneticCode")
    private String WomenPhoneticCode;

    @TableField("WomanEducation")
    private String WomanEducation;

    @TableField("ManOccupation")
    private String ManOccupation;

    @TableField("Telephone")
    private String Telephone;

    @TableField("gKey")
    private String gKey;

    @TableField("HealthCardNo")
    private String HealthCardNo;

    @TableField("VoucherType")
    private String VoucherType;

    @TableField("IsPoor")
    private String IsPoor;

    @TableField("FatherBirth")
    private LocalDateTime FatherBirth;

    @TableField("FamilyPlanningProp")
    private String FamilyPlanningProp;

    @TableField("ClosedTime")
    private LocalDateTime ClosedTime;

    @TableField("National")
    private String National;

    @TableField("Remarks")
    private String Remarks;

    @TableField("OldHNSource")
    private String OldHNSource;

    @TableField("FatherNational")
    private String FatherNational;

    @TableField("MaternityCode")
    private Long MaternityCode;

    @TableField("ClosedType")
    private String ClosedType;

    @TableField("LivingType")
    private String LivingType;

    @TableField("DeliveryHospName")
    private String DeliveryHospName;

    @TableField("FatherVoucherType")
    private String FatherVoucherType;

    @TableField("OldId")
    private Long OldId;

    @TableField("PregnancyDays")
    private Integer PregnancyDays;

    @TableField("MiddleAddress")
    private String MiddleAddress;

    @TableField("MobilePhone")
    private String MobilePhone;

    @TableField("PostPartumHospName")
    private String PostPartumHospName;

    @TableField("FatherAge")
    private String FatherAge;

    @TableField("FatherName")
    private String FatherName;

    @TableField("LivingRegion")
    private String LivingRegion;

    @TableField("LastMenstrual")
    private LocalDateTime LastMenstrual;

    @TableField("ClosedContent")
    private String ClosedContent;

    @TableField("Nationality")
    private String Nationality;

    @TableField("PostPartumHospID")
    private Double PostPartumHospID;

    @TableField("WBPrimaryKey")
    private String WBPrimaryKey;

    @TableField("FatherNationality")
    private String FatherNationality;

    @TableField("ManPhoneticCode")
    private String ManPhoneticCode;

    @TableField("OldSource")
    private String OldSource;

    @TableField("WomanOccupation")
    private String WomanOccupation;

    @TableField("RegionCode")
    private String RegionCode;

    @TableField("DeliveryHospCode")
    private Double DeliveryHospCode;

    @TableField("BarCode")
    private String BarCode;

    @TableField("Vouchers")
    private String Vouchers;

    @TableField("OldTime")
    private LocalDateTime OldTime;

    @TableField("TemPhone")
    private String TemPhone;

    @TableField("FileNum")
    private Double FileNum;

    @TableField("IsVouchers")
    private Boolean IsVouchers;

    @TableField("AccountType")
    private String AccountType;

    @TableField("OldCardNo")
    private String OldCardNo;

    @TableField("ManEducation")
    private String ManEducation;

    @TableField("WomanWorkUnit")
    private String WomanWorkUnit;

    @TableField("Birth")
    private LocalDateTime Birth;

    @TableField("PostPartumRegion")
    private String PostPartumRegion;

    @TableField("Address")
    private String Address;

    @TableField("ResidenceRegionCode")
    private String ResidenceRegionCode;


}
