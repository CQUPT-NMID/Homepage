package cn.itrover.homepage.service.impl;

import cn.itrover.homepage.bean.Project;
import cn.itrover.homepage.bean.User;
import cn.itrover.homepage.bean.dto.PageDto;
import cn.itrover.homepage.bean.query.LoginUser;
import cn.itrover.homepage.bean.vo.PlatformVo;
import cn.itrover.homepage.bean.vo.ProjectVo;
import cn.itrover.homepage.bean.vo.UserVo;
import cn.itrover.homepage.mapper.UserMapper;
import cn.itrover.homepage.service.IUserService;
import cn.itrover.homepage.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/20 22:07
 */

@Service
public class UserService implements IUserService {

   @Autowired
   private UserMapper userMapper;

    @Override
    public User login(LoginUser user) {
        return userMapper.login(user);
    }

    @Override
    public void create(User user) {
        userMapper.save(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<UserVo> getUserByPlatform(String platform) {
        return userMapper.getUserByPlatform(platform);
    }

    @Override
    public User getUserDetail(String unam) {
        return userMapper.getUserDetail(unam);
    }

    @Override
    public List<ProjectVo> getProjectList(Page page) {
        PageDto pageDto = new PageDto(page);
        return userMapper.getProjectList(pageDto);
    }

    @Override
    public Project getProjectDetail(Long id) {
        return userMapper.getProjectDetail(id);
    }

    @Override
    public List<PlatformVo> getPlatforms() {
        return userMapper.getPlatforms();
    }


}
