# Event Manager Project Using Java and Spring Boot

## 1. Techonologies 

- Java +11 - https://www.java.com/pt-BR/
- Visual Studio Code - https://code.visualstudio.com/
- MVN - https://mvnrepository.com/
- Spring Boot - https://spring.io/tools
- Spring Boot Inicializr - https://start.spring.io/
- MaterializeCSS - https://materializecss.com/

## 2. Quick Start

### To initialize the database, use the following command:
```docker
docker run --name java-mysql-event -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mysecretpassword -e MYSQL_DATABASE=eventosapp mysql:8.0.29-debian
```
### To start the application, use the following command:
```
mvn spring-boot:run
```
### MySQL debug step-by-step:
```sh
> docker ps
> docker container exec -it ${container id} sh

> mysql -u root -p
# Enter password: _

mysql> SHOW databases;
mysql> USE eventosapp;
mysql> SHOW tables;
mysql> DESCRIBE event;
mysql> select * from event;
mysql> create table guest (guestrg varchar(11) not null, guest_name varchar(255), guest_event_event_id bigint, primary key (guestrg)) ENGINE=MyISAM; #fix
mysql> select * from guest;
mysql> exit

> exit
```

> heroku deploy
```
> heroku --version
> heroku login
> heroku create project-name (create a new url)

> git push heroku master
> heroku logs --tail
> heroku apps
> heroku addons:create heroku-postgresql:hobby-dev -a project-name
```

## 3. Author

- [Lucas Lessa](https://github.com/LucasLessa14) - FullStack Web Developer

## 4. References

- [GitHub](https://github.com/MichelliBrito/cursospringboot/blob/master/pom.xml)
- [Projeto](https://www.youtube.com/watch?v=bWno9QpnGmk)
- [Playlist](https://www.youtube.com/playlist?list=PL8iIphQOyG-DHLpEx1TPItqJamy08fs1D)
- [Install Heroku](https://devcenter.heroku.com/articles/heroku-cli)