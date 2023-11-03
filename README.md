Sistema de Vagas de Trabalho
Este é o primeiro projeto individual desenvolvido por um estudante de Java e Spring Boot. O projeto é um sistema de vagas de trabalho, no qual é possível cadastrar, atualizar e excluir vagas e candidatos. Além disso, o sistema permite a filtragem de vagas com base nas características dos candidatos, como o salário.

Tecnologias Utilizadas
Java
Spring Boot
Banco de dados H2 (em memória)
Funcionalidades
O sistema oferece as seguintes funcionalidades:

Cadastro de vagas de trabalho: Os usuários podem criar novas vagas de trabalho, fornecendo informações como título, descrição, salário e requisitos.

Atualização de vagas de trabalho: É possível atualizar informações de vagas já existentes, como o salário e os requisitos.

Exclusão de vagas de trabalho: Os usuários podem remover vagas de trabalho que não são mais necessárias.

Cadastro de candidatos: Os candidatos podem se cadastrar no sistema, informando seu nome, experiência, habilidades e pretensão salarial.

Filtragem de vagas: Os candidatos podem filtrar vagas com base em critérios como salário desejado, habilidades e experiência.

Como Executar o Projeto
Certifique-se de que você possui o Java instalado em sua máquina.

Clone este repositório para o seu ambiente de desenvolvimento:

bash
Copy code
git clone https://github.com/seu-usuario/sistema-de-vagas.git
Navegue até o diretório do projeto:

bash
Copy code
cd sistema-de-vagas
Execute o aplicativo Spring Boot usando o Maven:

arduino
Copy code
mvn spring-boot:run
O aplicativo estará disponível em http://localhost:8080. Você pode acessar a interface do sistema através de um navegador web.

Endpoints da API
O sistema oferece os seguintes endpoints da API:

GET /vagas: Obtém a lista de todas as vagas de trabalho cadastradas.

POST /vagas: Cria uma nova vaga de trabalho. Envie os detalhes da vaga no corpo da solicitação.

PUT /vagas/{id}: Atualiza uma vaga de trabalho existente com base no ID.

DELETE /vagas/{id}: Exclui uma vaga de trabalho com base no ID.

GET /candidatos: Obtém a lista de todos os candidatos cadastrados.

POST /candidatos: Cria um novo candidato. Envie os detalhes do candidato no corpo da solicitação.

GET /vagas/filtrar: Filtra vagas de trabalho com base em critérios, como salário desejado e habilidades.

Contribuição
Este é um projeto inicial de um estudante, e qualquer contribuição é bem-vinda. Se você quiser contribuir com novos recursos, correções de bugs ou melhorias na documentação, fique à vontade para criar um "pull request" neste repositório.

Licença
Este projeto é distribuído sob a licença MIT. Consulte o arquivo LICENSE para obter mais informações.

Divirta-se explorando o sistema de vagas de trabalho! Se tiver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato.
