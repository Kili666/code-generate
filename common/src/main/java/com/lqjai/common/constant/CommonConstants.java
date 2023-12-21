

package com.lqjai.common.constant;

/**
 * @author lqj
 * @date 2021/2/1
 */
public interface CommonConstants {

    /**
     * 删除
     */
    String STATUS_DEL = "1";

    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    String STATUS_LOCK = "9";

    /**
     * 菜单树根节点
     */
    Integer MENU_TREE_ROOT_ID = -1;

    /**
     * 菜单
     */
    String MENU = "0";

    /**
     * 编码
     */
    String UTF8 = "UTF-8";

    /**
     * JSON 资源
     */
    String CONTENT_TYPE = "application/json; charset=utf-8";

    /**
     * 前端工程名
     */
    String FRONT_END_PROJECT = "mall-ui";

    /**
     * 后端工程名
     */
    String BACK_END_PROJECT = "mall";

    /**
     * 成功标记
     */
    Integer SUCCESS = 0;

    /**
     * 失败标记
     */
    Integer FAIL = 1;

    /**
     * 验证码前缀
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";

    /**
     * 当前页
     */
    String CURRENT = "current";

    /**
     * size
     */
    String SIZE = "size";

    /**
     * header 中租户ID
     */
    String TENANT_ID = "TENANT-ID";
    /**
     * 租户ID
     */
    Integer TENANT_ID_1 = 1;

    /**
     * header 中店铺ID
     */
    String SHOP_ID = "SHOP-ID";
    /**
     * 店铺ID
     */
    Integer SHOP_ID_1 = 1;

    String DEFAULT_LANGUAGE = "zh_CN";
    /**
     * 默认店铺语言
     */
    String DEFAULT_STORE_LANGUAGE = "en_US";

    /**
     * 日志链路追踪id信息头
     */
    String TRACE_ID_HEADER = "x-traceId-header";

    /**
     * 当前店铺语言
     */
    String STORE_LOCALE = "store-locale";
    /**
     * 日志链路追踪id日志标志
     */
    String LOG_TRACE_ID = "traceId";

    String LOCK_KEY_PREFIX = "LOCK_KEY:";
    /**
     * 客户端IP地址头
     */
    String CLIENT_IP_ADDRESS = "x-client-ip-header";

    /**
     * 国家代码
     */
    String CLIENT_COUNTRY_CODE = "x-client-country-code-header";
    /**
     * 城市代码
     */
    String CLIENT_CITY_CODE = "x-client-city-code-header";

}
