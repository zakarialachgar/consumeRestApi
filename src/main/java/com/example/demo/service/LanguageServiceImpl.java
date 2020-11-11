package com.example.demo.service;

import com.example.demo.staticParams.StaticParams;
import com.example.demo.model.Language;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * L'implementation de l'interface LanguageService
 */
@Service
public class LanguageServiceImpl implements LanguageService {
    @Override
    public String getApiUrl(String url,String access_token){
        return  url+"?access_token="+access_token;
    }


    @Override
    public List<Language> getLanguages() throws JSONException {

            // the set contians the return list  , i have chosen a set instead of a List , because the  set eliminates duplicates elements

             HashSet<Language> languages = new HashSet<Language>();

            // RestTemplate une classe qui permet l'execution des requettes http synchrone vers une resource en consomant le retoure sous form de Json ou String

           RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(getApiUrl(StaticParams.URL,StaticParams.ACCESS_TOKEN), String.class);
            JSONObject json = new JSONObject(result);
            JSONArray repositories = json.getJSONArray(StaticParams.ITEMS);

            // dans le corps de cette boucle on parcourt l'attribut ITMES pour extraire les informations sur les repositories
            // si le langage recuperer n'existe pas on l'ajoute dans l'ensemble "languages"
           // avec une incrementation de l'attribut number_of_repositires et l'ajout d'url du repo dans l'attribut repositories_url.
           // si le langage existe deja on incremente l'attribut number_of_repositires et on ajoute l'url du repo dans l'attribut repositories_url

            for (int j = 0 ; j <repositories.length() ; j++) {
                String languages_url = repositories.getJSONObject(j).getString(StaticParams.LANGUAGES_URL) ;
                String html_url = repositories.getJSONObject(j).getString(StaticParams.HTML_URL) ;
                try {
                    RestTemplate restTemplate2 = new RestTemplate();
                    String used_languages = restTemplate2.getForObject(languages_url, String.class);
                    JSONObject jsonObject = new JSONObject(used_languages);
                    JSONArray languages_names = jsonObject.names();

                    if(languages_names != null){
                        for (int i = 0; i < languages_names.length(); i++) {
                            String current_language = languages_names.getString(i);
                            if (!languages.stream().filter(l -> l.getName().equals(current_language)).findFirst().isPresent()) {
                                Language new_language = new Language() ;
                                new_language.setName(current_language);
                                new_language.setNumber_of_respositories(new_language.getNumber_of_respositories() + 1);
                                new_language.getRepositories_url().add(html_url);
                                languages.add(new_language);


                            }
                            else{
                                if(languages.stream().filter(l -> l.getName().equals(current_language)).findFirst().isPresent()){
                                    Optional<Language> language_exist = languages.stream().filter(l -> l.getName().equals(current_language)).findFirst();
                                    Language language_from_set = language_exist.get();
                                    language_from_set.setNumber_of_respositories(language_from_set.getNumber_of_respositories() + 1);
                                    language_from_set.getRepositories_url().add(html_url);
                                }
                            }


                        }
                    }


                }
                catch (Exception exception) {

                    throw new JSONException("Cannot call github api url " + exception) ;
                }

            }

            // cast the set to a list

            List<Language> final_response = languages.stream().collect(Collectors.toList());


           // final_reponse une liste qui contient les langages avec leur nombre d'utilisation et les liens vers les repositories qui l'utilise.
            return final_response;



    }
}
