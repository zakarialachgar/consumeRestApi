# consumeRestApi
##consuming rest api by a microservice with springboot

NB: github api limite les requettes a 60 requettes, pour notre cas on vas envoyer plus de 60 requettes, 
pour eviter cette limitation on doit envoyer la requette en tant qu'utilisateur github.
on envoie github access token comme parametres de l'url de la resource.

par exemple:
https://api.github.com/search/repositories?q=created:>2020-10-10&sort=stars&order=desc&page=1&per_page=100?access_token=myacceestoken

###########

le retoure de notre microservice sera une liste qui contient des objets qui encapsule
le nom du langage, le nombre de repos qui l'utilise et une liste des url des repos  qui utilisent cette langage.
  
