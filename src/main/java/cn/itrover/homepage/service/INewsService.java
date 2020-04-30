package cn.itrover.homepage.service;

import cn.itrover.homepage.bean.News;
import cn.itrover.homepage.bean.vo.NewsVo;
import cn.itrover.homepage.utils.Page;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 平台相关
 * @date 2020/2/21 11:21
 */

public interface INewsService {

    /**
     * 保存新闻信息
     * @param news
     * @return
     */
    Long updateNews(News news);

    /**
     * 删除新闻
     * @param id
     */
    void deleteNews(Long id);

    /**
     * 通过id 获取新闻详情
     * @param id
     * @return
     */
    News getNewsById(Long id);

    /**
     * 获取新闻列表
     * @param page
     * @return
     */
    List<NewsVo> listNews(Page page);

    /**
     * 获取新闻条数
     * @return
     */
    Integer getNewsTotalNum();
}
