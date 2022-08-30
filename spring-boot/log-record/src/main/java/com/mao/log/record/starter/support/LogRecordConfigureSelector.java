package com.mao.log.record.starter.support;

import com.mao.log.record.starter.annotaion.EnableLogRecord;
import com.mao.log.record.starter.configuration.LogRecordProxyAutoConfiguration;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.AutoProxyRegistrar;
import org.springframework.lang.Nullable;


public class LogRecordConfigureSelector extends AdviceModeImportSelector<EnableLogRecord> {

    @Override
    @Nullable
    public String[] selectImports(AdviceMode adviceMode) {
        switch (adviceMode) {
            case PROXY:
                return new String[]{AutoProxyRegistrar.class.getName(), LogRecordProxyAutoConfiguration.class.getName()};
            case ASPECTJ:
                return new String[]{LogRecordProxyAutoConfiguration.class.toString()};
            default:
                return null;
        }
    }
}