package com.fengchuang.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author myseital
 * @date 2022/2/8 16:38
 */
@Data
public class PageResultVO<T> implements Serializable {

    private int code;

    private String message;

    /**
     * 分页的结果集
     */
    private List<T> rows;

    /**
     * 总的记录数
     */
    private Long total;

    public PageResultVO<T> buildSuccess(List<T> rows) {
        PageResultVO<T> vo = new PageResultVO<>();
        vo.setCode(0);
        vo.setMessage("");
        vo.setRows(rows);
        return vo;
    }

    public void buildSuccess(List<T> rows, Long total) {
        this.setCode(0);
        this.setMessage("");
        this.setRows(rows);
        this.setTotal(total);
    }

    public static PageResultVO buildError(int code, String message) {
        PageResultVO vo = new PageResultVO<>();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }

    public boolean isSuccess() {
        return 0 == code;
    }
}
