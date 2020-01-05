Spring boot and Kafka integration example

1. Download Kafka from https://kafka.apache.org/quickstart
2. For windows users: 
		Extract it to C:\ drive(Basically the path should not be long)
		Create folder in C drive with name as "kafka-logs"
		In file config/server.properties, find log.dirs and replace it with `log.dirs=C:\\kafka-logs`
		Create another folder in C drive with name as "zookeeper"
		In file config/zookeeper.properties , find dataDir and replace it with `dataDir=C:\\zookeeper`
		
3. Open powershell in admin mode 
	cd C:\kafka_2.12-2.4.0
	run the command :  .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
	
4. Open powershell in admin mode
	cd C:\kafka_2.12-2.4.0
	run the command: .\bin\windows\kafka-server-start.bat .\config\server.properties
	
	
5. Clone spring boot application and build it using Intellij
6. Open cmd in admin mode
	cd C:\kafka_2.12-2.4.0
	run command to create topic : bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic simple
	
7. Run producer:
	open cmd and cd into the spring boot project
	run command: java -jar -Dserver.port=9991 -Dspring.profiles.active=kafka-publisher build\libs\springbootkafka-0.0.1-SNAPSHOT.jar
	
8. Run Consumer:
	open cmd and cd into the spring boot project
	run command: java -jar -Dserver.port=9992 -Dspring.profiles.active=kafka-consumer build\libs\springbootkafka-0.0.1-SNAPSHOT.jar
	
9. Open postman
	call the API: http://localhost:9991/kafka/publish with POST body: "Hello Kafka"