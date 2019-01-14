package com.mao.maoyan.core.datascope;

import lombok.Data;

import java.util.List;

/**
 * 数据范围
 *
 * @author maojiawei
 */
@Data
public class DataScope {

    /**
     * 限制范围的字段名称
     */
    private String scopeName = "deptid";

    /**
     * 具体的数据范围
     */
    private List<Integer> deptIds;

    public DataScope() {
    }

    public DataScope(List<Integer> deptIds) {
        this.deptIds = deptIds;
    }

    public DataScope(String scopeName, List<Integer> deptIds) {
        this.scopeName = scopeName;
        this.deptIds = deptIds;
    }
}
