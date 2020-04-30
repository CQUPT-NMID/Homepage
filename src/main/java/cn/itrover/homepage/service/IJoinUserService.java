package cn.itrover.homepage.service;

import cn.itrover.homepage.bean.JoinUser;
import cn.itrover.homepage.bean.vo.JoinUserVo;
import cn.itrover.homepage.enums.OrderBy;
import cn.itrover.homepage.utils.Page;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/20 17:26
 */
public interface IJoinUserService {
    /**
     * 新建 加入信息
     * @param joinUser
     * @return
     */
    Long create(JoinUser joinUser);


    /**
     * 获取 加入信息列表
     * @param page 分页请求
     * @param platform 平台
     * @param orderBy 时间顺序
     * @return
     */
    List<JoinUserVo> list(Page page, String platform, OrderBy orderBy);

    /**
     * 通过id 获取详细信息
     * @param id
     * @return
     */
    JoinUser getJoinUserById(Long id);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 查询 加入待处理总数
     * @param platfrom
     * @return
     */
    int getTotal(String platfrom);
}
