package cn.itrover.homepage.controller;

import cn.itrover.homepage.annotation.ResponseResult;
import cn.itrover.homepage.bean.JoinUser;
import cn.itrover.homepage.bean.vo.JoinUserVo;
import cn.itrover.homepage.service.IJoinUserService;
import cn.itrover.homepage.utils.Page;
import cn.itrover.homepage.utils.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/20 17:22
 */

@Api(tags = "加入")
@RestController
@RequestMapping("/api/join")
public class JoinUserController {

    @Autowired
    private IJoinUserService joinUserService;

    @ApiOperation("提交加入信息")
    @PostMapping
    @ResponseResult
    public Long create(@RequestBody @ApiParam(value = "用户加入信息",required = true) JoinUser joinUser){
       Long id = joinUserService.create(joinUser);
        return id;
    }

    @ApiOperation("查询")
    @GetMapping
    @ResponseResult
    public List<JoinUserVo> list(@RequestParam(required = false) @ApiParam(value = "分页",required = false)Page page){
       List<JoinUserVo> list = joinUserService.list(page);
       return list;
    }

    @ApiOperation("获取详细加入信息")
    @GetMapping("/{id}")
    @ResponseResult
    public JoinUser getJoinUserById(@PathVariable(value = "id",required = true) @ApiParam(value = "id",required = true)Long id){
        JoinUser joinUser = joinUserService.getJoinUserById(id);
        return joinUser;
    }

    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public Status delete(@PathVariable(value = "id",required = true) @ApiParam(value = "id",required = true)Long id){
        joinUserService.delete(id);
        return Status.SUCCESS;
    }
}
