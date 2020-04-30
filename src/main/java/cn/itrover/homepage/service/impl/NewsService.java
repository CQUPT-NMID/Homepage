package cn.itrover.homepage.service.impl;

import cn.itrover.homepage.bean.News;
import cn.itrover.homepage.bean.vo.NewsVo;
import cn.itrover.homepage.mapper.NewsMapper;
import cn.itrover.homepage.service.INewsService;
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
 * @date 2020/2/21 11:22
 */
@Service
public class NewsService implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Long updateNews(News news) {
        if (news.getId() == null){
            news.setPublishTime(new Date());
            newsMapper.saveNews(news);
        }else{
            newsMapper.updateNews(news);
        }
        return news.getId();
    }

    @Override
    public void deleteNews(Long id) {
        newsMapper.deleteNewsById(id);
    }

    @Override
    public News getNewsById(Long id) {
        return newsMapper.getNewsById(id);
    }

    @Override
    public List<NewsVo> listNews(Page page) {
        PageDto dto = new PageDto(page);
        return newsMapper.listNews(dto);
    }

    @Override
    public Integer getNewsTotalNum() {
        return newsMapper.getTotalNum();
    }
}
