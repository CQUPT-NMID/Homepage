package cn.itrover.homepage.service;

import cn.itrover.homepage.bean.Project;
import cn.itrover.homepage.bean.User;
import cn.itrover.homepage.bean.query.LoginUser;
import cn.itrover.homepage.bean.vo.PlatformVo;
import cn.itrover.homepage.bean.vo.ProjectVo;
import cn.itrover.homepage.bean.vo.UserVo;
import cn.itrover.homepage.utils.Page;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  用户相关业务
 * @date 2020/2/20 22:06
 */
public interface IUserService {

    /**
     * 添加用户信息
     * @param user
     */
    void create(User user);

    /**
     * 用户登陆
     * @param user
     */
    User login(LoginUser user);

    /**
     * 获取所有平台
     * @return
     */
    List<PlatformVo> getPlatforms();

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    void updateUser(User user);

    /**
     * 通过平台名 获取用户
     * @param platform
     * @return
     */
    List<UserVo> getUserByPlatform(String platform);

    /**
     * 获取用户详情
     * @param unam
     * @return
     */
    User getUserDetail(String unam);

    /**
     * 获取项目列表
     * @param page
     * @return
     */
    List<ProjectVo> getProjectList(Page page);

    /**
     * 获取项目详情
     * @param id
     * @return
     */
    Project getProjectDetail(Long id);

    /**
     * 后台管理，添加或更新项目
     * @param project
     * @return
     */
    Long updateProject(Project project);


    /**
     * 通过用户名查询 用户的项目
     * @param username 用户姓名
     * @param judge 判断是否是自己发布的
     * @return  项目列表
     */
    List<ProjectVo> getUserProjects(String username, boolean judge);
}
