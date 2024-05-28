# tech-challenge-gerenciador-pedidos
Projeto criado para abrigar o projeto de Tech Challenge do curso de Arquitetura de Software da Fiap.

Esse projeto consiste num sistema de gerenciamento de pedidos de uma lanchoete fast food com auto atendimento.

## Requisitos

Principais Dependências
* SpringBoot
* Gradle
* Postgres database
* Swagger

**Note**
Lombok e dependências de framework não estão sendo usados na camada de domínio da aplicação! 

**Warning**
O projeto ainda está em desenvolvimento, existem comentários de to-dos principalmente nas classes de entidade e valueobjects da camada de domínio.
Portanto, mesmo que algumas classes ainda possam parecer anêmicas, a estrutura já foi criada para que regras de negócio que serão implementadas mudem o cenário. 


## Rodando o projeto com docker-compose
#Você vai precisar:

* Docker e docker-compose instalados na sua máquina

Clone o projeto e execute o comando

	$ docker-compose up
ou

    $ docker compose up

Atualmente existem 8 APIs publicas e a documentação delas pode ser encontrada na url abaixo quando os containeres estiverem rodando.

Swagger: http://localhost:8080/swagger-ui/index.html#/

## Ordem sugerida de execução das chamadas na API

- Criar produto
```
POST localhost:8080/api/v1/products
{
    "name":"Guarana Artemis",
    "description":"Guarana Artemis - Refrigerante",
    "category":"BEBIDA",
    "price":"5.0",
    "images" : ["https://gerenciador-pedidos-lanchonete.s3.amazonaws.com/artemis.png"]
}
Response
HTTP Status 201 Created
{
  id: "12c3009d-046d-411c-85eb-6e379e2f5d2a"
}
```
- Checkout pedido
```
POST localhost:8080/api/v1/orders
{
    "items": [
        {
            "quantity": 3,
            "productId": "12c3009d-046d-411c-85eb-6e379e2f5d2a"
        }
    ]
}
HTTP Status 201 Created
{
    "id": "c28ad3b9-c1cd-497f-8dd0-8724bc2f658c",
    "pickupCode": 1,
    "paymentId": "c1519ab3-7d83-4a97-8d75-3f69bd0754b8"
}
```
- Listar pedidos (segundo ordem do requisito do projeto e ignorando Finalizados)

```
GET  localhost:8080/api/v1/orders

Response
HTTP Status 200
{
    "orders": [
        {
            "id": "c28ad3b9-c1cd-497f-8dd0-8724bc2f658c",
            "price": 15.00,
            "pickUpCode": 1,
            "orderStatus": "CRIADO",
            "items": [
                {
                    "id": 1,
                    "productId": "d5dd6581-734f-4c1c-85a8-64e465af7aa1",
                    "subTotal": 15.00,
                    "quantity": 3
                }
            ]
        }
    ]
}

```
