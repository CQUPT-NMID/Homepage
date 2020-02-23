package cn.itrover.homepage.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/23 13:14
 */

@Setter
@Getter
public class Project {

    private Long pid;

    private String pname;

    private String pRealname;

    private String beginTime;

    private String closeTime;

    private String introduction;

    private String image;

    private List<String> members;
}
