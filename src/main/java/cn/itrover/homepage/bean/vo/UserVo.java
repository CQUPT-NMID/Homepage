package cn.itrover.homepage.bean.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/22 21:59
 */

@Getter
@Setter
@ToString
public class UserVo {

    @ApiModelProperty(value = "用户名")
    private String unam;

    private String name;

    private String upath;

}
