package cn.itrover.homepage.bean.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/22 23:35
 */

@Getter
@Setter
@ToString
public class ProjectVo {

    private Long id;

    private String name;

    private String image;

    private Date beginTime;

}
