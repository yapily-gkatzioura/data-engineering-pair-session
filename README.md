# Data Engineering Pair Session

This repository and its projects serve as a discussion material during the interview.
There is no need for the interviewee to do anything before the interview.
If the interviewee wants to interact with the project and even add some code, should feel free to do so, but this is not required during the interview.
During the interview there will be a small pair programming session not related with the existing codebase.

## The environment

The environment consists of:
* A Single node Kafka installation
* An elastic search instance
* A Redis instance

Docker Compose can handle all the provisioning 

```shell
docker compose up
```

By running `docker compose up` you have the services needed setup.

```shell
docker run --rm --name zookeeper -p 2181:2181 --env ALLOW_ANONYMOUS_LOGIN=yes bitnami/zookeeper:latest
docker run --rm --name kafka -p 9092:9092 --env KAFKA_BROKER_ID=1 --env KAFKA_LISTENERS=PLAINTEXT://:9092 --env KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://127.0.0.1:9092 --env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 --env ALLOW_PLAINTEXT_LISTENER=yes --link zookeeper:zookeeper bitnami/kafka:latest
docker run --rm --name elasticsearch -p 9200:9200 --env xpack.security.enabled=false --env discovery.type=single-node elasticsearch:7.17.1
docker run --rm --name redis -p 6379:6379 redis
```

## Projects


## Console Data Producer

Simple Kafka producer

[facts-producer-console](facts-producer-console)

## Console Data Consumer

Simple Kafka Consumer

[facts-consumer-console](facts-consumer-console)


## Spring based Producer

A Kafka producer spring based.

[facts-servlet](./facts-servlet)

The rest endpoint accepts a payload

```shell
curl --location --request POST 'localhost:8080/fact' \
--header 'Content-Type: application/json' \
--data-raw '{
"author":"author",
"content":"fact content"
}'
```


## Spring based Consumer

A Spring project that can be used for the Kafka consumer, posting to elastic search

[facts-consumer](./facts-consumer)
