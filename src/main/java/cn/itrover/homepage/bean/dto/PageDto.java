package cn.itrover.homepage.bean.dto;

import cn.itrover.homepage.utils.Page;
import lombok.Getter;
import lombok.Setter;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/20 22:47
 */

@Getter
@Setter
public class PageDto {

    private int start;

    private int end;

    public PageDto(Page page){
        if(page == null){
            this.start = 0;
            end = 1000;
        }else{
            this.start = (page.getPageNum()-1)*page.getPageSize();
            this.end = this.start + page.getPageSize();
        }
    }
}
