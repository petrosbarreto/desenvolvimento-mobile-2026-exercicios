# 🎓 Sistema de Exercícios SEM MERGE

## 🎯 Como Funciona

Este sistema **NÃO mergeia Pull Requests** para manter as soluções privadas e evitar cópias entre alunos.

---

## 📊 Fluxo Completo

```
┌─────────────────────┐
│  Aluno faz Fork     │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│  Resolve exercício  │
│  no fork privado    │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│  Cria Pull Request  │
│  para repo oficial  │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│  🤖 Validação Auto  │
│  GitHub Actions     │
└──────────┬──────────┘
           │
           ├─────────────┐
           │             │
           ▼             ▼
   ✅ Aprovado    ❌ Reprovado
  (score ≥70)   (score <70)
           │             │
           │             └───► Aluno corrige e
           │                   faz novo push
           ▼
┌─────────────────────┐
│  Score registrado   │
│  (via Check Run)    │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ Leaderboard atualiza│
│ (lê dados dos PRs)  │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ PR FICA ABERTO      │
│ (nunca é mergeado)  │
└─────────────────────┘
```

---

## 🔒 Por Que NÃO Mergear?

### Problema com Merge:
```
Aluno A mergeia → código fica público → Aluno B copia
```

### Solução SEM Merge:
```
Aluno A: PR aberto → score registrado → código no fork dele (privado)
Aluno B: PR aberto → score registrado → código no fork dele (privado)
```

**Resultado:** Cada um mantém sua solução privada! 🔐

---

## 🏆 Como o Leaderboard Funciona?

### Antes (com merge):
- Lia pastas na `main`
- Precisava mergear para aparecer no ranking
- ❌ Soluções ficavam públicas

### Agora (sem merge):
- Lê PRs via GitHub API
- Busca Check Runs (validação)
- Extrai score do Summary
- ✅ Soluções ficam privadas!

---

## 👨‍🏫 Para o Professor

### Gerenciar PRs:

**Ver todos os exercícios:**
```
GitHub → Pull Requests → Filtros:
- is:pr (todos os PRs)
- is:open (abertos)
- is:closed (fechados)
- label:aula01 (por aula)
```

**Dar feedback:**
1. Abrir o PR
2. Ir em "Files changed"
3. Comentar em linhas específicas
4. Ou comentar no PR geral

**Fechar PR após review:**
```
Opção 1: "Close pull request" (sem merge)
Opção 2: Deixar aberto para histórico
```

**Revalidar exercício:**
```
Fechar → Reabrir o PR (triggers validação de novo)
```

### Atualizar Leaderboard Manualmente:

```bash
# Via GitHub Actions UI:
Actions → Update Leaderboard → Run workflow → Run

# Ou forçar commit:
git commit --allow-empty -m "Trigger leaderboard"
git push
```

---

## 🎓 Para Alunos

### "Meu PR não foi mergeado. Está errado?"

**NÃO!** É assim que funciona:
- ✅ Check verde = aprovado
- 🏆 Nome no leaderboard = registrado
- 📂 PR aberto = normal (não precisa mergear)

### "Como sei se passei?"

1. **Check verde ✅** no PR
2. **Score ≥70** no Summary do check
3. **Seu nome** no leaderboard

### "Posso ver a solução de outros?"

**NÃO!** As soluções ficam nos forks privados de cada aluno. Você só vê:
- Nome do aluno
- Score total
- Quantidade de exercícios

---

## 🔧 Manutenção

### Adicionar novo exercício:

1. Criar pasta `exercicios/aulaXX/`
2. Adicionar `README.md` com instruções
3. Criar workflow `.github/workflows/aulaXX.yml` (copiar template)
4. Commit e push

### Alterar critérios de aprovação:

Editar workflow da aula:
```yaml
# Mudar score mínimo
if [ $SCORE -ge 70 ]; then  # ← Alterar aqui
```

### Debug de validação:

Ver logs:
```
PR → Checks → Details → Expandir steps
```

---

## 📊 Estatísticas

### Ver progresso da turma:

Leaderboard mostra:
- Total de alunos ativos
- PRs validados
- Média geral da turma
- Top 3 (pódio)
- Ranking completo

### Exportar dados:

```bash
# Via API (requer token):
gh api repos/petrosbarreto/desenvolvimento-mobile-2026-exercicios/pulls \
  --jq '.[] | {user: .user.login, title: .title, state: .state}'
```

---

## 🆘 Troubleshooting

### Leaderboard não atualizou:

1. Verificar se workflow rodou: `Actions` → última run
2. Forçar atualização: Run workflow manualmente
3. Aguardar 2-3 minutos (pode demorar)

### Check do PR não rodou:

1. Verificar paths no workflow (deve cobrir `exercicios/aulaXX/**`)
2. Verificar se arquivo foi modificado no caminho correto
3. Reabrir PR (fecha e abre de novo)

### Score aparece zero:

1. Check passou? (✅ verde)
2. Score está no Summary? (clicar em Details)
3. Workflow de leaderboard rodou depois? (order matters)

---

## 📝 Checklist de Deploy

Para usar este sistema em outra disciplina:

- [ ] Fork este repositório
- [ ] Atualizar README.md (nome disciplina, professor)
- [ ] Habilitar GitHub Actions
- [ ] Configurar GitHub Pages (Settings → Pages → Branch: main, / root)
- [ ] Ajustar workflows (se necessário)
- [ ] Testar com PR fake
- [ ] Compartilhar URL do leaderboard com alunos

---

**Sistema desenvolvido por Prof. Petros Barreto** 🤖
