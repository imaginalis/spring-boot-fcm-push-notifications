# Spring Boot + FCM - simple push notifications server-side application
![alt text](https://blog.mestwin.net/wp-content/uploads/2019/06/fcm-spring-boot-result-1-216x300.png "Push notifications - result")


This is simple Spring Boot application with Firebase Cloud Messaging integration.

## Technologies

+ Spring Boot
+ Firebase Cloud Messaging

## Configuration

+ Provide your own Firebase Admin SDK, JSON-formatted file (service account credentials) and place it inside the project (for example _src/resources/google_)
+ Change the path and defaults in **application.properties**

## Endpoints


+ **GET /notification** – Trigger sample notification with default values sending


`curl -H "Content-Type: application/json" -X GET http://localhost:8080/notification`


+ **POST /notification/topic** – Send a message to a specific topic


`curl -d '{"title":"Hello", "message":"The message...", "topic":"contactTopic"}' -H "Content-Type: application/json" -X POST http://localhost:8080/notification/topic`

+ **POST /notification/token** – Send a message to a specific device (with token)

`curl -d '{"title":"Hey you!", "message":"Watch out!", "token":"cct00ebz8eg:APA91bFcTkFE_0Qafj6nWv5yHxqCLTyxAaqi4QzwsFNLP5M9G78X8Z5UMZTW004q1PUux63Ut-1WMGVToMNTdB3ZfO8lCZlc4lGpxm7LBdWfkhaUxdbpQ5xIO5cAb-w9H2dBLNHT7i-U", "topic": ""}' -H "Content-Type: application/json" -X POST http://localhost:8080/notification/token`

+ **POST /notification/data** – Send a message to a specific topic with additional payload data.

`curl -d '{"title":"Hello", "message":"Data message", "topic":"contactTopic"}' -H "Content-Type: application/json" -X POST http://localhost:8080/notification/data`

+ **Success response**

`{
    "status": 200,
    "message": "Notification has been sent."
}`

## More information

+ Blog post: [Send push notifications from Spring Boot server-side application using FCM](https://blog.mestwin.net/send-push-notifications-from-spring-boot-server-side-application-using-fcm/)

+ Client-side Ionic application: [ionic-fcm-push-notifications](https://github.com/imaginalis/ionic-fcm-push-notifications)
