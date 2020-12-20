# Shopping
Placing order and Payment microservice with Service registry

#Flow of Project
Use of microservices
1)drcsc --> for Servicce registry
2)Order-->place order of particular amount
3)payment-->To display amount with tranaction id and order id Placed by customer.

Making a Rest call using the Rest template
When order is placed,a call automatically trigger for payment in payment microservice

Things to be added(Working on it)
1)Swagger 
2)Actuator
3)Spring Security
4)Config server
5)router service also(Using zuul)
