package cn.itrover.homepage.bean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
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

    @ApiModelProperty(value = "项目的名字",required = true)
    private String pname;

    @ApiModelProperty(value = "项目负责人:姓名",required = true)
    private String pRealname;

    @ApiModelProperty(value = "项目开始时间",required = true)
    private Date beginTime;

    @ApiModelProperty(value = "结项时间",required = false)
    private Date closeTime;

    @ApiModelProperty(value = "项目介绍")
    private String introduction;

    @ApiModelProperty(value = "项目展示图片")
    private String image;

    @ApiModelProperty(value = "项目成员")
    private List<String> members;

    @ApiModelProperty(value = "项目进度")
    private Integer progress;

    }
