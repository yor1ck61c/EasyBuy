package io.oicp.yorick61c.domain;
/*
* 抽取的辅助泛型类PageBean，用于装配每次分页查询的数据
* */
import java.util.List;

public class PageBean<E> {

    private List<E> items; //查询并展示的对象
    private Integer currentPage; //当前页数
    private Integer rows; //每页显示的行数
    private Integer totalItems;  //全部个数
    private Integer totalPages;  //全部页数

    public PageBean() {
    }

    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "items=" + items +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                ", totalItems=" + totalItems +
                ", totalPages=" + totalPages +
                '}';
    }
}
