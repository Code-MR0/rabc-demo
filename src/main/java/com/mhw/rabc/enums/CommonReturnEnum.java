package com.mhw.rabc.enums;

/**
 * @className: CommonReturnEnum
 * @description: 公共枚举返回
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
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
     * @description: 根据code获取name
     */
    @SuppressWarnings("all")
    public static String getNameByCode(String code) {
        for (CommonReturnEnum platformFree : CommonReturnEnum.values()) {
            if (code.equals(platformFree.getCode())) {
                return platformFree.getName();
            }
        }
        return null;
    }

}
