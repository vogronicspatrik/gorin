package com.patrik.gorin.model;

import javax.persistence.*;

/**
 * Created by patrik on 2017.05.10..
 */

@Entity
@Table(name = "words")
public class Words {

    Long ID;
    String type;
    Integer rank;
    String hungarianWord;
    String japaneseWord;


    public Words() {}

    public Words(String type, Integer rank,  String hungarianWord, String japaneseWord) {
        this.rank = rank;
        this.type = type;
        this.hungarianWord = hungarianWord;
        this.japaneseWord = japaneseWord;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long getID() {
        return ID;
    }

    public Integer getRank() {
        return rank;
    }

    public String getType() {
        return type;
    }

    public String getHungarianWord() {
        return hungarianWord;
    }

    public String getJapaneseWord() {
        return japaneseWord;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setHungarianWord(String hungarianWord) {
        this.hungarianWord = hungarianWord;
    }

    public void setJapaneseWord(String japaneseWord) {
        this.japaneseWord = japaneseWord;
    }
}
