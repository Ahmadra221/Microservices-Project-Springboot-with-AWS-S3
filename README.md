# Microservices-Project-Springboot-with-AWS-S3
Microservices Project Springboot with AWS S3
Distributed Microservices system with Spring Boot

This Upload/Download system consists of a server and a gateway and multiple microservices, all microservices will be dynamically registered with Spring Eureka server. 
![eureka](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/75ad8fb7-c234-451c-8b4f-264d311e18cb)

The point of this system is to be able to upload/download files to an Amazon S3 API’s Bucket.
The system consists of two availability zones so if one server is down the other can act as a redundant of that server and no service will go down. 

![unnamed](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/f2628a62-f3ef-4820-9107-d64016e54694)


We have the following microservices: 
Upload
Download
Get-all
Get 
Delete


Upload service help us upload a file to the S3 bucket. It is an asynchronous service that is connected to a RabbitMQ Messaging service. When its run it uploads the file and send a message through the queue to the Download service. So when the download service is run it’s notified that a new file has been uploaded. And thus can be downloaded. 

Example:
![Screenshot 2024-01-03 132402](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/5c270841-ec46-49d3-a4e9-74711e0dd734)
![Screenshot 2024-01-03 132706](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/9e33aad8-b25a-4216-8f82-8b074b5be58a)
![Screenshot 2024-01-03 133133](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/470d2265-9d17-419b-bb8d-47ca696635b3)

Getall service basically only gets the name of the files currently in the S3 api bucket and the files deleted recently:
![getall](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/aaffe8e0-6581-4e0d-a6dd-8ee7a4891be2)

Get service basically does the same thing, the reason why its created is to make synchronous calls among the three services: getall-get-delete 
Delete service: basically help us delete any file from the s3 api and it also saves the name of the deleted file in an H2 in memory database that its connected to 
![delete service](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/0a17cd11-1632-4d6a-8e5f-6e40da9fc160)
![getdeleted](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/5a0e4e5e-34b2-4f85-afee-27456511d6b6)

To run the project: 
1- run the eureka server
2- run all the services 
3- call each service by its port and request url or use the included gateway service to call all services by the same port: 

Services:

![table](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/b2a81a64-3614-47b2-8388-5b76b59d90b7)


Hystrix Dashboard of delete service:
![hys](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/19db88ea-6a96-4f5a-9480-fdb31a80d4f7)

Get all files REQUEST 

![sync](https://github.com/Ahmadra221/Microservices-Project-Springboot-with-AWS-S3/assets/36059156/1100a05a-1191-4efa-9bb4-ddc30583e8cc)




