package top.fuyuaaa.brush.dyopen.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.fuyuaaa.brush.common.BaseData;

import java.io.Serializable;
import java.util.List;

/**
 * 用户列表---粉丝列表&关注列表
 *
 *
 * @author : fuyuaaa
 * @date : 2020-12-06 21:03
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserListResult extends BaseData implements Serializable {
    private static final long serialVersionUID = 8496052651214142194L;

    private Integer cursor;
    private Long total;
    @JSONField(name = "has_more")
    private Boolean hasMore;

    private List<UserInfoResult> list;
}
