package cn.itrover.homepage.mapper;

import cn.itrover.homepage.bean.Appointment;
import cn.itrover.homepage.bean.vo.AppointmentVo;
import cn.itrover.homepage.utils.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/19 20:27
 */

@Mapper
@Component
public interface AppointmentMapper {

    public Long create(Appointment appointment);

    Appointment getAppointmentById(Long id);

    void delete(Long id);

    List<AppointmentVo> get(@Param("start") Integer start,@Param("end") Integer end);
}
