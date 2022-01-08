# regions-catalog

Для работы нужно:
- cкачать проект
- перейти в папку с проектом в командной строке
- выполнить команду docker-compose up -d
- открыть проект в IDEA и запустить 

Список возможных запросов:
1) GET localhost:8080/regions - список всех регионов
2) GET localhost:8080/regions/{id} - получение региона по id
3) GET localhost:8080/regions/title/{title} - получение региона по названию
4) PUT localhost:8080/regions?id={id}&title={title}&abbreviation={abbreviation} - изменение существующей записи
5) POST localhost:8080/regions?title={title}&abbreviation={abbreviation} - внесение новой записи
6) DELETE localhost:8080/regions/{id} - удаление записи по id
