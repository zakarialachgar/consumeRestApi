package com.example.demo.staticParams;

/**
 * ACCESS_TOKEN une constant contient le token d'utlisateur pour acceder a github
 * URL le lien vers la resource de l'api a consomer
 * ITEMS les objets retourner par la resource sont contenu dans l'atribut ITEMS
 * HTML_URL est l'atribut des repositries parcouru
 * LANGUAGES_URL l'atribut des langages utiliser par les repositries parcouru
 */
public final class StaticParams {
   public static final String ACCESS_TOKEN =" f9cab470806b58ad62e94781432b7635f6185ad4";
   public static final String URL="https://api.github.com/search/repositories?q=created:>2020-10-05&sort=stars&order=asc&page=1&per_page=100";
   public static final String ITEMS="items";
   public static final String HTML_URL="html_url";
   public static final String LANGUAGES_URL="languages_url";
}
