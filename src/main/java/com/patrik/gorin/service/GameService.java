package com.patrik.gorin.service;

import com.patrik.gorin.model.Words;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by patrik on 2017.05.25..
 */

@Service
public class GameService {

    Map<String, List> data = new HashMap<>();


    public List<Words> chooseRandomsFromDatabase(List<Words> listOfWords, Integer numberOfQuestions){
        Collections.shuffle(listOfWords);
        List<Words> actualList = new ArrayList<>();

        for(int i = 0; i<numberOfQuestions;i++){
            actualList.add(listOfWords.get(i));
        }
        return actualList;
    }



    public Map collectModelContent(List<Words> listOfAll, List<Words> listOfWords, Integer numberOfButtons){

        for(Words word : listOfWords){
            List<String> listOfResults = new ArrayList<>();
            listOfResults.add(word.getHungarianWord());

            for(Words badWord : listOfAll){
                Collections.shuffle(listOfAll);
                if(!listOfResults.contains(badWord.getHungarianWord()) && listOfResults.size() < numberOfButtons){
                    listOfResults.add(badWord.getHungarianWord());
                }
            }
            Collections.shuffle(listOfResults);
            data.put(word.getJapaneseWord(), listOfResults);
        }

        return data;
    }

}
