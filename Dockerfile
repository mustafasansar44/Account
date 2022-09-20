FROM openjdk:17-jdk-slim
WORKDIR /account
ADD target/com.MSansar.Account.jar account.jar
ENTRYPOINT ["java","-jar","account.jar"]
