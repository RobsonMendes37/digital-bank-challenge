# 🏦 Projeto Banco Java

Um sistema bancário simples desenvolvido em Java, aplicando os fundamentos de **Programação Orientada a Objetos** (POO) com foco em **boas práticas de arquitetura**, **separação de responsabilidades** e **preparação para testes automatizados**.

---

## 📚 Resumo das Camadas

| Camada       | Responsabilidade Principal                       | Exemplo de Ação                              |
|--------------|--------------------------------------------------|----------------------------------------------|
| **Model**    | Representar o mundo real                         | `Conta`, `Cliente`                           |
| **Repository** | Armazenar e buscar dados simulados (in memory) | Buscar uma conta pelo número                 |
| **Service**  | Implementar a lógica de negócio                  | Validar se pode sacar ou transferir          |
| **Controller** | Controlar o fluxo entre view e service         | Chamar o método de saque/transferência       |
| **View**     | Interagir com o usuário (entrada/saída)          | Mostrar opções e ler escolhas via console    |

---

## ✅ Funcionalidades

- Criar contas (corrente e poupança)
- Listar contas
- Realizar depósitos, saques e transferências
- Excluir contas
- Validação de entradas com tratamento de exceções

---

## 🧠 Conceitos Aplicados

- **Abstração**
- **Encapsulamento**
- **Herança**
- **Polimorfismo**
- **MVC + Service Layer**
- **Padrão Repository**

---

## 🧪 Testes (Planejamento Futuro)

- ✅ Separação da lógica para facilitar testes
- ⏳ Implementar:
    - [ ] Testes unitários (JUnit)
    - [ ] Testes de integração
    - [ ] Mockar `Repository` com Mockito

---

## 🛠️ Padrões de Projeto a Implementar

| Padrão       | Descrição                                           |
|--------------|-----------------------------------------------------|
| **Factory**  | Criar objetos `ContaCorrente` ou `ContaPoupanca` com base em parâmetros |
| **Singleton**| Garantir que o `ContaRepository` tenha apenas uma instância |
| **DAO**      | Separar persistência de dados (futuro: JDBC, JPA...) |
| **SOLID**    | Aplicar os 5 princípios de design da POO           |

---

## 🚀 Como rodar

1. Clone o projeto:
   ```bash
   git clone https://github.com/seu-usuario/banco-java.git
   cd banco-java
