package cn.itrover.homepage.bean;

import lombok.Data;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 用户
 * @date 2020/2/20 0:35
 */

@Data
public class User {
    /**
     * 用户名
     */
    private String unam;

    /**
     * 姓名
     */
    private String name;

    /**
     * 平台
     */
    private String platform;

    private String email;

    private String telephone;

    private String upath;
    /**
     * 职务
     */
    private String duty;

    private String skill;

    private String prjExperience;
}
