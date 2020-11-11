package com.example.demo.service;

import com.example.demo.model.Language;
import org.json.JSONException;
import org.json.JSONObject;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.HashMap;
import java.util.List;

/**
 * LanguageService est l'interface du service de l'api qui retourne les langages
 */
public interface LanguageService {

   /**
    * @return une liste des langages utilsé
    * @throws JSONException
    */
   public List<Language> getLanguages() throws JSONException;


   /**
    * @param url l'url de la resource a consomer par le service
    * @param access_token 'l'access token github de l'utilisateur
    * @return l'url complet vers la resource
    */
   public String getApiUrl(String url,String access_token);

}
