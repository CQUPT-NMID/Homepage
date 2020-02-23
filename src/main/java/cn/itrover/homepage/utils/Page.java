package cn.itrover.homepage.utils;

import lombok.Data;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 分页相关
 * @date 2020/2/20 0:09
 */

@Data
public class Page {

    /**
     * 当前页
     */
    private Integer pageNum = 0;

    /**
     * 每页大小
     */
    private Integer pageSize = 0;

}
