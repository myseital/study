package com.mao.maoyan.core.page;

import lombok.Data;

/**
 * 分页参数类（for BootStrap Table）
 *
 * @author maojiawei
 */
@Data
public class PageBT {

    /**
     * 每页显示个数
     */
    private Integer limit;

    /**
     * 查询的偏移量（查询的页数 = offset/limit + 1）
     */
    private Integer offset;

    /**
     * 排序方式
     */
    private String order;

    public PageBT(int limit, int offset) {
        super();
        this.limit = limit;
        this.offset = offset;
    }

    public int getPageSize() {
        return this.limit;
    }

    public int getPageNumber() {
        return this.offset / this.limit + 1;
    }

}
