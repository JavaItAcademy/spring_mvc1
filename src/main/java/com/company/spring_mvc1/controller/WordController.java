package com.company.spring_mvc1.controller;

import com.company.spring_mvc1.entity.Word;
import com.company.spring_mvc1.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/words")
public class WordController {

    @Autowired
    WordService wordService;

    @GetMapping("/{wordId}")
    public String getSaveWord(Model model, @PathVariable(value = "wordId", required = false) Long wordId){
        model.addAttribute("word", wordId == null ? new Word() : wordService.findById(wordId));
        return "words/wordSaving";
    }

    @GetMapping("/new")
    public String getSaveNewWord(Model model){
        model.addAttribute("word", new Word());
        return "words/wordSaving";
    }

    @PostMapping
    public String saveNewWord(@ModelAttribute Word word){
        wordService.save(word);
        return "redirect:/words/wordsList";
    }

    @GetMapping("/wordsList")
    public String getAllWords(Model model){
        model.addAttribute("allWords", wordService.findAll());
        return "words/wordsList";
    }

    @GetMapping("/delete/{wordId}")
    public String deleteWord(@PathVariable("wordId") Long wordId){
        wordService.delete(wordId);
        return "redirect:/words/wordsList";
    }

}
