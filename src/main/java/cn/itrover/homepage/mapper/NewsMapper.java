package cn.itrover.homepage.mapper;

import cn.itrover.homepage.bean.News;
import cn.itrover.homepage.bean.vo.NewsVo;
import cn.itrover.homepage.bean.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/21 11:24
 */
@Mapper
@Component
public interface NewsMapper {

    void saveNews(News news);

    void updateNews(News news);

    void deleteNewsById(Long id);

    News getNewsById(Long id);

    List<NewsVo> listNews(PageDto dto);
}
