<p align="center">
    <img width="460" src="https://github.com/sebastian-reyes/oyasumi-punpun-api/blob/master/src/main/resources/static/readme/main_photo.jpg">
</p>

# Oyasumi Punpun API

RESTful API based on the manga [Oyasumi Punpun](https://oyasumi-punpun-manga.com/). You will access to data about all
characters, images, chapters and volumes. The Oyasumi Punpun API is filled with canonical information as seen on the
manga.

## Endpoints

### Base URL:

```bash
(GET)  http://localhost:9898/api/v0/
```

### Response:
```json
{
  "Volumes": "http://localhost:9898/api/v0/volume",
  "Characters": "http://localhost:9898/api/v0/character/page/0",
  "Chapters": "http://localhost:9898/api/v0/chapter/page/0"
}
```

## Technologies

- Java 8
- MariaDB
- Spring Boot 2.7.3
