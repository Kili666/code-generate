

package com.lqjai.common.constant;

/**
 * @author lqj
 * @date 2021/2/1
 */
public interface SecurityConstants {

    /**
     * 角色前缀
     */
    String ROLE = "ROLE_";

    /**
     * 前缀
     */
    String PROJECT_PREFIX = "mall_";

    /**
     * 项目的license
     */
    String PROJECT_LICENSE = "made by lqj";

    /**
     * 内部
     */
    String FROM_IN = "Y";

    /**
     * 标志
     */
    String FROM = "from";

    /**
     * 默认登录URL
     */
    String OAUTH_TOKEN_URL = "/oauth/token";

    /**
     * 商户登录URL
     */
    String MERCHANT_TOKEN_URL = "/merchant/token/process";
    /**
     * 顾客登录URL
     */
    String MEMBER_TOKEN_URL = "/member/token/process";

    /**
     * 自定义商户登录URL
     */
    String MERCHANT_OAUTH_TOKEN_URL = "/merchant/token/*";
    /**
     * 自定义顾客登录URL
     */
    String MEMBER_OAUTH_TOKEN_URL = "/member/token/*";

    /**
     * grant_type
     */
    String REFRESH_TOKEN = "refresh_token";

    /**
     * {bcrypt} 加密的特征码
     */
    String BCRYPT = "{bcrypt}";

    /**
     * sys_oauth_client_details 表的字段，不包括client_id、client_secret
     */
    String CLIENT_FIELDS = "client_id, CONCAT('{noop}',client_secret) as client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     * JdbcClientDetailsService 查询语句
     */
    String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS + " from sys_oauth_client_details";

    /**
     * 默认的查询语句
     */
    String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * 按条件client_id 查询
     */
    String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

    /***
     * 资源服务器默认bean名称
     */
    String RESOURCE_SERVER_CONFIGURER = "resourceServerConfigurerAdapter";

    /**
     * 用户ID字段
     */
    String DETAILS_USER_ID = "user_id";

    /**
     * 员工ID
     */
    String STAFF_USER_ID = "staffId";

    /**
     * 用户名字段
     */
    String DETAILS_USERNAME = "username";

    /**
     * 用户部门字段
     */
    String DETAILS_DEPT_ID = "dept_id";

    /**
     * 协议字段
     */
    String DETAILS_LICENSE = "license";

    /**
     * 商户ID
     */
    String SHOP_ID = "shopId";


    //签名秘钥
    String BASE64SECRET = "ZW]4l5JH[m6Lm)LaQEjpb!4E0lRaG(";

    //超时毫秒数（默认30分钟）
    int EXPIRESSECOND = 1800000;

    //用于JWT加密的密匙
    String DATAKEY = "u^3y6SPER41jm*fn";

}
