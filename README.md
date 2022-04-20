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
