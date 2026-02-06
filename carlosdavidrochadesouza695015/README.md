# Processo Seletivo SEPLAG-MT - Engenheiro de Computação Sênior
> **Candidato:** Carlos David Rocha de Souza  
> **Projeto:** API de Gerenciamento de Catálogo Musical (Artistas & Álbuns)

Esta aplicação foi desenvolvida seguindo os mais altos padrões de engenharia de software, atendendo aos requisitos funcionais e não funcionais do edital, com foco em segurança, escalabilidade e conteinerização.

## 🛠️ Stack Tecnológica
- **Linguagem:** Java 21 (LTS)
- **Framework:** Spring Boot 3.x
- **Persistência:** PostgreSQL
- **Storage:** MinIO (Object Storage S3 Compatible)
- **Migrações:** Flyway
- **Segurança:** Spring Security + JWT (JSON Web Token)

## 🚀 Como Executar o Projeto

### 1. Orquestração da Infraestrutura (Docker)
A aplicação depende de serviços externos orquestrados via Docker Compose. Na raiz do projeto, execute:
```bash
docker-compose up -d