package com.mao.core.design.pattern.structural.bridge;

/**
 * @author maojiawei
 */
public abstract class Bank {
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();

}
