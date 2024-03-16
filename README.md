Aplicação criada para o desafio de programação da empresa FROGPAY


## Descrição do Projeto
<p align="center">Aplicação criada para o desafio de programação da empresa FROGPAY</p>

## Funcionalidades
- [x] Cadastro de usuário
- [x] Cadastro de Pessoas e endereço
- [x] Cadastro de Dados Bancários


## Pré-requisitos
- [x] Java 17
- [x] Maven
- [x] Docker
- [x] Docker-compose
- [x] Postgres
- [x] Spring Boot


## Como rodar a aplicação
No terminal, clone o projeto:

a) Clone o projeto


b) Entre na pasta do projeto
 e execute o comando abaixo: <br>
docker-compose up

após a execução do comando acima, a aplicação estará disponível em: http://localhost:8082

por padrão, já tera um usuário cadastrado, para acessar a aplicação, utilize as credenciais abaixo para obter o token de acesso:<br>
endpoint: http://localhost:8082/auth/login
```json
{
  "username": "UserAdmin",
  "password": "123456"
}
```


