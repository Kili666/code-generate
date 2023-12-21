package com.lqjai.common.exception.enums;


import com.lqjai.common.exception.ErrorCode;

/**
 * * 全局错误码枚举
 * * 0-999 系统异常编码保留
 */
public interface GlobalErrorCodeConstants {

    ErrorCode SUCCESS = new ErrorCode(0, "成功");

    // ========== 客户端错误段 ==========

    ErrorCode BAD_REQUEST = new ErrorCode(400, "请求参数不正确");
    ErrorCode UNAUTHORIZED = new ErrorCode(401, "账号未登录");
//    ErrorCode TOKEN_INVALID = new ErrorCode(401, "访问token无效");
    ErrorCode FORBIDDEN = new ErrorCode(403, "没有该操作权限");
    ErrorCode NOT_FOUND = new ErrorCode(404, "请求未找到");
    ErrorCode METHOD_NOT_ALLOWED = new ErrorCode(405, "请求方法不正确");

    // ========== 服务端错误段 ==========

    ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(500, "哎呀！服务器打了个盹");

    ErrorCode PARAMETER_ERROR = new ErrorCode(601, "参数不正确");
    ErrorCode UNKNOWN = new ErrorCode(999, "未知错误");


    static boolean isMatch(Integer code) {
        return code != null
                && code >= SUCCESS.getCode() && code <= UNKNOWN.getCode();
    }

}
