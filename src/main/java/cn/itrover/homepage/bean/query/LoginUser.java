package cn.itrover.homepage.bean.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/22 21:41
 */
@Setter
@Getter
public class LoginUser {

    private String unam;

    private String password;
}
