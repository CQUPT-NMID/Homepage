package cn.itrover.homepage.controller;

import cn.itrover.homepage.annotation.ResponseResult;
import cn.itrover.homepage.bean.Appointment;
import cn.itrover.homepage.bean.vo.AppointmentVo;
import cn.itrover.homepage.service.impl.AppointmentService;
import cn.itrover.homepage.utils.Page;
import cn.itrover.homepage.utils.PageResult;
import cn.itrover.homepage.utils.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/19 20:30
 */

@Slf4j
@Api(tags = "预约参观相关")
@RestController
@RequestMapping("/api/appointment")
@ResponseResult
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @ApiOperation("新建预约参观")
    @PostMapping
    public Long create(@RequestBody @ApiParam(value = "参观信息",required = true) Appointment appointment){
        Long id = appointmentService.create(appointment);
        return id;
    }

    @ApiOperation("通过id获取详细参观信息")
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        Appointment appointment = appointmentService.getAppointmentById(id);
        return appointment;
    }

    @ApiOperation("删除预约参观信息")
    @DeleteMapping("/{id}")
    public Status delete(@PathVariable Long id){
        appointmentService.delete(id);
        return Status.SUCCESS;
    }

    @ApiOperation("获取参观信息列表")
    @GetMapping
    public PageResult get(Page page){
       List<AppointmentVo> data = appointmentService.get(page);
       Integer total = appointmentService.getTotalNum();
        PageResult result = new PageResult(data, total, page);
        return result;
    }

    @ApiOperation("更新接待状态")
    @PutMapping
    public Status updateStatus(@RequestParam(required = true) Long id,
                               @RequestParam(required = true) @ApiParam(value = "接待状态",required = true) boolean status){
        appointmentService.updateStatus(id,status);
        return Status.SUCCESS;
    }

}
