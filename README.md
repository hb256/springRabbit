# Spring + RabbitMQ

A simple Spring Boot app.

## Setup RabbitMQ with Docker
```bash
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

## Test
```bash
curl http://localhost:8080/api/produce?message=somemsg
```
