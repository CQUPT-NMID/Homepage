package cn.itrover.homepage.service.impl;

import cn.itrover.homepage.bean.Appointment;
import cn.itrover.homepage.bean.dto.PageDto;
import cn.itrover.homepage.bean.vo.AppointmentVo;
import cn.itrover.homepage.mapper.AppointmentMapper;
import cn.itrover.homepage.service.IAppointmentService;
import cn.itrover.homepage.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/19 20:28
 */

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public Long create(Appointment appointment) {
        appointment.setPublishTime(new Date());
        appointmentMapper.create(appointment);
        return appointment.getAid();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentMapper.getAppointmentById(id);
    }

    @Override
    public void delete(Long id) {
        appointmentMapper.delete(id);
    }

    @Override
    public List<AppointmentVo> get(Page page) {
        PageDto pageDto = new PageDto(page);
        return appointmentMapper.get(pageDto);
    }

    @Override
    public void updateStatus(Long id,Boolean status) {
        appointmentMapper.updateStatus(id,status);
    }

    @Override
    public Integer getTotalNum() {
        return appointmentMapper.getTotalNum();
    }
}
