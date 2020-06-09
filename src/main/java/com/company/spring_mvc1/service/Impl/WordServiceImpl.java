package com.company.spring_mvc1.service.Impl;

import com.company.spring_mvc1.entity.Word;
import com.company.spring_mvc1.repository.WordRepository;
import com.company.spring_mvc1.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    WordRepository wordRepository;

    public void save (Word word){
        wordRepository.save(word);
    }

    public List<Word> findAll(){
        return wordRepository.findAll();
    }

    public boolean delete(Long id){
        if(wordRepository.findById(id).isPresent()){
            wordRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Word findById(Long id){
        return wordRepository.findById(id).orElse(new Word());
    }
}
