package cn.itrover.homepage.bean.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/20 22:41
 */

@Setter
@Getter
@ToString
public class JoinUserVo {
    private Long juid;

    private String platform;

    private String name;

    private Date date;
}
