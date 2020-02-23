package cn.itrover.homepage.bean.vo;

import lombok.Data;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/21 11:55
 */

@Data
public class PlatformVo {

    private String id;

    private String name;
    /**
     * 平台logo
     */
    private String logoURL;

    private String intro;

}
