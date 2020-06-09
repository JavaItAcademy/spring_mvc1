package com.company.spring_mvc1.service;

import com.company.spring_mvc1.entity.Word;

import java.util.List;

public interface WordService {
    void save (Word word);
    List<Word> findAll();
    boolean delete(Long id);
    Word findById(Long id);
}
