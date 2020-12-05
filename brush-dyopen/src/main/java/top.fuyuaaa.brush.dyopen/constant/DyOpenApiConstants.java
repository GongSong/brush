package top.fuyuaaa.brush.dyopen.constant;

/**
 * 
 * @author : fuyuaaa
 * @date : 2020-12-03 15:30
 */
public interface DyOpenApiConstants {

    String DOU_YIN = "https://open.douyin.com";

    String ACCESS_TOKEN = DOU_YIN + "/oauth/access_token?client_key=%s&client_secret=%s&code=%s&grant_type=authorization_code";

    String USER_INFO = DOU_YIN + "/oauth/userinfo?open_id=%s&access_token=%s";

    String FANS_LIST = DOU_YIN + "/fans/list?open_id=%s&access_token=%s&cursor=%s&count=%s";

    /**
     * 意向用户相关
     */
    String LEADS_USER_LIST = DOU_YIN + "/enterprise/leads/user/list?open_id=%s&access_token=%s&cursor=%s&count=%s&start_time=%s&end_time=%s&leads_level=%s&action_type=%s";
    String LEADS_USER_INFO = DOU_YIN + "/enterprise/leads/user/detail?open_id=%s&access_token=%s&user_id=%s";
    String LEADS_USER_ACTION_LIST = DOU_YIN + "/enterprise/leads/user/action/list?open_id=%s&access_token=%s&cursor=%s&count=%s&user_id=%s&action_type=%s";

    String IM_MESSAGE_SEND = DOU_YIN+"/enterprise/im/message/send?open_id=%s&access_token=%s";

}
