

package com.lqjai.common.constant;

/**
 * @author lqj
 * @date 2020年01月01日
 * <p>
 * 缓存的key 常量
 */
public interface CacheConstants {

    /**
     * 令牌自定义标识
     */
    String HEADER = "Authorization";

    /**
     * 令牌前缀
     */
    String TOKEN_PREFIX = "Bearer ";

    /**
     * 权限缓存前缀
     */
    String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 客户的随机ID
     */
    String NONCESTR_CID = "NONCESTR:CID";
    /**
     * 商户店铺列表
     */
    String MERCHANT_SHOPLIST = "MERCHANT:SHOPLIST";
    /**
     * 店铺语言对应关系
     */
    String STORE_LANGUAGE_CONFIG = "STORE:LANGUAGE:";
    /**
     * 顾客访问token
     */
    String ACCESS_TOKEN_MEMBER = "ACCESS_TOKEN:MEMBER:";
    /**
     * 商户访问token
     */
    String ACCESS_TOKEN_MERCHANT = "ACCESS_TOKEN:MERCHANT:";
    /**
     * 开放api访问token
     */
    String ACCESS_TOKEN_OPENAPI = "ACCESS_TOKEN:OPENAPI:";
    /**
     * 管理员访问token
     */
    String ACCESS_TOKEN_ADMIN = "ACCESS_TOKEN:ADMIN:";
    /**
     * 分销员访问token
     */
    String ACCESS_TOKEN_DISTRIBUTOR = "ACCESS_TOKEN:DISTRIBUTOR:";
    /**
     * 顾客菜单缓存
     */
    String MENU_DETAILS_MEMBER = "MENU_DETAILS:MEMBER:";
    /**
     * 商户菜单缓存
     */
    String MENU_DETAILS_MERCHANT = "MENU_DETAILS:MERCHANT:";
    /**
     * 管理员菜单缓存
     */
    String MENU_DETAILS_ADMIN = "MENU_DETAILS:ADMIN:";

    /**
     * oauth 缓存前缀
     */
    String PROJECT_OAUTH_ACCESS = "mall_oauth:access:";

    /**
     * 验证码前缀
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY:";

    /**
     * 菜单信息缓存(系统）
     */
    String MENU_DETAILS = "menu_details";
//    /**
//     * 菜单信息缓存（租户）
//     */
//    String MENU_DETAILS_MERCHANT = "menu_details_org";

//    /**
//     * 菜单信息缓存（顾客）
//     */
//    String MENU_DETAILS_MEMBER = "menu_details_mbr";
    /**
     * 用户信息缓存
     */
    String USER_DETAILS = "user_details";
    /**
     * 商户信息缓存
     */
    String MERCHANT_DETAILS = "merchant_details";

    /**
     * 顾客信息缓存
     */
    String MEMBER_DETAILS = "member_details";

    /**
     * 字典信息缓存
     */
    String DICT_DETAILS = "dict_details";

    /**
     * oauth 客户端信息
     */
    String CLIENT_DETAILS_KEY = "mall_oauth:client:details";

    /**
     * 参数缓存
     */
    String PARAMS_DETAILS = "params_details";


    /**
     * 租户缓存
     */
    String TENANT_DETAILS = "tenant_details";
    /**
     * 消息发送频率限制前缀
     */
    String SEND_MOBILE_FREQUENCY_PREFIX = "SEND:MOBILE:FREQUENCY";
    /**
     * 消息日发送限制前缀（
     */
    String SEND_MOBILE_LIMIT_PREFIX = "SEND:MOBILE:LIMIT";
    /**
     * 消息发送频率限制前缀
     */
    String SEND_EMAIL_FREQUENCY_PREFIX = "SEND:EMAIL:FREQUENCY";
    /**
     * 消息发送频率限制前缀
     */
    String MEMSEND_EMAIL_FREQUENCY_PREFIX = "MEMSEND:EMAIL:FREQUENCY";

    /**
     * 消息日发送限制前缀
     */
    String SEND_EMAIL_LIMIT_PREFIX = "SEND:EMAIL:LIMIT";
    /**
     * 消息日发送限制前缀
     */
    String MEMSEND_EMAIL_LIMIT_PREFIX = "MEMSEND:EMAIL:LIMIT";

}
