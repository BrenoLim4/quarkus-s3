# Etapa 1: Compilar para binário nativo usando GraalVM (Mandrel) versão 21
FROM quay.io/quarkus/ubi-quarkus-mandrel-builder-image:23.1-java21 AS build
WORKDIR /workspace
USER root
COPY ../../.. ./
RUN  ./mvnw clean package -Pnative -q -Dnative-image.docker-build=true -DskipTests

# Etapa 2: Criação da imagem final mínima com o binário nativo
FROM quay.io/quarkus/quarkus-micro-image:2.0
WORKDIR /work/
COPY --from=build /workspace/target/*-runner ./application
#RUN chmod 775 /work/application
ENTRYPOINT ["./application"]
