#!/bin/sh

echo "<<<========= RUN MAVEN ==========>>>"
mvn clean install -f app/pom.xml
mvn clean install -f tracking/pom.xml

echo "<<<========= KILL CONTAINERS ==========>>>"
docker-compose down
# docker-compose stop projekt
# docker-compose rm projekt
echo "<<<========= BUILD & RUN CONTAINERS ==========>>>"
sudo docker-compose up -d --build
# sudo docker-compose start -d projekt
echo "<<<========= READY ==========>>>"
