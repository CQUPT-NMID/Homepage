package cn.itrover.homepage.bean.dto;

import cn.itrover.homepage.bean.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/22 21:45
 */

@Getter
@Setter
public class TokenUser {

    private String unam;

    private String realname;

    public TokenUser(User user){
        this.unam = user.getUnam();
        this.realname = user.getName();
    }

}
