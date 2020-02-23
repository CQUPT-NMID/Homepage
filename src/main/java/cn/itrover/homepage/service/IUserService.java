package cn.itrover.homepage.service;

import cn.itrover.homepage.bean.Project;
import cn.itrover.homepage.bean.User;
import cn.itrover.homepage.bean.query.LoginUser;
import cn.itrover.homepage.bean.vo.PlatformVo;
import cn.itrover.homepage.bean.vo.ProjectVo;
import cn.itrover.homepage.bean.vo.UserVo;
import cn.itrover.homepage.utils.Page;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
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
}
