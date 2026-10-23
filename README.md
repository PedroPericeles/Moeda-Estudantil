# 🪙 Sistema de Moeda Estudantil

Projeto desenvolvido para a disciplina de Projeto de Software (Laboratório 3) do curso de Engenharia de Software da PUC Minas.

O sistema busca estimular o mérito estudantil por meio de uma moeda virtual. Professores distribuem moedas aos alunos como reconhecimento; os alunos podem trocá-las por produtos e descontos oferecidos por empresas parceiras.

## Integrantes

- **Pedro Augusto Periceles**
- **Santhiago Takaesu**

**Professora:** Milena Menezes Adão

## Requisitos do sistema

### Descrição geral

O sistema deve estimular o reconhecimento do mérito estudantil por meio de uma moeda virtual. Professores distribuem moedas aos alunos, que podem trocá-las por produtos e descontos oferecidos por empresas parceiras.

### Usuários, cadastros e autenticação

- **Alunos:** podem se cadastrar informando nome, email, CPF, RG, endereço, instituição de ensino e curso. A instituição deve ser selecionada entre as instituições previamente cadastradas.
- **Professores:** são pré-cadastrados a partir da lista enviada pela instituição parceira. O cadastro deve conter nome, CPF, departamento e vínculo explícito com a instituição de ensino.
- **Empresas parceiras:** podem se cadastrar no sistema e oferecer vantagens aos alunos.
- **Autenticação:** alunos, professores e empresas parceiras devem possuir login e senha. O acesso às funcionalidades deve exigir autenticação.

### Moedas e transações

- A cada semestre, cada professor recebe 1.000 moedas.
- O saldo não distribuído é acumulável: a nova cota semestral deve ser adicionada ao saldo corrente.
- O professor pode enviar moedas a um aluno, desde que tenha saldo suficiente. Para cada envio, deve informar o montante e uma mensagem aberta e obrigatória com o motivo do reconhecimento.
- Após o envio, o saldo do professor deve ser debitado e o saldo do aluno creditado. O aluno deve receber uma notificação por email.
- Alunos e professores podem consultar o saldo e o extrato de suas contas. O extrato do professor deve mostrar as cotas recebidas e os envios; o do aluno, os recebimentos e os resgates.

### Vantagens e resgates

- Empresas parceiras podem cadastrar vantagens com descrição, foto do produto e custo em moedas.
- O aluno pode resgatar uma vantagem quando seu saldo for igual ou superior ao custo. O custo deve ser descontado do saldo no resgate.
- Para cada resgate, o sistema deve gerar um código de conferência.
- O aluno deve receber por email um cupom com o código; a empresa parceira deve receber por email os dados da troca e o mesmo código para conferência presencial.

## Histórias de usuário

### Gestão de usuários e autenticação

**👤 US01 — Cadastro de aluno**

Como aluno que deseja ingressar no sistema de mérito, quero cadastrar meus dados pessoais e acadêmicos para participar do programa de reconhecimento.

Critérios de aceite:

- O cadastro solicita nome, email, CPF, RG, endereço, instituição de ensino e curso.
- O aluno seleciona uma instituição entre as previamente cadastradas.
- O sistema não permite CPFs duplicados.

**US02 — Autenticação**

Como aluno, professor ou empresa parceira, quero acessar o sistema com minhas credenciais para utilizar as funcionalidades disponíveis ao meu perfil.

Critérios de aceite:

- Alunos, professores e empresas parceiras têm login e senha.
- A autenticação é obrigatória para acessar as funcionalidades do sistema.
- Cada perfil acessa as funcionalidades correspondentes ao seu papel.

**US03 — Cadastro de empresa parceira**

Como empresa interessada em participar do programa, quero me cadastrar no sistema para gerenciar minha conta e oferecer vantagens aos estudantes.

Critérios de aceite:

- A empresa pode realizar seu cadastro e criar credenciais de acesso.
- A empresa parceira pode cadastrar e gerenciar as vantagens que oferece.

### 💰 Distribuição e consulta de moedas

**US04 — Cadastro prévio de professores**

Como instituição de ensino participante, quero informar os professores vinculados à instituição para que eles possam distribuir moedas aos alunos.

Critérios de aceite:

- As instituições participantes e seus professores são pré-cadastrados no sistema.
- O cadastro do professor inclui nome, CPF, departamento e vínculo com a instituição.

**US05 — Recebimento semestral de moedas pelo professor**

Como professor, quero receber a cota semestral de moedas para reconhecer o mérito dos meus alunos.

Critérios de aceite:

- O professor recebe 1.000 moedas a cada semestre.
- Moedas não distribuídas permanecem no saldo; a nova cota é adicionada ao saldo acumulado.

**US06 — Distribuição de moedas por mérito**

Como professor, quero enviar moedas a um aluno e informar o motivo para reconhecer seu bom comportamento, participação ou outro mérito.

