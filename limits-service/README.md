mvn spring-boot:run -Dspring-boot

mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8888"
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"

# SPRING BOOT 1.x+
http://localhost:8080/refresh
http://localhost:8080/bus/refresh

# SPRING BOOT 2.0.0+
http://localhost:8080/actuator/refresh
http://localhost:8080/actuator/bus-refresh