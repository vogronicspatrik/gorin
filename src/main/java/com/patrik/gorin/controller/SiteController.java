package com.patrik.gorin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by patrik on 2017.03.13..
 */

@Controller
public class SiteController {

    @RequestMapping("/")
    public String index(){ return "index";}
}
