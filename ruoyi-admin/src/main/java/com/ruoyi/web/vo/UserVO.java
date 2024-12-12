package com.ruoyi.web.vo;

import com.ruoyi.common.core.domain.entity.SysUser;
import lombok.Data;

@Data
public class UserVO {

    private Long userId;
    private String nickName;

    public static UserVO fromUser(SysUser u){
        if(u == null){
            return null;
        }
        UserVO v = new UserVO();
        v.setUserId(u.getUserId());
        v.setNickName(u.getNickName());
        return v;
    }
}
