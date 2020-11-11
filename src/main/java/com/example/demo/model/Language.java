package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

/**
 * le model pour encapsuler les donnes de retoure de l'api
 * name le nom du langage
 * number_of_respositories le nombre de langages utlisant cette langage
 * repositories_url une liste des url des repositories utilisants cette langage
 */

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Language{
    private String name;
    private  int number_of_respositories=0;
    private List<String> repositories_url= new ArrayList<>();
}
