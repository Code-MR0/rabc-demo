package com.mhw.rabc.enums;

/**
 * Description: 公共通用枚举返回
 * Create Date: 2020/6/19
 *
 * @author mhw
 * @version 1.0
 */
public enum CommonReturnEnum {

    // 操作成功
    SUCCESS(200, "success"),
    // 操作失败
    FAILED(500, "fail");

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private final int code;

    private final String name;

    CommonReturnEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * @description : 根据code获取name
     *
     * @param code
     * @return java.lang.String
     */
    public static String getNameByCode(String code) {
        for (CommonReturnEnum platformFree : CommonReturnEnum.values()) {
            if (code.equals(platformFree.getCode())) {
                return platformFree.getName();
            }
        }
        return null;
    }

}
