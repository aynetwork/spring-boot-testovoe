# 

Пример запуска:

Сначала надо запустить docker container postgres:

docker-compose up

далее java -jar target/demo-0.0.1-SNAPSHOT.jar

База заполняется автоматически:
src/main/resources/data.sql

WSDL:
http://localhost:8080/ws/countries.wsdl

Добавление новых покупок по SOAP:
request.xml

Swagger api:
http://localhost:8080/v2/api-docs

Что не получилось:
Пункт 4:
Вывести имя и фамилию человека, совершившего больше всего покупок за полгода

Что чаще всего покупают люди в возрасте 18 лет

сами запросы в postgresql составлены, но не получилось прикрутить в spring-boot

Пункт 5
Вывести ui по адресу
http://localhost:8080/swagger-ui.html

