## Microservices-architecture
Microservices Architecture Example

# Requirements
- Java 8
- Spring Boot 2
- Maven
- CURL
- JQ
- Docker
- Services
- Config Service
- http://localhost:8091/tweetsmanager-service/default

Discovery Service (Eureka)
http://localhost:8099/

Microservice Tweetsmanager
- GET
curl -X GET http://localhost:8091/tweets  -H 'Accept: application/json' | jq '.'

- POST
curl  --request POST 'localhost:8091/tweets' \
--header 'Content-Type: application/json' \
--data-raw '{
        "id": 1,
        "idStr": "1379886535047311363",
        "text": "¡Nos vemos en la noche!\n\nComenzamos con un live para platicar sobre todo lo acontecido en los cuartos de final de ida de la Champions.\nY después la narración en vivo del Olimpia vs. América en Concachampions\n¡Los esperamos!\n\nFB: https://t.co/VKn01J3FoS\nYB: https://t.co/0CHdhusPZ9 https://t.co/TXnAJrDDks",
        "validation": false,
        "language": "ES",
        "user": {
            "id": 1,
            "idStr": "2542285507",
            "name": "La Banca MX ⚽",
            "screenName": "LaBanca_MX_",
            "followersCount": 9091
        },
        "place": null,
        "hashtags": []
    }'

# Gateway Service
tweetsmanager

curl -X GET http://localhost:8080/tweets    -H 'Accept: application/json' | jq '.'

