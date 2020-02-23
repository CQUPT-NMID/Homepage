package cn.itrover.homepage.service;

import cn.itrover.homepage.bean.Appointment;
import cn.itrover.homepage.bean.vo.AppointmentVo;
import cn.itrover.homepage.utils.Page;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/19 20:28
 */

public interface IAppointmentService {

    /**
     * 新建 预约参观
     * @param appointment
     * @return
     */
    public Long create(Appointment appointment);

    /**
     * 通过id 查询预约参观详细信息
     * @param id
     * @return
     */
    Appointment getAppointmentById(Long id);

    /**
     * 通过id 删除预约参观
     * @param id
     */
    void delete(Long id);

    /**
     * 分页 查询
     * @param page
     * @return
     */
    List<AppointmentVo> get(Page page);
}
