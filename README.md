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


