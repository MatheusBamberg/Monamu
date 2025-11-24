<h1 align="center">👚 Monamu 🛍️</h1>
<h4 align="center"><em>Sistema de Gerenciamento de Loja de Roupas</em></h4>

---


## 📝 Objetivo

O Monamu é um sistema para gerenciar uma loja de roupas, permitindo o controle de produtos, vendas, clientes, funcionários e fornecedores.
Foi desenvolvido como trabalho acadêmico para a disciplina de Engenharia de Software I, Banco de Dados II e Programação II do curso de Ciência da Computação da UNOESC.

## ✅ Funcionalidades do Sistema

| Área | Funcionalidade | Descrição |
|------|----------------|-----------|
| **📊 Dashboard** | Totais e alertas | Exibe totais de clientes, produtos em estoque e alertas de condicionais vencendo no dia. |
| **🔄 Produtos** | Cadastro | Cadastro detalhado com nome, tamanho, cor, tipo, preço de custo, preço de venda, quantidade em estoque, fornecedor e descrição. |
| **👥 Clientes** | Cadastro | Registro de clientes com código, nome, CPF, telefone, e-mail, endereço e data de cadastro. |
| **🧑‍💼 Funcionários** | Cadastro | Registro de funcionários com código, nome, CPF, cargo, data de admissão, telefone, e-mail e endereço. |
| | Login | Sistema de cadastro de usuário e senha para acesso ao sistema. |
| **📦 Fornecedores** | Cadastro | Registro de fornecedores com código, CNPJ, nome da empresa, e-mail, telefone e endereço. |
| **🛒 Vendas** | Registro de venda | Registro de vendas com data, cliente, funcionário, produtos vendidos (quantidade e preço), total e forma de pagamento. |
| | Cupons e Descontos | Registro e controle de cupons vinculados a campanhas ou promoções. |
| | Controle de estoque | Baixa automática do estoque após a finalização da venda. |
| **🔁 Condicional** | Registro | Registro de vendas no formato condicional, com data de retirada e data prevista para devolução. |
| | Controle | Marcação de condicional devolvida ou não. |
| **🏬 Loja** | Cadastro | Registro da loja com código, nome, rua, bairro, cidade, CNPJ e telefone de contato. |

## 📄 Requisitos do Sistema

O Monamu foi desenvolvido seguindo requisitos funcionais e não funcionais que orientam o cadastro de produtos, clientes, funcionários, fornecedores, controle de vendas, condicional, estoque e loja.

Para ver todos os requisitos detalhados, acesse o [documento dos requisitos](Monamu-Requisitos.pdf).

## 📁 Estrutura de Pastas e Arquivos

````md
monamu/
├── **Diagramas/**
│   ├── Diagrama de Classes.vpp
│   ├── Diagrama de Estado.vpp
│   ├── Diagrama de Sequência.vpp
│   ├── Diagrama de Atividades.vpp
│   └── Modelos de Caso de Uso/
│       └── 
│
├── **Scripts/**
│   ├── Backup e Restore - Monamu.pdf
│   ├── Script de Criação - Monamu.sql
│   ├── Script de Inserts - Monamu.sql
│   ├── Script de Política de Acesso - Monamu.sql
│   ├── Script de Procedures - Monamu.sql
│   ├── Script de Triggers - Monamu.sql
│   └── Script de Views - Monamu.sql
│
├── **Monamu/**
│   └── (código-fonte Java + frontend HTML/CSS/JS do sistema)
│
└── **Monamu-requisitos.pdf**

## 🛠️ Tecnologias Utilizadas

### **Backend**
- ☕ **Java**
- 🌱 **Spring Boot**
- 🗂️ **JPA / Hibernate**
- 📦 **Maven**

### **Banco de Dados**
- 🐘 **PostgreSQL**
- 🛠️ **DBeaver**
- 🖥️ **pgAdmin**

### **Frontend**
- 🌐 **HTML5**
- 🎨 **CSS3**
- ⚙️ **JavaScript**
- 🎀 **Bootstrap 5**

### **Modelagem e Documentação**
- 📊 **Visual Paradigm** (UML, DER, casos de uso)
  
### **Ferramentas de Desenvolvimento**
- 🖥️ **Eclipse**
- 📝 **VS Code**
- 🔧 Git
- 🌐 GitHub






## 👨‍💻 Desenvolvedores

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/maiarakothe" style="text-decoration: none; color: inherit;">
        <img src="https://avatars.githubusercontent.com/u/160647563?v=4" width="115"><br>
        <strong>Maiara Braun Kothe</strong>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/MatheusBamberg" style="text-decoration: none; color: inherit;">
        <img src="https://avatars.githubusercontent.com/u/204625992?v=4" width="115"><br>
        <strong>Matheus Scherer Bamberg</strong>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Zilles09" style="text-decoration: none; color: inherit;">
        <img src="https://avatars.githubusercontent.com/u/165856735?v=4" width="115"><br>
        <strong>Moisés Augusto Braun Zilles</strong>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/eric-camini482" style="text-decoration: none; color: inherit;">
        <img src="https://avatars.githubusercontent.com/u/205243776?v=4" width="115"><br>
        <strong>Eric Camini</strong>
      </a>
    </td>
  </tr>
</table>
