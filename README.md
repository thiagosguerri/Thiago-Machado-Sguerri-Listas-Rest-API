# Thiago-Machado-Sguerri-Listas-Rest-API

Objetivo do teste: Avaliar o desenvolvimento de REST API com documentação Swagger.

Para a visualização deste projeto serão necessários as seguintes tecnologias em sua máquina.
- Spring Tools Suite 4
- MySQL(Banco de dados)
- Java 8 ou superior
- Postman(Para testes dos recursos de requisições)

Ao baixar o projeto, deverá importar na IDE Spring e aguardar todos os arquivos serem baixados.
Em seguida, verifique no arquivo properties qual a porta do banco de dados ativa em seu local e altere para configuração do banco.

Para visualização da documentação Swagger, basta acessar o diretório http://localhost:8080/swagger-ui/index.html em seu navegador, apenas atente-se se a porta do seu projeto é a 8080, caso não, altere na url e acesse.

Caso não tenha o Lombok em sua IDE, vá na barra de ferramentas da IDE e clique na opção "HELP", vá na opção "Install new software".
Assim que abrir a opção pesquise por https://projectlombok.org/p2 , selecione o valor encontrado e clique em "Next" para instalação do Lombok.

Após o instalação do Lombok e configuração do banco de dados, poderá iniciar o java aplication na classe main ThiagoMachadoSguerriListasRestApiApplication.


Obs: O projeto está com CRUD de Lista Ok e o CRUD dos itens apenas o de cadastro está com erro no relacionamento com a lista.

Dentro do repositório se encontra o projeto e o arquivo postamn para testes.
