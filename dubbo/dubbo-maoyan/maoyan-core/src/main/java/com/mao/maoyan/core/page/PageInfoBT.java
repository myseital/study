package com.mao.maoyan.core.page;

import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;

import java.util.List;

/**
 * 分页结果的封装(for Bootstrap Table)
 *
 * @author maojiawei
 */
@Data
public class PageInfoBT<T> {

    /**
     * 结果集
     */
    private List<T> rows;

    /**
     * 总数
     */
    private Long total;

    public PageInfoBT(Page<T> page) {
        this.rows = page.getRecords();
        this.total = page.getTotal();
    }
}
