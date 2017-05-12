package com.patrik.gorin.controller;

import com.patrik.gorin.model.Words;
import com.patrik.gorin.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by patrik on 2017.05.11..
 */

@Controller
public class ChildGameController {

    @Autowired
    WordsRepository wordsRepository;

    @RequestMapping("/startGame")
    public String startGame(@RequestParam(value = "rank") String rank,
                            @RequestParam(value = "type") String type,
                            Model model){


        List<Words> listOfWords = wordsRepository.findByType(type);
        List<String> listOfHungarian = new ArrayList<>();
        List<String> listOfJapanese = new ArrayList<>();

        for(Words word : listOfWords){
            listOfHungarian.add(word.getHungarianWord());
            listOfJapanese.add(word.getJapaneseWord());
        }

        Collections.shuffle(listOfJapanese);

        model.addAttribute("japaneses", listOfJapanese);
        model.addAttribute("results", listOfHungarian);


        return "childGameEvent";
    }
}
