# Sistema de Moeda Estudantil

Trabalho desenvolvido para a disciplina de Projeto de Software (Laboratório 3) do curso de Engenharia de Software da PUC Minas.

## 👥 Integrantes do Grupo

* **Pedro Augusto Periceles**
* **Santhiago Takaesu**

**Professora:** Milena Menezes Adão

## 📖 Histórias de Usuário

Abaixo estão descritas as Histórias de Usuário mapeadas para o desenvolvimento do **Sistema de Moeda Estudantil**, estruturadas para orientar o desenvolvimento e validar as entregas.

---

### 👤 Épico 1: Gestão de Usuários e Autenticação

**US01 - Cadastro de Aluno**
> **Como** um aluno que deseja ingressar no sistema de mérito,
> **Eu quero** realizar um cadastro informando meus dados pessoais e acadêmicos,
> **Para que** eu possa criar minha conta e participar do programa de reconhecimento.
* **Critérios de Aceite:**
  * O formulário deve conter os campos: Nome, Email, CPF, RG, Endereço, Instituição de Ensino e Curso[cite: 1].
  * As Instituições de Ensino devem vir de uma lista pré-cadastrada[cite: 1].
  * O sistema não deve permitir o cadastro de CPFs duplicados.

**US02 - Autenticação no Sistema**
> **Como** um usuário do sistema (Aluno, Professor ou Empresa Parceira),
> **Eu quero** fazer login utilizando um email e uma senha cadastrados,
> **Para que** eu possa acessar minhas funcionalidades com segurança.
* **Critérios de Aceite:**
  * O processo de autenticação deve ser obrigatório para acessar as páginas internas[cite: 1].
  * O sistema deve redirecionar o usuário para o painel correto de acordo com seu perfil (Aluno, Professor ou Empresa).

**US03 - Cadastro de Empresa Parceira**
> **Como** uma empresa que deseja realizar parceria,
> **Eu quero** me cadastrar no sistema,
> **Para que** eu possa gerenciar minha conta e oferecer vantagens aos estudantes.
* **Critérios de Aceite:**
  * A empresa deve criar um login e senha válidos para acesso ao sistema[cite: 1].

---

### 💰 Épico 2: Gestão de Moedas e Reconhecimento

**US04 - Distribuição de Moedas por Mérito**
> **Como** um professor,
> **Eu quero** enviar moedas a um aluno selecionado utilizando meu saldo corrente,
> **Para que** eu possa reconhecer seu bom comportamento ou participação.
* **Critérios de Aceite:**
  * O professor deve possuir saldo suficiente para realizar o envio[cite: 1].
  * É obrigatório o preenchimento de uma mensagem aberta justificando o motivo do reconhecimento[cite: 1].
  * O saldo do professor deve ser deduzido imediatamente após o envio.

**US05 - Notificação de Recebimento de Moedas**
> **Como** um aluno,
> **Eu quero** ser notificado por email sempre que um professor me enviar moedas,
> **Para que** eu saiba imediatamente que fui reconhecido.
* **Critérios de Aceite:**
  * O disparo do email deve ser feito automaticamente após a confirmação do envio pelo professor[cite: 1].

**US06 - Consulta de Extrato da Conta**
> **Como** um usuário (Aluno ou Professor),
> **Eu quero** consultar o extrato da minha conta,
> **Para que** eu possa visualizar meu saldo atual e o histórico de transações.
* **Critérios de Aceite:**
  * Para o Professor: o extrato deve mostrar o recebimento semestral (1.000 moedas) e os envios realizados aos alunos[cite: 1].
  * Para o Aluno: o extrato deve mostrar o recebimento de moedas dos professores e os gastos com troca de vantagens[cite: 1].

---

### 🛍️ Épico 3: Gestão de Vantagens e Resgates

**US07 - Cadastro de Vantagens**
> **Como** uma empresa parceira,
> **Eu quero** cadastrar novos produtos ou descontos,
> **Para que** os alunos possam visualizar e resgatar com suas moedas.
* **Critérios de Aceite:**
  * O cadastro deve obrigatoriamente incluir: Nome da vantagem, Descrição, Foto do produto e Custo em moedas[cite: 1].

**US08 - Resgate de Vantagens**
> **Como** um aluno,
> **Eu quero** selecionar e resgatar uma vantagem cadastrada no sistema,
> **Para que** eu possa trocar minhas moedas acumuladas por um benefício real.
* **Critérios de Aceite:**
  * O aluno deve possuir saldo igual ou superior ao custo da vantagem.
  * Ao confirmar o resgate, o valor deve ser descontado imediatamente do saldo do aluno[cite: 1].

**US09 - Geração de Cupom e Notificação de Troca**
> **Como** um aluno ou empresa parceira,
> **Eu quero** receber um email contendo um código exclusivo logo após o resgate,
> **Para que** possamos conferir e validar a troca presencialmente.
* **Critérios de Aceite:**
  * O sistema deve gerar um código de confirmação único para a transação[cite: 1].
  * Um email com o cupom e o código deve ser enviado ao aluno[cite: 1].
  * Um email com os dados do resgate e o código deve ser enviado à empresa parceira para conferência[cite: 1].
