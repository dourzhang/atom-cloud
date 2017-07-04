package com.watent.cloud;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Ribbon Client Configuration
 *
 * note : not in a @ComponentScan for the main application context, otherwise it will be shared by all the @RibbonClients
 * <p>
 * Created by Atom on 2017/7/4.
 */
@Configuration
public class ClientConfiguration {

//    @Autowired
//    IClientConfig iClientConfig;

    @Bean
    @ConditionalOnMissingBean
    public IClientConfig ribbonClientConfig() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties("ribbon-client");
        return config;
    }


    @Bean
    public IPing ribbonPing(IClientConfig iClientConfig) {

        return new PingUrl();
    }

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}
