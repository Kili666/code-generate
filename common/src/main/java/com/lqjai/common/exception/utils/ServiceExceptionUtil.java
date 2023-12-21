package com.lqjai.common.exception.utils;

import com.lqjai.common.exception.ErrorCode;
import com.lqjai.common.exception.ServiceException;
import com.lqjai.common.utils.UserContext;
import com.lqjai.common.constant.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * {@link ServiceException} 工具类
 * <p>
 * 1. 异常提示信息，写在枚举类中
 * 2. 异常提示信息，写在 .properties 等等配置文件
 * 3. 异常提示信息，写在配置中心中，从而实现可动态刷新
 * 4. 异常提示信息，存储在 db 等等数据库中，从而实现可动态刷新
 */
public class ServiceExceptionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceExceptionUtil.class);

    /**
     * 错误码提示模板
     */
    private static ConcurrentMap<Integer, Map<String, String>> messages = new ConcurrentHashMap<>();


    public static ConcurrentMap<Integer, Map<String, String>> getAll(){
        return ServiceExceptionUtil.messages;
    }

    public static void putAll(Map<Integer, Map<String, String>> all) {
        ServiceExceptionUtil.messages.putAll(all);
    }

    public static void put(Integer code, Map<String, String> message) {
        ServiceExceptionUtil.messages.put(code, message);
    }

    public static void delete(Integer code, String message) {
        ServiceExceptionUtil.messages.remove(code, message);
    }

    // ========== 和 ServiceException 的集成 ==========

    public static ServiceException exception(ErrorCode errorCode) {
        String userId = UserContext.getUser().toString();
        LOGGER.info("userId:" + userId);
        if (!StringUtils.isEmpty(userId))
            return exception(userId, errorCode);
        else {
            String language = CommonConstants.DEFAULT_LANGUAGE;
            Map<String, String> map = messages.get(errorCode.getCode());
            if (map != null) {
                String messagePattern = map.getOrDefault(language, errorCode.getMessage());
                return exception0(errorCode.getCode(), messagePattern);
            } else
                return exception0(errorCode.getCode(), errorCode.getMessage());
        }
    }

    /**
     * 格式化错误代码
     *
     * @param errorCode
     * @param params
     * @return
     */
    public static ServiceException exception(ErrorCode errorCode, Object... params) {
        String userId = UserContext.getUser().toString();
        if (!StringUtils.isEmpty(userId))
            return exception(userId, errorCode, params);
        else {
            String language = CommonConstants.DEFAULT_LANGUAGE;
            Map<String, String> map = messages.get(errorCode.getCode());
            if (map != null) {
                String messagePattern = map.getOrDefault(language, errorCode.getMessage());
                return exception0(errorCode.getCode(), messagePattern, params);
            } else
                return exception0(errorCode.getCode(), errorCode.getMessage(), params);
        }
    }

    public static ServiceException exception(String language, ErrorCode errorCode) {
        if (StringUtils.isEmpty(language))
            language = CommonConstants.DEFAULT_LANGUAGE;
        Map<String, String> map = messages.get(errorCode.getCode());
        if (map != null) {
            String messagePattern = map.getOrDefault(language, errorCode.getMessage());
            // String messagePattern = messages.getOrDefault(errorCode.getCode(),errorCode.getMessage());
            return exception0(errorCode.getCode(), messagePattern);
        } else
            return exception0(errorCode.getCode(), errorCode.getMessage());
    }

    public static ServiceException exception(String language, ErrorCode errorCode, Object... params) {
        if (StringUtils.isEmpty(language))
            language = CommonConstants.DEFAULT_LANGUAGE;
        Map<String, String> map = messages.get(errorCode.getCode());
        if (map != null) {
            String messagePattern = map.getOrDefault(language, errorCode.getMessage());
            //String messagePattern = messages.getOrDefault(errorCode.getCode(), errorCode.getMessage());
            return exception0(errorCode.getCode(), messagePattern, params);
        } else
            return exception0(errorCode.getCode(), errorCode.getMessage(), params);
    }

    /**
     * 创建指定编号的 ServiceException 的异常
     *
     * @param code 编号
     * @return 异常
     */
    public static ServiceException exception(String language, Integer code) {
        if (StringUtils.isEmpty(language))
            language = CommonConstants.DEFAULT_LANGUAGE;
        Map<String, String> map = messages.get(code);
        if (map != null) {
            String messagePattern = map.get(language);
            return exception0(code, messagePattern);
        } else
            return exception0(code, code.toString());
    }

    /**
     * 创建指定编号的 ServiceException 的异常
     *
     * @param code   编号
     * @param params 消息提示的占位符对应的参数
     * @return 异常
     */
    public static ServiceException exception(String language, Integer code, Object... params) {
        if (StringUtils.isEmpty(language))
            language = CommonConstants.DEFAULT_LANGUAGE;
        Map<String, String> map = messages.get(code);
        if (map != null) {
            String messagePattern = map.get(language);
            return exception0(code, messagePattern, params);
        } else {
            return exception0(code, code.toString(), params);
        }
    }

    public static ServiceException exception0(Integer code, String messagePattern, Object... params) {
        String message = doFormat(code, messagePattern, params);
        return new ServiceException(code, message);
    }

    // ========== 格式化方法 ==========

    /**
     * 将错误编号对应的消息使用 params 进行格式化。
     *
     * @param code           错误编号
     * @param messagePattern 消息模版
     * @param params         参数
     * @return 格式化后的提示
     */
    private static String doFormat(int code, String messagePattern, Object... params) {
        StringBuilder sbuf = new StringBuilder(messagePattern.length() + 50);
        int i = 0;
        int j;
        int l;
        for (l = 0; l < params.length; l++) {
            j = messagePattern.indexOf("{}", i);
            if (j == -1) {
                LOGGER.error("[doFormat][参数过多：错误码({})|错误内容({})|参数({})", code, messagePattern, params);
                if (i == 0) {
                    return messagePattern;
                } else {
                    sbuf.append(messagePattern.substring(i, messagePattern.length()));
                    return sbuf.toString();
                }
            } else {
                sbuf.append(messagePattern.substring(i, j));
                sbuf.append(params[l]);
                i = j + 2;
            }
        }
        if (messagePattern.indexOf("{}", i) != -1) {
            LOGGER.error("[doFormat][参数过少：错误码({})|错误内容({})|参数({})", code, messagePattern, params);
        }
        sbuf.append(messagePattern.substring(i, messagePattern.length()));
        return sbuf.toString();
    }

//    public static void main(String[] args) {
//        ErrorCode errorCode = new ErrorCode(1001001000, "购物车数量为{}个,一个有{}个人!");
//        ServiceException exception = ServiceExceptionUtil.exception(errorCode, 3,6,7);
//        System.out.println(exception.getMessage());
//    }

}
