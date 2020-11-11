package com.example.demo.controller;

import com.example.demo.model.Language;
import com.example.demo.service.LanguageService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * LanguageController est le controleur qui s'occupe  de l'appel du service LanguageService
 */
@RestController
public class LanguageController {
    @Autowired
    LanguageService languageService;


    /**
     * @return la liste des langages avec leurs nombre d'utilisation et les urls des repos qui les utilisent.
     * @throws JSONException
     */

    @GetMapping(path="/languages",produces = "application/json; charset=UTF-8")
    public  List<Language> getLanguages() throws JSONException { return languageService.getLanguages(); }



}
