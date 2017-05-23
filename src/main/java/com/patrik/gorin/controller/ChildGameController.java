package com.patrik.gorin.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrik.gorin.model.Words;
import com.patrik.gorin.repository.WordsRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.*;

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


        List<Words> listOfAll = wordsRepository.findAll();
        List<Words> listOfWords;

        if(type.equals("all")){
            listOfWords = wordsRepository.findAll();
        } else {
            listOfWords = wordsRepository.findByType(type);
        }

        Map<String, List> data = new HashMap<>();

        Collections.shuffle(listOfWords);

        for(Words word : listOfWords){
            List<String> listOfResults = new ArrayList<>();
            listOfResults.add(word.getHungarianWord());

            for(Words badWord : listOfAll){
                Collections.shuffle(listOfAll);
                if(!listOfResults.contains(badWord.getHungarianWord()) && listOfResults.size() < 3){
                    listOfResults.add(badWord.getHungarianWord());
                }
            }
            Collections.shuffle(listOfResults);
            data.put(word.getJapaneseWord(), listOfResults);
        }
        model.addAttribute("datas", data);
        return "childGameEvent";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public Map incomingData(@RequestBody String body) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String,String> result = mapper.readValue(body, HashMap.class);


        Map<String, ArrayList<String>> response = new HashMap<>();


        for ( Map.Entry<String, String> res : result.entrySet()){

            Words actualWord = wordsRepository.findByJapaneseWord(res.getKey());
            ArrayList<String> actualList = new ArrayList<>();
            actualList.add(actualWord.getHungarianWord());

            if(Objects.equals(actualWord.getHungarianWord(), res.getValue())){
                actualList.add("true");
                response.put(res.getKey(), actualList);
            }
            else{
                actualList.add("false");
                response.put(res.getKey(), actualList);
            }
        }


        return response;
    }
}
