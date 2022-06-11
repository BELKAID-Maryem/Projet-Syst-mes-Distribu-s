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

![image](https://user-images.githubusercontent.com/102295113/173184648-a20f4822-a815-4796-ba8a-f21419a8549e.png)


- les micro service technique qui sont fait par spring cloud :
     - le service de regisrement 
     - le service  proxy(gateway)
     - le service  configuration
 - Tout les req http client passe par gateway et une fois ce service connu le nom de micro service il contact le service d'enregistrement pour récupérer add ip et le port où se trouve le micro service concerné par la req et s il ya plusieur instante de même micro il utilise le principe de équilibrage de charge pour choisir l'instance le moins chargé et après acheminé la req vers le bon micro service qui faire le traitement et retourne  le résultat .
 
 ![image](https://user-images.githubusercontent.com/102295113/173184385-bc4facaf-6e76-467f-b593-d6b52b914f76.png)

 
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
 ![image](https://user-images.githubusercontent.com/102295113/173161424-4cf885dd-de05-4f70-9341-8c320d52dd88.png)

- On commence par créer une classe customer qui va mettre dans le package entities   se classe définie par un id , nom , et email. Et pour que ca soit une entité JPA en     ajoute la notation @Entity 
- Puis creer interface JPA repository basée sur spring data qui appeler               CustomerRepository
- Finalement en insère quelque données dans la base de données au démarrage pour   tester .
- Et pour tester ce micro service on a besoin de spécifier le port(8081),le nom de micro service(customer-service),le nom de base de données (customer-db) et pour le moment on va désactiver le  discovery c.a.d ce micro service ne peut pas enregistrer dans le service d’enregistrement au démarrage .

![image](https://user-images.githubusercontent.com/102295113/173163924-2b4b64b9-5901-4a1a-96ff-5fc6aab91f6f.png)

![image](https://user-images.githubusercontent.com/102295113/173163944-2fa56973-9902-47ff-900a-0f0bf1f9817f.png)

- Pour tester Actuator qui  est un service qui permet de donnees beaucoupe  de données par ex état de service : 
![image](https://user-images.githubusercontent.com/102295113/173164322-44939fe1-25f1-4285-b76b-ccfb37553551.png)
![image](https://user-images.githubusercontent.com/102295113/173164342-29ca982e-943f-4dab-8a5f-2a38fcf8626e.png)

- Pour consulter la base de données: 

![image](https://user-images.githubusercontent.com/102295113/173164647-c2ced424-794e-4d47-bfe7-cd92a2a97495.png)

![image](https://user-images.githubusercontent.com/102295113/173164705-2ef8fe20-50df-44c9-b459-b1d607778c46.png)

## 2-Inventory Service:
- De même manière on a créé un classe Product  qui permet de gérer les produits et   définie par une id , nom , prix et la quantité .

![image](https://user-images.githubusercontent.com/102295113/173165669-12eb956e-e83a-4eae-8997-122d9f8a4e39.png)

![image](https://user-images.githubusercontent.com/102295113/173165684-1edb6cd4-8fb9-4bd7-9297-beab4b71b43f.png)

- Pour consulter la base de données: 

![image](https://user-images.githubusercontent.com/102295113/173165747-2371b7f7-953c-4753-bd8d-e2dbbea9fd8f.png)


![image](https://user-images.githubusercontent.com/102295113/173165765-65ff5a57-ae01-45f0-bd95-c9d1076197b4.png)


## 3-Spring cloud Gateway
-   il y a deux façon pour configurer le  spring cloud gateway :
  ## Configuration statique

-  Dans ce partie on a juste besoin de configurer en utilisant deux fichier de configuration :
        -    application.properties  :dans ce fichier de configuration en spécifiant le port et le nom de gateway .
        -    aplication.yml ce fichier contient tout ce qui concerne la configuration du route ( permet de contacter les micro service customer et inventory avec le serveur gateway).
       
- Et voila le teste :
    - customer service :

![image](https://user-images.githubusercontent.com/102295113/173169795-4b5ac03e-28b5-4ffc-afe0-37d4bc5c2f8e.png)


    - inventory service : 
    
    ![image](https://user-images.githubusercontent.com/102295113/173169782-fe4e1703-3676-464c-a6bd-b0a38b90978c.png)
   
- En peut aussi faire une configuration java en utilisant un Bean de type RouteLocator  qui utiliser un objet de type RouteLocatoBuilder  en paramètre qui utiliser pour configurer les routes .

- ce travaile est utiliser seulement si on utilisez des service dans  add est fix

## Configuration dynamique

- Dans ce configuration on a creer un methode Bean qui s'appel DiscovryClientRouteDefinitionLocator qui reçoit  deux parametre de type ReactiveDiscoveryClient et DiscoveryLocatorProperties 
-A chaque fois le gateway reçoit une requête regarde dans l' url de la requête et trouve le nom de micro service et envoie la requête vers le bon micro service . .

-Pour tester:

![image](https://user-images.githubusercontent.com/102295113/173181661-c2c5636b-aa66-4014-a6e3-41be0f9cb331.png)

![image](https://user-images.githubusercontent.com/102295113/173181684-bb372d74-e254-40c1-a359-ea25b382b746.png)

## 5-Eureka service:
- un projet eureka discovery et ajouter le dépendance eureka server et pour activer on ajoute la notation @EnableEurekaServer  et dans le fichier de configuration on ajoute le port et deux propriété (false pour que ce service ne pas enregistrer dans eureka service lorsque démarrer  .
- Eureka service  fournit par Netflix qui sont rôle est chaque micro service qui démarre il va enregistrer  dans le service d'enregistrement dans un table qui contient le nom de micro add IP et la port
-Et pour consulter ce server :


![image](https://user-images.githubusercontent.com/102295113/173172781-0d9f331b-28af-4452-9a87-8bb72f468083.png)


-Pour voir le micro service qui demarrer en euraka server en mette spring.cloud.discovery.enabled true au lieu de false de le fichier de configuration de customer et invotory et gateway server 


![image](https://user-images.githubusercontent.com/102295113/173172218-077ea351-cfef-4b18-96e4-477b1e9f321c.png)


## 6- Billing-service:

- ce service permet de gerer les factures , ces service va se comminique avec le service et le inventery service pour avoir les information des produits et des clients.
- notre micro service gérer deux table:
     - Table facture .
     - Table productItem c’est la liste de produit de la facture.
- Puis on a créer Deux classe : Customer et Product qui contient que les attribut d un client et d’un produit mais c' est pas une entité jpa c.a.d n' est pas géré dans la base de données( et pour ca en utilise la notation@Transient)
- Finalement on a créé deux interface BillRepository et ProductItem utilisées pour accéder à  donner dans ce propre bdd en utilisant la notation @FeignClient . alors  open Feign il va communiquer automatiquement  avec le service d'enregistrement et  il va récupérer add ip et le porte des micro service et après envoyer une requête ver le bon  service.

![image](https://user-images.githubusercontent.com/102295113/173188837-ff746f2c-b9b4-4cf0-b78d-c741a66dd360.png)


![image](https://user-images.githubusercontent.com/102295113/173184721-98336b08-d980-4581-bbb1-23ae48fa44f9.png)


# partie de kafka:
 
- Enfin on a créé un service avec kafka qui offre des brokers (un cluster des brokers) qui sont utilisés pour échanger des msg entre des applications distribuées.et qui permet de stocker les flux d'enregistrement de manière durable et tolérante aux pannes (si le sys de 
   Le stockage de kafka n' est pas suffisant il peut utiliser des connecteurs qui lui permet d'utiliser un autre système de stockage comme mongoDB ).
- Pour demarer kafka il faut tout d'abord demarer Zookeeper qui permet de 
      - Faire la coordination entre les différente brokes du cluster 
      - Créer un mémoire partager.
      - faire la coordination entre les brokers.
      - informer les consomateur(les autre instance) à un moment donné qui a un nouveau brokers qu'il va ajouter .
      - retourner des info sur les consommateur (quel enregistrement qu'il va consumer ..).

![image](https://user-images.githubusercontent.com/102295113/173173784-90677627-96db-44e9-a7ed-6db27166a9f1.png)


-une fois que zookeeper demarer en peut par suite demarer le server kafka en utilisant kafka-server-start :

![image](https://user-images.githubusercontent.com/102295113/173173795-61f5751b-a43e-40de-8a81-042b9e4cc6db.png)

-Et pour faire des teste on a besion de demarer :

 ![image](https://user-images.githubusercontent.com/102295113/173174023-38443b3b-1c81-4c30-a2bd-0ede55bf3a74.png)


- Puis on a creer un producer en utilisant la fonction Supplierbqui permet de publier dans un topic FACTURATION pour lire la factures par un consumer sur un cmd :

![image](https://user-images.githubusercontent.com/102295113/173174060-542499cb-bbf8-422e-aac5-3ab1766a731d.png)

- Puis on a crée un Micro-service Spring Boot qui permet de consommer les messages du Topic « FACTURATION » et de les enregistrer dans sa propre base de données:

![image](https://user-images.githubusercontent.com/102295113/173183795-eef21b2b-e4c6-4fdb-9a62-6a87c2420240.png)




              








   

    

    





 
 


  





