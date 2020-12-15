package com.medcine.utils.enums;

/**
 * 通用枚举
 *
 * @author wkq
 * @date 2020/11/9 13:25
 * @return
 */
public enum CommonStringEnums {
    //性别
    MAN("100101", "男"),
    WOMAN("100102", "女"),
    NO_WRITE("100103", "未填写"),

    //技术级别
    RESIDENT_DOCTOR("100301","住院医师"),
    ATTENDING_DOCTOR("100302","主治医师"),
    DEPUTY_DIRECTOR_DOCTOR("100303","副主任医师"),
    DIRECTOR_DOCTOR("100304","主任医师"),

    ;
    private String code;

    private String name;

    private CommonStringEnums(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    //根据code查询Name
    public static String getNameByCode(String code) {
        for (CommonStringEnums c : CommonStringEnums.values()) {
            if (c.getCode().equals(code)) {
                return c.name;
            }
        }
        return null;
    }
}