Critérios de aceite:

- O professor seleciona o aluno, informa o montante e preenche uma mensagem aberta obrigatória com o motivo.
- O envio só é realizado quando o professor possui saldo suficiente.
- O saldo do professor e o do aluno são atualizados após a transação.
- O aluno recebe uma notificação por email após receber moedas.

**US07 — Consulta de extrato**

Como aluno ou professor, quero consultar meu saldo e minhas transações para acompanhar a movimentação da minha conta.

Critérios de aceite:

- O extrato apresenta o saldo atual e o histórico de transações.
- Para o professor, apresenta as cotas semestrais recebidas e os envios realizados.
- Para o aluno, apresenta as moedas recebidas e os resgates realizados.

### 🛍️ Vantagens e resgates

**US08 — Cadastro de vantagens**

Como empresa parceira, quero cadastrar produtos e descontos para que os alunos possam conhecê-los e resgatá-los.

Critérios de aceite:

- Cada vantagem inclui descrição, foto do produto e custo em moedas.
- A vantagem fica disponível para consulta e resgate pelos alunos.

**US09 — Resgate de vantagem**

Como aluno, quero trocar moedas por uma vantagem cadastrada para obter um produto ou desconto oferecido por uma empresa parceira.

Critérios de aceite:

- O aluno seleciona uma vantagem disponível.
- O resgate só é concluído quando o aluno possui saldo igual ou superior ao custo.
- O custo da vantagem é descontado do saldo do aluno após o resgate.

**US10 — Cupom e confirmação do resgate**

Como aluno e empresa parceira, queremos receber os dados do resgate e um código de conferência para validar a troca presencial.

Critérios de aceite:

- O sistema gera um código para identificar o resgate.
- O aluno recebe por email um cupom com o código.
- A empresa parceira recebe por email os dados da troca e o mesmo código para conferência.

## Modelagem

Os diagramas produzidos no projeto estão disponíveis em [`Diagramas/`](./Diagramas/):

- [Diagrama de casos de uso](./Diagramas/Diagrama%20Caso%20de%20uso.png)
- [Diagrama de classes](./Diagramas/Diagrama%20de%20classe.png)
- [Diagrama de componentes](./Diagramas/Diagrama%20de%20componentes.png)
- [Modelo entidade-relacionamento](./Diagramas/DiagramaER.png)
- [Modelo ER detalhado em Mermaid](./Diagramas/ModeloER.md)

## Implementação inicial (Lab 4.2)

O projeto usa Java 21, Spring Boot, Spring MVC e Spring Data JPA com banco H2 em arquivo para persistir os dados. A aplicação segue MVC: as entidades representam o modelo, os repositórios JPA acessam o banco, os serviços concentram as operações e os controladores expõem a API HTTP; a interface web é servida pela aplicação.

Nesta etapa estão implementados:

- CRUD de alunos e empresas parceiras (criar, listar, buscar por ID, editar e excluir).
- Lista de instituições pré-cadastradas para selecionar no cadastro do aluno (o banco de demonstração inclui PUC Minas).
- Validação de campos obrigatórios, formato básico de email, quantidade de dígitos de CPF/CNPJ e tamanho mínimo de senha.
- Restrições no banco para impedir duplicidade de CPF, RG, CNPJ, email e login.
- Senhas armazenadas com hash BCrypt e DTOs que não retornam a senha nem o hash pela API.
- Interface web conectada ao back-end, acessível em `http://localhost:8080`.

### Como executar

É necessário ter Java 21 e Maven instalados. Na raiz do repositório, execute:

```bash
mvn package
java -jar target/moeda-estudantil-1.0.0.jar
```

O Spring Boot cria o arquivo `data/moeda-estudantil.mv.db` e as tabelas automaticamente. A aplicação disponibiliza o console H2 em `/h2-console` durante o desenvolvimento. Para mudar a URL JDBC, configure `SPRING_DATASOURCE_URL`; para mudar a porta HTTP, configure `PORT` (padrão `8080`). As tabelas de moedas, transações, vantagens e resgates permanecem para etapas posteriores.

## Processo de desenvolvimento

- **Lab03S01:** modelagem do sistema, incluindo diagrama de casos de uso, histórias de usuário, diagrama de classes e diagrama de componentes.
- **Lab03S02:** elaboração do modelo ER, definição e implementação da estratégia de acesso ao banco de dados e desenvolvimento inicial dos CRUDs de aluno e empresa parceira, com interface e comunicação com o back-end.
- **Sprint 03:** apresentação do protótipo e de um tutorial sobre as tecnologias escolhidas. Cada apresentação tem duração prevista de 20 minutos.

O sistema deve seguir a arquitetura MVC. Os modelos UML e o código devem ser mantidos atualizados no repositório ao longo das sprints, de modo que a documentação acompanhe a implementação.
