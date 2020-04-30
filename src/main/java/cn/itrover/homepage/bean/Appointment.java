package cn.itrover.homepage.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  预约参观信息
 * @date 2020/2/19 20:25
 */

@Getter
@Setter
public class Appointment {

    private Long aid;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "预约者姓名",required = true)
    private String name;

    /**
     * 单位
     */
    @ApiModelProperty(value = "预约单位")
    private String unit;

    /**
     * 人数
     */
    @ApiModelProperty(value = "预约人数")
    private Integer num;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String telephone;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String note;

    /**
     * 时间
     */
    @ApiModelProperty(value = "预约时间")
    private Date date;

    @ApiModelProperty(value = "填写时间",required = false)
    private Date publishTime;
}
