package com.lqjai.common.exception;


/**
 * 错误码对象
 * <p>
 * 全局错误码，占用 [0, 999]，
 * 业务异常错误码，占用 [1 000 000 000, +∞)，
 */
public class ErrorCode {

    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String message;

    /**
     * 系统类型(1:买家，2：卖家，3：平台）
     */
    private final Integer systemType;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.systemType = 1;
    }

    public ErrorCode(Integer code, String message, Integer systemType) {
        this.code = code;
        this.message = message;
        this.systemType = systemType;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getSystemType() {
        return systemType;
    }
}
