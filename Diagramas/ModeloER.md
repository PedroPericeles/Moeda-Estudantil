# Modelo entidade-relacionamento

Este modelo detalha as entidades e relações do sistema. A implementação do Lab 4.2 persiste as tabelas `instituicoes`, `alunos` e `empresas`, necessárias aos cadastros solicitados; as demais entidades documentam a evolução prevista para as próximas funcionalidades.

```mermaid
erDiagram
    INSTITUICAO ||--o{ ALUNO : matricula
    INSTITUICAO ||--o{ PROFESSOR : vincula
    PROFESSOR ||--o{ TRANSACAO : envia
    ALUNO ||--o{ TRANSACAO : recebe
    EMPRESA ||--o{ VANTAGEM : oferece
    ALUNO ||--o{ RESGATE : realiza
    VANTAGEM ||--o{ RESGATE : resgatada

    INSTITUICAO {
        int id PK
        string nome
    }
    ALUNO {
        int id PK
        string nome
        string email UK
        string login UK
        string senha_hash
        string cpf UK
        string rg UK
        string endereco
        string curso
        int instituicao_id FK
    }
    PROFESSOR {
        int id PK
        string nome
        string cpf UK
        string departamento
        int instituicao_id FK
    }
    EMPRESA {
        int id PK
        string nome
        string email UK
        string login UK
        string senha_hash
        string cnpj UK
    }
    VANTAGEM {
        int id PK
        string nome
        string descricao
        string foto
        int custo_moedas
        int empresa_id FK
    }
    TRANSACAO {
        int id PK
        datetime data
        int valor
        string motivo
        int professor_id FK
        int aluno_id FK
    }
    RESGATE {
        int id PK
        datetime data
        string codigo_cupom UK
        int aluno_id FK
        int vantagem_id FK
    }
```

`UK` indica valor único e `FK` indica chave estrangeira. O diagrama visual inicial continua em [DiagramaER.png](./DiagramaER.png).
