package cn.itrover.homepage.controller;

import cn.itrover.homepage.annotation.ResponseResult;
import cn.itrover.homepage.bean.Project;
import cn.itrover.homepage.bean.User;
import cn.itrover.homepage.bean.dto.TokenUser;
import cn.itrover.homepage.bean.query.LoginUser;
import cn.itrover.homepage.bean.vo.PlatformVo;
import cn.itrover.homepage.bean.vo.ProjectVo;
import cn.itrover.homepage.bean.vo.UserVo;
import cn.itrover.homepage.service.IUserService;
import cn.itrover.homepage.utils.JwtUtil;
import cn.itrover.homepage.utils.Page;
import cn.itrover.homepage.utils.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/20 22:05
 */

@Api(tags = "用户相关: 用户 平台 项目")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    private TokenUser getTokenUser(){
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        TokenUser user = (TokenUser)request.getAttribute(JwtUtil.USER);
        return user;
    }

    @ApiOperation("用户登陆")
    @PostMapping("/user/login")
    public ResponseEntity loginIn(@RequestBody(required = true) LoginUser user){
        User result = userService.login(user);
        if (result != null){
            String token = jwtUtil.createToken(new TokenUser(result));
            return new ResponseEntity<String>(token,HttpStatus.OK);
        }else {
            return new ResponseEntity<String>(Status.FAULT_PASSWORD.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("添加用户")
    @PostMapping("/user")
    public Object create(@RequestBody @ApiParam(value = "用户信息",required = true) User user){
           userService.create(user);
           return Status.SUCCESS;
    }


    @ApiOperation("修改用户")
    @PutMapping("/user")
    public Object updateUser(@RequestBody @ApiParam(value = "用户信息",required = true) User user){
        if (user.getUnam() == null){
            user.setUnam(getTokenUser().getUnam());
        }
        userService.updateUser(user);
        return Status.SUCCESS;
    }

    @ApiOperation("通过用户名获取用户详情")
    @GetMapping("/user/detail")
    @ResponseResult
    public User getUserDetail(@RequestParam(required = false) String unam){
        if (unam == null){
            unam = getTokenUser().getUnam();
        }
        User user = userService.getUserDetail(unam);
        return user;
    }

    @ApiOperation(("通过平台名获取用户"))
    @GetMapping("/user")
    @ResponseResult
    public List<UserVo> getUserByPlatform(@RequestParam(required = false) @ApiParam(value = "平台名",required = false) String platform){
       List<UserVo> users =  userService.getUserByPlatform(platform);
       return users;
    }
    @ApiOperation("获取所有平台")
    @GetMapping("/platform")
    @ResponseResult
    public List<PlatformVo> getPlatform(){
        List<PlatformVo> list = userService.getPlatforms();
        return list;
    }

    /**
     * -------------------------------------------------------------------------------------
     *     ********************************************************************************
     *                  项目相关
     *     ********************************************************************************
     * -------------------------------------------------------------------------------------
     */

    @ApiOperation("获取项目列表")
    @GetMapping("/project")
    @ResponseResult
    public List<ProjectVo> getProjectList(@RequestParam(required = false) Page page){
       List<ProjectVo> list = userService.getProjectList(page);
       return list;
    }

    @ApiOperation("获取项目详情")
    @GetMapping("/project/{id}")
    @ResponseResult
    public Project getProjectDetail(@PathVariable("id") @ApiParam(value ="id",required = true) Long id){
        Project project = userService.getProjectDetail(id);
        return project;
    }




}



