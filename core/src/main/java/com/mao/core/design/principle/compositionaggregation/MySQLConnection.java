package com.mao.core.design.principle.compositionaggregation;

/**
 * @author maojiawei
 */
public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
