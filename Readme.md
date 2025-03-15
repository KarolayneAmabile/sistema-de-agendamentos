# Sistema de Agendamentos

Este projeto foi desenvolvido como parte do projeto integrador **"MyFirstSoftware"** para as disciplinas de **Programação Orientada a Objetos**, **Análise e Projeto de Software** e **Banco de Dados I** do curso de **Bacharelado em Ciência da Computação** no **IFG Anápolis**.

## 📋 Descrição
O **Sistema de Agendamentos** é uma aplicação em **Java**, que utiliza persistência de dados local para gerenciar agendamentos e serviços de um salão de beleza. O sistema permite:

- Cadastro de novos agendamentos.
- Cadastro de novos serviços.
- Atualização automática da interface gráfica.
- Persistência de dados através de serialização.

## 🛠️ Tecnologias Utilizadas
- **Java SE**
- **Swing (para interface gráfica)**
- **Serialização para persistência de dados**

## 📂 Estrutura do Projeto
```
SistemaAgendamentos/
│
├── controller/
│   └── SalonController.java
│
├── models/
│   ├── Salon.java
│   ├── Appointment.java
│   ├── Service.java
│   ├── SalonEvent.java
│   └── SalonListener.java
│
├── view/
│   └── Planner.java
│
├── serialization/
│   ├── Serialization.java
│   └── Deserialization.java
│
└── SistemaAgendamentos.java
```

## 🔧 Funcionalidades
- Interface gráfica simples e intuitiva.
- Registro de agendamentos com cliente, data, hora e serviço.
- Cadastro de novos serviços.
- Cálculo automático do valor total do dia.
- Persistência de dados através de arquivos `.obj`.

## ✅ Próximos Passos
- Implementar a exclusão de agendamentos.
- Melhorar o layout da interface gráfica.
- Integrar banco de dados PostgreSQL (futuro).

## 📝 Autoria
Desenvolvido por **Karolayne Amábile**.

