package com.watent.cloud.controller;

import com.watent.cloud.service.RibbonServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RibbonServer Controller
 * <p>
 * Created by Atom on 2017/7/4.
 */
@RestController
public class RibbonServerController {

    @Autowired
    private RibbonServerClient ribbonServerClient;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String add() {
        return ribbonServerClient.greeting();
    }
}
