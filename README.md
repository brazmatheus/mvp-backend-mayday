# mvp-backend-mayday
## Config
- IDE: Eclipse
- JAVA 11 Spring Boot 
- Postgres
## Passos pré execução
- A lista de cidades foi retirada da api do IBGE e deve ser incluída no banco. Para constar a listagem, basta fazer um POST do texto do arquivo **cidades.txt** na rota **/cidade/cadastrar**
- Também é necessário fazer 5 inserts nos tipos de ponto de interesse. No momento, não há rotas para fazer esse cadastro via endpoint.
> insert into tipopontosinteresse values (1, 'Rotas de Fuga'); 
> <br>
> insert into tipopontosinteresse values (2, 'Pessoas'); 
> <br>
> insert into tipopontosinteresse values (3, 'Hidrografia'); 
> <br>
> insert into tipopontosinteresse values (4, 'Abrigos'); 
> <br>
> insert into tipopontosinteresse values (5, 'Hospitais');
- Para que o envio de SMS funcione, deve ser colocado a chave da api dentro do arquivo /config/dados.properties no properties.sms.key

## Criação das tabelas do banco

Para a criação do schema e das tabelas do banco, utilizei uma ferramenta do springboot para criar as tabelas automaticamente

- Caminho
> /src/main/resources/application.properties
- O código abaixo, como está comentado, não irá criar o schema e as tabelas. Caso exista o interesse nessa funcionalidade, deve ser descomentado.
> #spring.jpa.hibernate.ddl-auto=create  

Irei colocar no repositório o script do banco, da forma que foi gerado automaticamente em meu DB local, no arquivo **db.txt**. Caso forem utilizar esse script, ajustar conforme o necessário.
