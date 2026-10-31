package com.yawolart.springBootDemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("payment-gateway")
public class PaymentProperties {
    private String type;
    private int retryCount;
    private boolean enable;
    private long timeout;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }


}
