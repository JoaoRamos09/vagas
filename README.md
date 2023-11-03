# Sistema de Vagas de Trabalho

Este é o meu primeiro projeto web individual desenvolvido, a ideia é que seja um CRUD com uma API e seus endpoints. O projeto é um sistema de vagas de trabalho, no qual é possível cadastrar, atualizar e excluir vagas e candidatos. Além disso, o sistema permite a filtragem de vagas com base nas características dos candidatos, como o salário.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Banco de dados H2 (em memória)

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

- Cadastro de vagas de trabalho: Os usuários podem criar novas vagas de trabalho, fornecendo informações como título, descrição, salário.

- Atualização de vagas de trabalho: É possível atualizar informações de vagas já existentes, como o salário e os requisitos.

- Exclusão de vagas de trabalho: Os usuários podem remover vagas de trabalho que não são mais necessárias.

- Cadastro de candidatos: Os candidatos podem se cadastrar no sistema, informando seu nome, CPF e pretensão salarial.

- Atualização de candidatos: É possível atualizar as informações dos candidatos.

- Exclusão dos candidatos: É possível remover candidatos que já não são mais necessários.

- Filtragem de vagas: Os candidatos podem filtrar vagas com base no salário pretendido.

## Como Executar o Projeto

1. Certifique-se de que você possui o Java instalado em sua máquina.

2. Clone este repositório para o seu ambiente de desenvolvimento:

3. Navegue até o diretório do projeto:

4. O aplicativo estará disponível em `http://localhost:8080`. A porta utilizada poderá ser outra, dependendo da sua configuração local.

## Endpoints da API

O sistema oferece os seguintes endpoints da API:

- `GET /jobs/`: Obtém a lista de todas as vagas de trabalho cadastradas.

- `POST /jobs/`: Cria uma nova vaga de trabalho. Envie os detalhes da vaga no corpo da solicitação.

- `PUT /jobs/{id}`: Atualiza uma vaga de trabalho existente com base no ID.

- `DELETE /jobs/{id}`: Exclui uma vaga de trabalho com base no ID.

- `GET /candidate/`: Obtém a lista de todos os candidatos cadastrados.

- `POST /candidate/`: Cria um novo candidato. Envie os detalhes do candidato no corpo da solicitação.

- `DELETE /candidate/{id}`: Exclui uma vaga de trabalho com base no ID.

- `GET /jobs/jobsbycandidatesalary/{id}`: Filtra vagas de trabalho com base no salário pretendido pelo candidato.

## Contribuição

Este é um projeto inicial de um estudante, e qualquer contribuição é bem-vinda. Se você quiser contribuir com novos recursos, correções de bugs ou melhorias na documentação, fique à vontade para criar um "pull request" neste repositório.

## Licença

Este projeto é distribuído sob a licença MIT.

---

Divirta-se explorando o sistema de vagas de trabalho! Se tiver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato.

