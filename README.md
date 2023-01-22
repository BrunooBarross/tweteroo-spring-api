<p align="center">
  <h1 align="center">
    Tweetero api
  </h1>
</p>

- Tweetero api é um desafio da aceleração Java - Driven, que tem como objetivo colocar em prática os contéudos estudados ao decorrer de duas semanas.


## 💻 Tecnologias Utilizadas

- Java 17.0
- SpringFramework 6.0
- H2
- Hibernate
- JPA
- Maven

---

- ➡️ OBS: UTILIZAR O FRONT LOCALIZADO NA PASTA FRONT - tweteroo, arquivo index.html - contém uma alteração  ⬅️ 


## 👨🏻‍💻 Instalação

```bash

$ git clone https://github.com/BrunooBarross/tweteroo-spring-api

$ Na sua IDE importe um novo projeto maven existente e selecione a pasta tweteroo-spring-api

$ De um run as Spring Boot App na classe TweteroApplication

$ Teste via um testador de API Rest, ou abra o front na pasta FRONT - tweteroo, arquivo index.html.
```

## Telas do Tweetero

![image](https://user-images.githubusercontent.com/91610976/213925480-007f5228-2dcc-4810-af97-27fcc4bd2a0f.png)

## 🚀 API:

- http://localhost:8080/api

```yml
POST /auth/signup
    - Rota para cadastro de usuários
    - headers: {}
    - body: {
        "userName": Não vazio, max 15 caracteres 
        "avatar": contém pattern - link de imagens http ou https com final terminado em jpg|gif|png 
    }
```

```yml
POST /tweets
    - Rota para inserir um tweet
    - headers: {"User": String nome do usuário}
    - body: {
        "text": Não vazio, max 280 caracteres
    }
```

```yml
GET /tweets
    - Rota que retorna todos os tweets do sistema com paginação ?page={number}&size={number}
    - headers: {}
    - body: {}
```

```yml
GET /tweets/{username}
    - Rota que retorna todos os tweets de um determinado usuário
    - headers: {}
    - body: {}
```
