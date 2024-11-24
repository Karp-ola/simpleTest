FROM openjdk:11-jdk-slim
COPY build.gradle /simpleTest/build.gradle
WORKDIR /simpleTest
RUN ./gradlew build --no-daemon || true
COPY src /simpleTest/src
RUN mkdir -p /simpleTest/build/allure-results
RUN apt-get update && apt-get install -y wget gnupg2
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
RUN apt-get update && apt-get install -y google-chrome-stable
RUN wget -qO- RUN wget -qO- https://github.com/allure-framework/allure2/releases/download/2.13.6/allure-2.13.6.tgz | tar -xz -C /usr/local/
ENV PATH="/usr/local/allure-2.13.6/bin:${PATH}"
CMD ["./gradlew", "clean", "test", "allureReport"]