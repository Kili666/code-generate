package com.lqjai.common.exception.enums;

/**
 * 业务异常的错误码区间，解决：解决各模块错误码定义，避免重复，在此只声明不做实际使用
 * <p>
 * 一共 10 位，分成四段
 * <p>
 * 第一段，1 位，类型
 * 1 - 业务级别异常
 * x - 预留
 * 第二段，3 位，系统类型
 * 001 - 用户系统
 * 002 - 商品系统
 * 003 - 订单系统
 * 004- 店铺系统
 * 005 - 系统设置
 * ... - ...
 * 第三段，3 位，模块
 * 不限制规则。
 * 一般建议，每个系统里面，可能有多个模块
 * 001 - 购物车 模块
 * 002 - 订单 模块
 * 003 - MobileCode 模块
 * 第四段，3 位，错误码
 * 不限制规则。
 * 一般建议，每个模块自增。
 */
public class ServiceErrorCodeRange {

    // user 错误码区间  [1-001-001-000 ~ 1-002-000-000]

    // goods 错误码区间 [1-002-001-000 ~ 1-003-000-000)

    // order 错误码区间 [1-003-001-000 ~ 1-004-000-000)

    // shop  错误码区间 [1-004-001-000 ~ 1-005-000-000)

    // settings 错误码区间 [1-005-001-000 ~ 1-006-000-000)
    //
    //pricing 错误码区间 [1-009-001-000 ~ 1-006-000-000)
    //googleapp 错误码区间 [1-012-001-000 ~ 1-013-000-000)
    //webhook 错误码区间 [1-013-001-000 ~ 1-014-000-000)
    //apps 错误码区间 [1-014-001-000 ~ 1-015-000-000)
}
