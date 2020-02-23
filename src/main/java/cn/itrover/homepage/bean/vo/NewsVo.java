package cn.itrover.homepage.bean.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/21 11:34
 */

@Data
public class NewsVo {

    private Long id;

    private Date publishTime;

    private String  title;

    private String url;
}
