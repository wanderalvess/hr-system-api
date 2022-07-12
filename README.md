
Sistema de pagamento de usuário via api
===
- ***Esse projeto foi feito com SpringBot, maven, e criado os container com docker.***
  - Pode ser baixado diretamente do repositorio no hub.docker.com.
    - docker run wanderalvess/payroll-api
    - docker run wanderalvess/eureka-server
    - docker run wanderalvess/api-gateway
    - docker run wanderalvess/user-api
    
  - ***Pode ser usado o comando abaixo, para iniciar todos ao mesmo tempo***
    - docker-compose up
 
- ***Exemplo de requisição Get:***
  
  - Pelo Postman:
    - localhost:8765/payroll-api/api/payments/1
    - {"description": "Pagamento", "workedHours": 200.0 }
    
- ***Exemplo de retorno:***
  - {"workerName": "Maria", "description": "Pagamento 1",  "hourlyPrice": 40.0, workedHours": 200.0, "totalPayment": 8000.0}

Imagens DOCKER de projeto
=====
- ***Portainer(Aplicação WEB para containers)***
  - docker volume create portainer_data
  - docker run -d -p 8200:8200 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:latest
  - https://localhost:9443 
  
- ***Gerar imagem docker do projeto***
    - docker build -t wanderalvess/eureka-server:1.0.0 .
    
- ***Listar imagens:***
    - docker images    
    
- ***Rodar container:***
    - docker container run --name eureka-server -p 8761:8761 wanderalvess/eureka-server:1.0.0


