package com.patrik.gorin.repository;

import com.patrik.gorin.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by patrik on 2017.05.10..
 */

@Repository
public interface WordsRepository extends JpaRepository<Words, Long> {

    List<Words> findByType(String type);
    Words findByJapaneseWord(String word);
    List<Words> findByRank(Integer rank);

}
