# Projet Systèmes Distribués
  ## C'est qoui un Systèmes Distribués:
  
 - Un système distribué est une structure de réseau composée d'ordinateurs autonomes connectés à l'aide d'un middleware de distribution. Les systèmes distribués facilitent le partage de différentes ressources et capacités, pour fournir aux utilisateurs un réseau cohérent unique et intégré.
 
 - Dans une application orienter objet classique tout les objet de l'applicqtion se trouve dans la meme machine mais dans les application oriente objet distribue un    objet que se trouve dans une machine peut faire appel a une methode d'un autre objet qui se trouve dans une autre machine . Et pour creer des application distribue 
 multilangage et multiplatforme en utilise CORBA(avec le middleware CORBA en peut creer un objet java qui fait appel a une methode d aun objet c++).
 
  - Il y a deux manier pour devloper les application distribues:
  
  ## 1-Approch monolithes:
  
   - Par le passé, l’industrie informatique utilisait des solutions monolithiques qui basées sur l’architecture orientée services (ou SOA pour Service-Oriented              Architecture) comme standard ,qui permet de developpee une application en un seul bloc c.a.d centraliser tout les fonctionaliter d'un grand problem dans un seul        application utiliser une meme technologie et deployee dans un serveur d'application. 
  
   - Une application monolithe est composée d’une seule unité applicative qui comprend généralement:
       - Une partie client (pages HTML et code javascript qui s’exécute dans le browser).
       - Une partie serveur (cœur de l’application, le monolithe).
       - Une base de données
       
       ![image](https://user-images.githubusercontent.com/102295113/173138547-5acdb746-e403-421a-b4f8-f7e487b39beb.png)
       
       
  ## 2-Approch  microservices :
    
   - Aujourd’hui, la majorité des géants du numérique (Google, Amazon, Facebook,        Netflix, Uber, Paypal,…) ont adopté une architecture de type microservices      pour leurs   applications. Ce type d’architecture permet de répondre à ces problématiques avec une approche basée sur le principe « Divide and Rule ». L’architecture microservices consiste à découper une application en petits composants qui vont interagir entre eux via des protocoles légers (souvent via REST API ou par  messages asynchrones).

 ![image](https://user-images.githubusercontent.com/102295113/173137506-db87aa30-3658-4eb3-9bea-5ccba5743f43.png)
 
 ![image](https://user-images.githubusercontent.com/102295113/173146208-299cf651-b263-4b1c-8b8e-cae71218d3e3.png)

 
- Parmi les nombreux avantages d’une architecture microservices, on peut citer :

   - Les microservices sont indépendants les uns des autres : chaque composant possède son propre cycle de vie.
   - Développement en parallèle de microservices.
   - Découpage fonctionnel de l’application.
   - Monitoring plus fin de l’application : ce qui permet d’identifier les microservices les plus sollicités.
   - La maintenance est beaucoup plus facile : on fait évoluer uniquement les composants nécessaires.
   - Les microservices peuvent utiliser des langages différents.
   - Propice à l’innovation technologique dans le sens où on peut faire évoluer seulement un microservice dans un premier temps pour tester un langage ou un framework      par exemple.
   - La notion d’évolution progressive : différentes versions d’un microservice peuvent cohabiter.
   - Application scalable : on déploie davantage d’instances pour les microservices plus utilisés.
   - S'apprete bien a au processus du GL:TDD (test driver developpement) test first c.a.d developper d'abord les tests uniter avant de developper la fonctionaliter.
   
   
- Une architecture aussi complexe entraîne de nouvelles problématiques telles que :
    - Latence due aux communication réseaux.
    - Complexité de l’application déportée dans l’interaction entre les différents microservices.
    - Nécessité de maintenir une cartographie des composants.
    - Difficulté à packager l’application avec les microservices (chacun possédant sa propre version).
    - Difficulté à définir la granularité d’un microservice.
    
Danc ce projet on utilise que l'approche microservices pour creer notre application .
 
  ## Partie1: Micro service
  
- Dans une architecture basée sur le micro service on a besoin de créer les micro service métier (Customer-Service,Inventory-Service,Billing-Service , Eureka Discovery Service,Spring Cloud Gateway ) en utilisant différentes technologies. Et pour fonctionner tous les micro services dans une seule application on a besoin d'utiliser un framework,et parmi c'est framework on a un spring cloud qui permet de faire l'orchestration de services.
- les micro service technique qui sont fait par spring cloud :
     - le service de regisrement 
     - le service  proxy(gatewey)
     - le service  configuration
 - Tout les req http client passe par gateway et une fois ce service connu le nom de micro service il contact le service d'enregistrement pour récupérer add ip et le port où se trouve le micro service concerné par la req et s il ya plusieur instante de même micro il utilise le principe de équilibrage de charge pour choisir l'instance le moins chargé et après acheminé la req vers le bon micro service qui faire le traitement et retourne  le résultat .
 - Et pour mettre une place un service gateway dans un architecture micro service      Spring cloud il offre de solution :
       - Zuul : est un proxy fourni par Netflix qui basée sur le model  Multi                Threads avec des entre sortie Bloquantes.
       - Spring Cloud Gateway :  est un proxy basée sur le model Single Threads              avec des entre sortie  non bloquantes.
- Pour configurer spring cloud gateway en utilise des Route et pour chaque route     on a :
        -  URI de destination.
        -  Predicate: un ensemble  de condition qui doit être satisfaite dans la              requête pour dire que   cette req peut envoyer vers ce micro                        service(host,path,method[post,get..]...) 
        -  Filters : un ou plusieurs filters qui peuvent intervenir pour apporter 
           des traitement et des modifications des requetes et des reponses HTTP.
           
## 1-Customer Service:
- Il y a deux  méthode pour créer  ce  micro service   :
     -  spring initializer:
     
     ![image](https://user-images.githubusercontent.com/102295113/173160486-13a36605-391c-4607-8a60-df4c1e5518f1.png)

     -  start.spring.IO et apres ouvrir dans votre IDE :
     
     ![image](https://user-images.githubusercontent.com/102295113/173160749-96c4f80f-e383-4f13-8b41-67b95c87c16e.png)

 - Puis on ajoute les dependances suivants :
 
 ![image](https://user-images.githubusercontent.com/102295113/173161257-e3ed9c76-2122-433f-af09-ffd36e6d03d2.png)

 
 
  





