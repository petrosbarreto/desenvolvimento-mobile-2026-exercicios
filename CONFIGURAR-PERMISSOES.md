# 🔧 Configurar Permissões do GitHub Actions

O bot de validação automática precisa de permissões para comentar nos Pull Requests.

## Passos para Configurar

### 1. Ir para Settings do Repositório

```
Repositório → Settings → Actions → General
```

### 2. Workflow Permissions

Descer até "Workflow permissions" e selecionar:

✅ **Read and write permissions**

Ou marcar:
- ✅ Allow GitHub Actions to create and approve pull requests

### 3. Salvar

Clicar em **Save** no final da página.

## Verificar se Funcionou

1. Fazer um novo push ou reabrir o PR
2. GitHub Actions deve rodar novamente
3. Bot deve comentar com o resultado

## Erro Comum

```
Error: Resource not accessible by integration
HttpError 403
```

**Solução:** Seguir os passos acima para dar permissões de escrita ao Actions.

---

## Para Instrutores

Se você clonou este repositório e está usando em sua própria conta, certifique-se de:

1. Fazer fork (não clone direto)
2. Habilitar GitHub Actions no fork
3. Configurar permissões conforme acima
4. Habilitar GitHub Pages (para leaderboard)

---

**Mais detalhes:** [GitHub Docs - Permissions for GITHUB_TOKEN](https://docs.github.com/en/actions/security-guides/automatic-token-authentication#permissions-for-the-github_token)
