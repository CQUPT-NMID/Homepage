package cn.itrover.homepage.bean;

import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  加入我们 填写信息
 * @date 2020/2/20 17:20
 */

@Getter
@Setter
public class JoinUser {

    private Long juid;

    private String name;

    @NotNull
    private String email;

    private String telephone;

    private String qq;

    private String platform;

    private String intro;

    private Date date;

}
