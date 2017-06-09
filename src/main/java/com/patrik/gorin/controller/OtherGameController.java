package com.patrik.gorin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by patrik on 2017.06.04..
 */

@Controller
public class OtherGameController {


    @RequestMapping("/otherGame")
    public String otherGame(){
        return "otherGame";
    }





}
