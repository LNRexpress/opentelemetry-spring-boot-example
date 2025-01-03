FROM alpine:3.21.0
ARG APP_NAME=opentelemetry-spring-boot-example
ARG APP_VERSION=1.0.0
ARG SPRING_ACTIVE_PROFILES=default
RUN apk update
RUN apk add openjdk21-jre-headless
ENV SPRING_PROFILES_ACTIVE=$SPRING_ACTIVE_PROFILES
ENV OTEL_TRACES_EXPORTER=otlp
ENV OTEL_METRICS_EXPORTER=none
ENV OTEL_LOGS_EXPORTER=none
ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:4318
ENV OTEL_SERVICE_NAME=${APP_NAME}
COPY ${APP_NAME}-${APP_VERSION}.jar /srv/app.jar
COPY opentelemetry-javaagent.jar /srv/opentelemetry-javaagent.jar
ENTRYPOINT ["sh", "-c", "java -Xmx128M -javaagent:/srv/opentelemetry-javaagent.jar -jar /srv/app.jar"]
