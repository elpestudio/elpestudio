FROM openjdk:8-jdk-alpine
MAINTAINER resistemasperu.com
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring