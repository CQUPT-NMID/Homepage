package cn.itrover.homepage.controller;

import cn.itrover.homepage.annotation.ResponseResult;
import cn.itrover.homepage.bean.News;
import cn.itrover.homepage.bean.User;
import cn.itrover.homepage.bean.vo.NewsVo;
import cn.itrover.homepage.service.INewsService;
import cn.itrover.homepage.utils.Page;
import cn.itrover.homepage.utils.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/20 23:36
 */
@Slf4j
@Api(tags = "新闻 ")
@RestController
@RequestMapping("/api")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @ApiOperation("发布或修改新闻")
    @PostMapping("/news")
    @ResponseResult
    public Long createNews(@RequestBody @ApiParam(value = "新闻信息", required = true) News news) {
        log.info(news.toString());
        Long id = newsService.updateNews(news);
        return id;
    }

    @ApiOperation("删除新闻")
    @DeleteMapping("/news/{id}")
    @ResponseResult
    public Status deleteNews(@PathVariable(value = "id", required = true) @ApiParam(value = "新闻id", required = true) Long id) {
        newsService.deleteNews(id);
        return Status.SUCCESS;
    }

    @ApiOperation("通过id获取新闻详情")
    @GetMapping("/news/{id}")
    @ResponseResult
    public News getNewsById(@PathVariable(value = "id", required = true) @ApiParam(value = "新闻id", required = true) Long id){
        News news = newsService.getNewsById(id);
        return news;
    }


    @ApiOperation("获取新闻列表")
    @GetMapping("/news")
    @ResponseResult
    public List<NewsVo> getNewsList(@RequestParam(required = false)Page page){
        List<NewsVo> list = newsService.listNews(page);
        return list;
    }


}
