package cn.itrover.homepage.utils;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  分页返回结果
 * @date 2020/2/4 13:33
 */

public class PageResult {

    /**
     * 当前页码
     */
    private int pageNum;

    /**
     * 每页数量
     */
    private int pageSize;

    /**
     * 页码总数
     */
    private int totalPage;

    /**
     * 记录总数
     */
    private long totalSize;

    /**
     * 数据模型
     */
    private List<?> data;

    /**
     * 封装信息
     * @param
     */
    public PageResult(List<?> data,int total,Page page) {
        this.data = data;
        this.totalSize = total;
        if (page != null && page.getPageSize() > 0){
            System.out.println(page);
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.totalPage = total/page.getPageSize();
            if (total % page.getPageSize() != 0){
                this.totalPage += 1;
            }
        }else{
            int num = total == 0 ? 0 : 1;
            this.pageNum = num;
            this.pageSize = total;
            this.totalPage = num;
        }
    }

    public PageResult() {

    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public long getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
    public List<?> getData() {
        return data;
    }
    public void setData(List<?> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalSize=" + totalSize +
                ", data=" + data +
                '}';
    }

}