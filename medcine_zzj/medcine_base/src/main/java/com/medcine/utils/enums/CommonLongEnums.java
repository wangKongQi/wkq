package com.medcine.utils.enums;

/**
 * 通用枚举
 *
 * @author wkq
 * @date 2020/11/9 13:25
 * @return
 */
public enum CommonLongEnums {
    //科室类别
    CATEGORY_100401(100401L,"就诊科室"),
    CATEGORY_100402(100402L,"医技科室"),
    CATEGORY_100403(100403L,"收费科室"),
    CATEGORY_100404(100404L,"其他科室"),

    //在岗状态
    ON_JOB(100201L,"在岗"),
    WAIT_JOB(100202L,"待岗"),
    LEAVE_JOB(100203L,"离岗"),
    LEAVE_OFFICE(100204L,"离职"),
    ;
    private Long code;

    private String name;

    private CommonLongEnums(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    //根据code查询Name
    public static String getNameByCode(String code) {
        for (CommonLongEnums c : CommonLongEnums.values()) {
            if (c.getCode().equals(code)) {
                return c.name;
            }
        }
        return null;
    }
}
