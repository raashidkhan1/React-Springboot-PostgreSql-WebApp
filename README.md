# React-Springboot-PostgreSql-WebApp

The Web App Solution is structured as follows -

1 - Client
Client folder contains UI code developed with react and boostrap components upon a boilerplate generated from create-react-app. The UI invokes server endpoints using Axios library. The client can be built as per the instructions provided in the client READMe.

2 - Server
Server folder contains the backend code developed with Springboot in a Maven project. The server connects to the postgresql database which is run separately on a docker container as provided and needs to be started before running the backend server.

The server can be started as a java application with the help of an IDE project like eclipse. For this purpose a Maven project needs to be created and the src and pom.xml can be updated from the provided code on github.