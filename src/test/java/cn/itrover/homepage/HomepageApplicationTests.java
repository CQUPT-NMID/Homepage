package cn.itrover.homepage;

import cn.itrover.homepage.bean.Appointment;
import cn.itrover.homepage.bean.JoinUser;
import cn.itrover.homepage.bean.Project;
import cn.itrover.homepage.bean.User;
import cn.itrover.homepage.bean.vo.JoinUserVo;
import cn.itrover.homepage.controller.AppointmentController;
import cn.itrover.homepage.controller.JoinUserController;
import cn.itrover.homepage.controller.NewsController;
import cn.itrover.homepage.controller.UserController;
import cn.itrover.homepage.enums.OrderBy;
import cn.itrover.homepage.mapper.AppointmentMapper;
import cn.itrover.homepage.utils.Page;
import cn.itrover.homepage.utils.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.awt.dnd.DropTarget;
import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
class HomepageApplicationTests {

    @Autowired
    private UserController userController;

    @Autowired
    private JoinUserController joinUserController;

    @Autowired
    private NewsController newsController;

    @Autowired
    private AppointmentController appointmentController;

    @Test
    void contextLoads() {
//        OrderBy orderBy = OrderBy.ASC;
//        System.out.println(orderBy.toString());
//        System.out.println(orderBy);
    }

    @Test
    void userControllerTest() {
//        Project project = new Project();
//        project.setBeginTime(new Date());
//        project.setImage("https://cn.bing.com/th?id=OHR.SiestaKey_ZH-CN1759696989_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp");
//        project.setIntroduction("微信展览助手与虚拟汇报平台");
//        project.setPname("微信展览助手");
//        project.setPRealname("姚政");
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("马云豪");
//        strings.add("邱淋");
//        strings.add("杨锦");
//        strings.add("张明旋");
//        project.setMembers(strings);
//        project.setPid(6L);
//        System.out.println(userController.updateProject(project));
    }

    @Test
    void  TestGet(){
//        System.out.println(userController.getProjectDetail(6L));
//        System.out.println(userController.getUserProjects("姚科",true));
//        System.out.println(userController.getUserDetail("admin"));
//        System.out.println(userController.getProjectList(null));
//        System.out.println(userController.getUserProjects("马云豪",false));
//        System.out.println(userController.getPlatform());
//          System.out.println(userController.getUserByPlatform("服务器"));
//        System.out.println(joinUserController.list(null,"服务器",OrderBy.DESC));
    }
    @Test
    void  TestSet(){
//        userController.getProjectDetail(6L);
    }
    @Test
    void  TestUpdate(){
//        User user = new User();
//        user.setUnam("admin");
//        user.setDuty("测试项目");
//        user.setEmail("1172610139@qq.com");
//        user.setPlatform("太空");
//        user.setTelephone("1888385127");
//        user.setSkill("吃");
//        userController.updateUser(user);
    }
}
