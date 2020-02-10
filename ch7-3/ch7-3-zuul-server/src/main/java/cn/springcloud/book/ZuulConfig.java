package cn.springcloud.book;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {
    private String ribbonClientName = "ribbon-route";

    @Bean
    public PingUrl pingUrl(){
        return new PingUrl(false, "/health");
    }

    @Bean
    public IClientConfig ribbonClientConfig() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties(ribbonClientName);
        config.set(CommonClientConfigKey.ConnectTimeout, 30000);
        config.set(CommonClientConfigKey.ReadTimeout, 30000);
        return config;
    }
}
