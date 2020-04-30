package cn.itrover.homepage.controller;

import cn.itrover.homepage.annotation.ResponseResult;
import cn.itrover.homepage.bean.Project;
import cn.itrover.homepage.bean.User;
import cn.itrover.homepage.bean.dto.TokenUser;
import cn.itrover.homepage.bean.query.LoginUser;
import cn.itrover.homepage.bean.vo.PlatformVo;
import cn.itrover.homepage.bean.vo.ProjectVo;
import cn.itrover.homepage.bean.vo.UserVo;
import cn.itrover.homepage.exception.BadRequestException;
import cn.itrover.homepage.service.IUserService;
import cn.itrover.homepage.utils.JwtUtil;
import cn.itrover.homepage.utils.Page;
import cn.itrover.homepage.utils.Result;
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
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

    private TokenUser getTokenUser() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        TokenUser user = (TokenUser) request.getAttribute(JwtUtil.USER);
        return user;
    }

    @ApiOperation("用户登陆")
    @PostMapping("/user/login")
    public ResponseEntity loginIn(@RequestBody(required = true) LoginUser user) {
        User result = userService.login(user);
        if (result != null) {
            String token = jwtUtil.createToken(new TokenUser(result));
            return new ResponseEntity<String>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(Status.FAULT_PASSWORD.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//      不具备 添加用户的功能
//    @ApiOperation("添加用户")
//    @PostMapping("/user")
//    @ApiIgnore
//    public Object create(@RequestBody @ApiParam(value = "用户信息",required = true) User user){
//           userService.create(user);
//           return Status.SUCCESS;
//    }


    @ApiOperation("修改用户,UANM无需传，必须在服务器里获取，避免恶意行为")
    @PutMapping("/user")
    public Object updateUser(@RequestBody @ApiParam(value = "用户信息", required = true) User user) {
//        if (user.getUnam() == null){
        /**
         * 无论如何都要从token中取用户的信息，不然会出现修改他人信息的恶意行为
         */
        TokenUser tokenUser = getTokenUser();
        if (tokenUser == null || tokenUser.getUnam() == null) {
            throw new BadRequestException(Status.NOT_LOGIN.getMessage());
        }
        user.setUnam(tokenUser.getUnam());
//        }
        userService.updateUser(user);
        return Status.SUCCESS;
    }

    @ApiOperation("通过用户名获取用户详情")
    @GetMapping("/user/detail")
    @ResponseResult
    public User getUserDetail(@RequestParam(required = false) @ApiParam(value = "用户名： 不传值，返回的就是当前登陆用户的信息", required = false) String unam) {
        if (unam == null) {
            unam = getTokenUser().getUnam();
            if (unam == null) {
                throw new BadRequestException(Status.NOT_LOGIN.getMessage());
            }
        }
        User user = userService.getUserDetail(unam);
        return user;
    }

    @ApiOperation(("通过平台名获取用户"))
    @GetMapping("/user")
    @ResponseResult
    public List<UserVo> getUserByPlatform(@RequestParam(required = false) @ApiParam(value = "平台名,中文", required = false) String platform) {
        List<UserVo> users = userService.getUserByPlatform(platform);
        return users;
    }

    @ApiOperation("获取所有平台")
    @GetMapping("/platform")
    @ResponseResult
    public List<PlatformVo> getPlatform() {
        List<PlatformVo> list = userService.getPlatforms();
        return list;
    }

    /**
     * -------------------------------------------------------------------------------------
     * ********************************************************************************
     * 项目相关
     * ********************************************************************************
     * -------------------------------------------------------------------------------------
     */


    @ApiOperation("获取项目列表")
    @GetMapping("/project")
    @ResponseResult
    public List<ProjectVo> getProjectList(Page page) {
        List<ProjectVo> list = userService.getProjectList(page);
        return list;
    }


    /**
     * 项目的字段  需要改进
     *
     * @param id
     * @return
     */
    @ApiOperation("获取项目详情")
    @GetMapping("/project/{id}")
    @ResponseResult
    public Project getProjectDetail(@PathVariable("id") @ApiParam(value = "id", required = true) Long id) {
        Project project = userService.getProjectDetail(id);
        return project;
    }


    /**
     * 字段有待改进
     *
     * @param project
     * @return
     */
    @ApiOperation("上传或更新项目")
    @PostMapping("/updateProject")
    public Result updateProject(@RequestBody @ApiParam(value = "项目信息", required = true) Project project) {
        Long id = userService.updateProject(project);
        HashMap<String, Object> map = new HashMap<>();
        map.put("pid", id);
        return Result.success(map);
    }

    @ApiOperation("获取用户的项目，发布的，参与的")
    @GetMapping("/getUserProjects")
    public Result getUserProjects(@RequestParam @ApiParam(value = "用户姓名", required = false) String username,
                                  @RequestParam @ApiParam(value = "判断是否是自己发布的,true 为是自己发布",required = true) boolean judge) {
        if (username == null) {
            TokenUser user = getTokenUser();
            username = user.getRealname();
        }
        List<ProjectVo> bps = userService.getUserProjects(username, judge);
        return Result.success(bps);
    }


}