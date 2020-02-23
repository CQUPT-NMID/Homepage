package cn.itrover.homepage.mapper;

import cn.itrover.homepage.bean.JoinUser;
import cn.itrover.homepage.bean.vo.JoinUserVo;
import cn.itrover.homepage.bean.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/20 17:27
 */

@Mapper
@Component
public interface JoinUserMapper {

    public void save(JoinUser joinUser);

    List<JoinUserVo> list(PageDto pageDto);

    JoinUser getJoinUserById(Long id);

    void delete(Long id);
}
