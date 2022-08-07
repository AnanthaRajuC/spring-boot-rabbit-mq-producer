**RabbitMQ**

~~~shell
docker pull rabbitmq
~~~

~~~shell
docker run -p 15672:15672 -p 5672:5672 --hostname my-rabbit --name rabbit-mq rabbitmq:3.7.1-management
~~~

*RabbitMQ Portal*: [http://localhost:15672/](http://localhost:15672/ "RabbitMQ URL").

- Username: **guest**
- Password: **guest**


**APP URI**: [http://localhost:8080/api/v1/person](http://localhost:8080/api/v1/person)

[http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

**Sample JSON body**

~~~json
{
	"name": "Jane",
	"username": "janejane",
	"address": {
		"street": "Jane Plains",
		"suite": "Suite 779",
		"city": "Wisokyburghh",
		"zipcode": "90565-7771",
		"geo": {
			"lat": "-43.9589",
			"lng": "-34.4628"
		}
	}
}
~~~

References:

[https://hub.docker.com/_/rabbitmq](https://hub.docker.com/_/rabbitmq)