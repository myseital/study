package com.mao.core.design.principle.compositionaggregation;

/**
 * @author maojiawei
 */
public class PostgreSQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "PostgreSQL数据库连接";
    }
}
