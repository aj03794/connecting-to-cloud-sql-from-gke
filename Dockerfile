FROM openjdk:11-jre-slim
EXPOSE 8080
COPY build/libs/connecting-to-cloudsql-from-gke-0.0.1-SNAPSHOT.jar connecting-to-cloudsql-from-gke.jar
ENTRYPOINT ["java","-D","-jar","/connecting-to-cloudsql-from-gke.jar"]
