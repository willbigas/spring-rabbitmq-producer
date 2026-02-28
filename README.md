# spring-rabbitmq-producer

Este projeto é um produtor de mensagens RabbitMQ usando Spring Boot 3.

## Pré-requisitos
- Java 21
- Docker e Docker Compose
- RabbitMQ (será iniciado via Docker Compose)

## Como rodar o projeto

1. **Suba o RabbitMQ com Docker Compose:**

```sh
docker compose up -d
```

2. **Execute a aplicação Spring Boot:**

```sh
./gradlew bootRun
```

A aplicação estará disponível em `http://localhost:8080`.

## Como enviar mensagens para o RabbitMQ

Utilize o comando abaixo para enviar uma mensagem via HTTP para a API:

```
curl --location --request POST 'http://localhost:8080/api/notifications/send?to=john%40example.com&subject=Welcome&body=Hello%20John!'
```

- O parâmetro `to` é o e-mail de destino.
- O parâmetro `subject` é o assunto.
- O parâmetro `body` é o corpo da mensagem.

A mensagem será serializada em JSON e enviada para o RabbitMQ.

## Observações
- O RabbitMQ estará disponível em `localhost:5672` (padrão).
- O painel de administração do RabbitMQ estará em `http://localhost:15672` (usuário/senha padrão: guest/guest).
- **É necessário rodar o projeto `spring-rabbitmq-consumer` para consumir as mensagens enviadas para o RabbitMQ.**

## Arquitetura do Sistema

> O fluxo é: Usuário → API Producer → RabbitMQ → Consumer → File/DB
