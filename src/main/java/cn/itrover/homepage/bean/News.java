package cn.itrover.homepage.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import springfox.documentation.annotations.ApiIgnore;
import sun.rmi.runtime.Log;

import java.util.Date;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/21 11:15
 */

@Getter
@Setter
@ToString
@ApiModel(value = "新闻")
public class News {

    @ApiModelProperty(value = "新闻id，修改时需要传入")
    private Long id;
    /**
     * 标题
     */
    @ApiModelProperty(value = "新闻标题",required = true)
    private String title;
    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间",required = false,hidden = true)
    private Date publishTime;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容",required = true)
    private String content;


    @ApiModelProperty(value = "首图地址",required = false)
    private String url;
    /**
     * 发布者
     */
    @ApiModelProperty(value = "发布者姓名",required = false)
    private String nRealname;

}
