FROM eclipse-temurin:21-jdk-alpine

WORKDIR /ddshop

COPY target/DDShop-0.0.1-SNAPSHOT.jar ddshop.jar

EXPOSE 8099

CMD ["java", "-jar", "ddshop.jar"]
