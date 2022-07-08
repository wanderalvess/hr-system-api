DOCKER
=====
- Portainer
  - docker volume create portainer_data
  - docker run -d -p 8200:8200 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:latest
  - https://localhost:9443 
- Gerar imagem docker do projeto
    - docker build -t wanderalvess/eureka-server:1.0.0 .
- Listar imagens:
    - docker images    
- Rodar container:
    - docker container run --name eureka-server -p 8761:8761 wanderalvess/eureka-server:1.0.0

Esse projeto
===
- Eureka Server utilizado para registrar as outras aplicações
  - http://localhost:8761 
- Exemplo Requisição:
  - Pelo Postman:
    - {"description": "Pagamento", "workedHours": 200.0 }