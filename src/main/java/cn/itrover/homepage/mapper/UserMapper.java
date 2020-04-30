package cn.itrover.homepage.mapper;

import cn.itrover.homepage.bean.Project;
import cn.itrover.homepage.bean.User;
import cn.itrover.homepage.bean.dto.PageDto;
import cn.itrover.homepage.bean.query.LoginUser;
import cn.itrover.homepage.bean.vo.PlatformVo;
import cn.itrover.homepage.bean.vo.ProjectVo;
import cn.itrover.homepage.bean.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/20 22:13
 */

@Mapper
@Component
public interface UserMapper {

    void save(User user);

    User login(LoginUser user);

    void updateUser(User user);

    List<UserVo> getUserByPlatform(String platform);

    User getUserDetail(String unam);

    List<PlatformVo> getPlatforms();

    List<ProjectVo> getProjectList(PageDto pageDto);

    Project getProjectDetail(Long id);

    List<String> getProjectMember(Long pid);

    List<ProjectVo> getMyProject(String username);

    List<ProjectVo> getParticpteProject(String username);

    void updateProject(Project project);

    void saveProject(Project project);

    void saveProjectMembers(Long pid, List<String> members);

    void deleteprojectMembers(Long pid);

}
