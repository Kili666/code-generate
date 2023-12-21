package com.lqjai.common.constant.enums;

import java.util.HashMap;
import java.util.Map;

public enum PayStatusEnum {
    WAITING(0, "waiting", "待支付"),
    PAYING(1, "paying", "支付中"),
    PAID(2, "paid", "已支付"),
    CANCELLED(3, "cancelled", "已取消"),
    FAILED(4, "failed", "支付失败"),
    REFUNDING(5, "refunding", "退款中"),
    REFUND_FAILED(6, "refund_failed", "退款失败"),
    REFUNDED(7, "refunded", "已退款");

    private Integer code;
    private String status;
    private String desc;
    private static final Map<String, String> param = new HashMap();

    private PayStatusEnum(Integer code, String status, String desc) {
        this.code = code;
        this.status = status;
        this.desc = desc;
    }

    public static Map<String, String> getParam() {
        return param;
    }

    public String getStatus() {
        return this.status;
    }

    public String getDesc() {
        return this.desc;
    }

    public static boolean isPaySucc(String status) {
        return PAID.getStatus().equals(status);
    }

    public boolean isPaySucc() {
        return PAID == this;
    }

    public boolean isPayFail() {
        return FAILED == this;
    }

    public static PayStatusEnum covertByCode(Integer code) {
        if (code == null) {
            return null;
        } else {
            PayStatusEnum[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                PayStatusEnum e = var1[var3];
                if (e.getCode() == code) {
                    return e;
                }
            }

            return null;
        }
    }

    @Override
    public String toString() {
        return "PayStatusEnum{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Integer getCode() {
        return this.code;
    }

    static {
        PayStatusEnum[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            PayStatusEnum enums = var0[var2];
            param.put(enums.getStatus(), enums.getDesc());
        }

    }
}
