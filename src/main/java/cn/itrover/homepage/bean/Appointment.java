package cn.itrover.homepage.bean;

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
    private String name;

    /**
     * 单位
     */
    private String unit;

    /**
     * 人数
     */
    private Integer num;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 备注
     */
    private String note;

    /**
     * 时间
     */
    private Date date;

}
