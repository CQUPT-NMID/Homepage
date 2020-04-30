package cn.itrover.homepage.bean.vo;

import io.swagger.annotations.ApiModelProperty;
import javafx.scene.chart.ValueAxis;
import lombok.Data;

import java.util.Date;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  用于分页时返回预约基本信心
 * @date 2020/2/20 0:21
 */

@Data
public class AppointmentVo {

    private Long aid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 人数
     */
    private Integer num;


    private String telephone;

    private String unit;

    @ApiModelProperty(value = "填写时间")
    private Date publishTime;

    /**
     * 时间
     */
    @ApiModelProperty(value = "参观时间")
    private Date date;


    @ApiModelProperty(value = "是否接待")
    private boolean status;
}
