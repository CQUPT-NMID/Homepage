package cn.itrover.homepage.service.impl;

import cn.itrover.homepage.bean.JoinUser;
import cn.itrover.homepage.bean.vo.JoinUserVo;
import cn.itrover.homepage.enums.OrderBy;
import cn.itrover.homepage.mapper.JoinUserMapper;
import cn.itrover.homepage.service.IJoinUserService;
import cn.itrover.homepage.utils.Page;
import cn.itrover.homepage.bean.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/20 17:26
 */

@Service
public class JoinUserService implements IJoinUserService {

    @Autowired
    private JoinUserMapper joinUserMapper;

    @Override
    public Long create(JoinUser joinUser) {
        joinUser.setDate(new Date());
        joinUserMapper.save(joinUser);
        return joinUser.getJuid();
    }

    @Override
    public JoinUser getJoinUserById(Long id) {
        return joinUserMapper.getJoinUserById(id);
    }

    @Override
    public void delete(Long id) {
        joinUserMapper.delete(id);
    }

    @Override
    public int getTotal(String platfrom) {
        return joinUserMapper.getTotal(platfrom);
    }

    @Override
    public List<JoinUserVo> list(Page page, String platform, OrderBy orderBy) {
        PageDto pageDto = new PageDto(page);
        return joinUserMapper.list(pageDto,platform,orderBy);
    }
}
