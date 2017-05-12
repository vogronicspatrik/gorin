package com.patrik.gorin.controller.admin;

import com.patrik.gorin.model.Words;
import com.patrik.gorin.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by patrik on 2017.05.10..
 */

@Controller
@RequestMapping("admin")
public class AdminController {


    @Autowired
    WordsRepository wordsRepository;

    @RequestMapping("/add")
    public String addWord(@RequestParam(value = "type") String type,
                          @RequestParam(value = "hungarianWord") String hungarianWord,
                          @RequestParam(value = "japaneseWord") String japaneseWord,
                          Model model){

        Words newWord = new Words(type, hungarianWord, japaneseWord);
        wordsRepository.save(newWord);
        return "redirect:/admin";
    }

    @RequestMapping("/delete/{values_id}")
    public String delete(@PathVariable Integer values_id){


        System.out.println("anyad");
        wordsRepository.delete(Long.valueOf(values_id));
        return "redirect:/admin";
    }


}
