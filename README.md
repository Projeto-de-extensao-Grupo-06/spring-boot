# Repositório Backend Spring Boot

API Backend do projeto de gerenciamento de agendas, clientes e materiais do site da empresa Solarize

## Instalação: NA

## Variáveis de Ambiente: NA
    
## Documentação da API

Link para o Swagger/Postman

#### Retorna todos os itens

```http
  GET /api/items
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `api_key` | `string` | **Obrigatório**. A chave da sua API |

#### Retorna um item

```http
  GET /api/items/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |

#### add(num1, num2)

Recebe dois números e retorna a sua soma.


## Deploy

Para fazer o deploy desse projeto rode

```bash
  npm run deploy
```
