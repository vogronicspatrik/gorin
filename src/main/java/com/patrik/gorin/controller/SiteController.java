package com.patrik.gorin.controller;

import com.patrik.gorin.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by patrik on 2017.03.13..
 */

@Controller
public class SiteController {

    @Autowired
    WordsRepository wordsRepository;

    @RequestMapping("/")
    public String index(){ return "index";}

//    @RequestMapping("/game")
//    public  String game(){
//        return "game";
//    }

    @RequestMapping("/childGame")
    public  String childGame(Model model){


        model.addAttribute("words", wordsRepository.findAll());

        return "childGame";
    }

    @RequestMapping("/admin")
    public  String admin(Model model){


        model.addAttribute("words", wordsRepository.findAll());

        return "admin";
    }

}
