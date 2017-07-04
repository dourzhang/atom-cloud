package com.watent.cloud.service;

import com.watent.cloud.FeignClientConfiguration;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Ribbon Server Client
 * <p>
 * Created by Atom on 2017/7/4.
 */
//@FeignClient("ribbon-server")
@FeignClient(name = "ribbon-server", configuration = FeignClientConfiguration.class)
public interface RibbonServerClient {

    //    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    @RequestLine("GET /greeting")
    String greeting();
}
