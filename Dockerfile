FROM openjdk:11-jdk-slim
COPY build.gradle /simpleTest/build.gradle
WORKDIR /simpleTest
RUN ./gradlew build --no-daemon || true
COPY src /simpleTest/src
RUN mkdir /app/build/allure-results
RUN wget -qO- https://dl.bintray.com/qameta/generic/io/qameta/allure/allure/2.13.6/allure-2.13.6.tgz | tar -xz -C /opt/
ENV PATH="/opt/allure-2.13.6/bin:${PATH}"
CMD ["./gradlew", "clean", "test", "allureReport"]