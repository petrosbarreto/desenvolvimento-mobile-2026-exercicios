# 📱 Exercício Prático - Aula 01

## 🎯 Objetivo

Criar seu primeiro aplicativo Android usando os conceitos aprendidos na Aula 1:
- Estrutura de um projeto Android
- Activity e Layout XML
- findViewById e listeners
- Executar app no emulador

---

## 📋 Descrição do Exercício

Crie um **app de apresentação pessoal** com as seguintes funcionalidades:

### 1. Tela Principal
- TextView com "Bem-vindo ao Android! 👋"
- TextView com seu nome completo
- TextView com sua matrícula
- Button "Mudar Cor"

### 2. Funcionalidade
- Ao clicar no botão, a cor de fundo da tela deve mudar
- Alternar entre pelo menos **3 cores diferentes**
- Cores suaves (não usar cores primárias puras)

### 3. Layout
- Usar `LinearLayout` vertical
- Componentes centralizados
- Padding de 24dp
- TextViews organizados verticalmente

---

## ✅ Requisitos Obrigatórios

### Estrutura do Projeto
```
exercicios/aula01/
└── HelloMobile/               # Projeto Android Studio
    ├── app/
    │   ├── src/main/
    │   │   ├── java/com/seuusername/hellomobile/
    │   │   │   └── MainActivity.kt
    │   │   └── res/
    │   │       ├── layout/
    │   │       │   └── activity_main.xml
    │   │       └── values/
    │   │           ├── strings.xml
    │   │           └── colors.xml
    │   └── build.gradle.kts
    └── README.md              # (não modificar)
```

### Configurações Obrigatórias
- [x] **Package name:** `com.seuusername.hellomobile` (substituir seuusername)
- [x] **Nome do app:** `HelloMobile`
- [x] **Linguagem:** Kotlin
- [x] **Minimum SDK:** API 24 (Android 7.0)

### Layout XML (activity_main.xml)
- [x] `LinearLayout` como root com `android:id="@+id/rootLayout"`
- [x] `android:orientation="vertical"`
- [x] `android:gravity="center"`
- [x] `android:padding="24dp"`
- [x] 3 TextViews com conteúdo personalizado
- [x] 1 Button com `android:id="@+id/btnMudarCor"`

### Código Kotlin (MainActivity.kt)
- [x] Array com pelo menos 3 cores (Color.parseColor)
- [x] findViewById para rootLayout e btnMudarCor
- [x] setOnClickListener no botão
- [x] Lógica para alternar cores (usar % para ciclar)
- [x] setBackgroundColor no rootLayout

### Requisitos de Código
- [x] Código compilando sem erros
- [x] Nomes de variáveis em camelCase
- [x] Comentários explicando a lógica
- [x] Sem warnings críticos no Lint

---

## 🎨 Exemplo de Cores Suaves

```kotlin
val cores = arrayOf(
    Color.parseColor("#FFFFFF"), // Branco
    Color.parseColor("#E3F2FD"), // Azul claro
    Color.parseColor("#FFF9C4"), // Amarelo claro
    Color.parseColor("#F1F8E9"), // Verde claro
    Color.parseColor("#FCE4EC"), // Rosa claro
    Color.parseColor("#E0F2F1")  // Ciano claro
)
```

---

## 🚀 Como Fazer

### 1. Criar Projeto no Android Studio
```
File → New → New Project
Selecionar: Empty Activity
Configurar conforme requisitos acima
```

### 2. Editar activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/rootLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp">

    <!-- Seu código aqui -->

</LinearLayout>
```

### 3. Implementar MainActivity.kt
```kotlin
package com.seuusername.hellomobile

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
// Imports necessários...

class MainActivity : AppCompatActivity() {
    // Seu código aqui
}
```

### 4. Testar no Emulador
- Run → Run 'app' (Shift+F10)
- Testar clique múltiplas vezes
- Verificar se cores mudam corretamente

---

## 📤 Como Entregar

### 1. Fork este repositório

### 2. Clone seu fork
```bash
git clone https://github.com/SEU_USUARIO/desenvolvimento-mobile-2026-exercicios.git
cd desenvolvimento-mobile-2026-exercicios
```

### 3. Crie uma branch
```bash
git checkout -b aula01-seu-nome
```

### 4. Copie seu projeto
```bash
# Copiar pasta HelloMobile para exercicios/aula01/
cp -r /caminho/do/seu/HelloMobile exercicios/aula01/
```

### 5. Commit e Push
```bash
git add exercicios/aula01/
git commit -m "Exercício Aula 01 - Seu Nome"
git push origin aula01-seu-nome
```

### 6. Criar Pull Request
- Vá no GitHub
- Compare & pull request
- Aguarde validação automática (~1-2 minutos)
- Bot comentará com seu score!

---

## 🤖 Validação Automática

O bot verificará:

### Estrutura (20 pontos)
- ✅ Pasta HelloMobile existe
- ✅ Package name correto
- ✅ Minimum SDK = 24
- ✅ Linguagem = Kotlin

### Layout XML (30 pontos)
- ✅ LinearLayout com id correto
- ✅ 3 TextViews presentes
- ✅ Button com id correto
- ✅ Atributos obrigatórios

### Código Kotlin (30 pontos)
- ✅ Array de cores definido (mín. 3)
- ✅ findViewById implementado
- ✅ setOnClickListener implementado
- ✅ Lógica de alternância correta

### Qualidade (20 pontos)
- ✅ Código compila
- ✅ Sem warnings críticos
- ✅ Código comentado
- ✅ Conteúdo personalizado

**Score mínimo para aprovação:** 70/100

---

## 🎁 Extras (Bônus)

Implemente funcionalidades adicionais para ganhar pontos extras:

- **+5 pontos:** Adicionar ícone personalizado ao app
- **+5 pontos:** Usar 6+ cores diferentes
- **+10 pontos:** Adicionar animação de transição entre cores
- **+10 pontos:** Salvar cor atual com SharedPreferences (tema da Aula 11!)
- **+10 pontos:** Adicionar botão "Reset" que volta para cor original

**Score máximo possível:** 140/100 (sim, pode passar de 100! 🚀)

---

## 🐛 Problemas Comuns

### App crasha ao iniciar
**Causa:** `setContentView(R.layout.activity_main)` ausente  
**Solução:** Adicionar no `onCreate()`

### Botão não responde
**Causa:** ID incorreto ou listener não configurado  
**Solução:** Verificar `android:id` no XML e `setOnClickListener` no código

### findViewById retorna null
**Causa:** ID não existe no XML ou chamado antes de setContentView  
**Solução:** Chamar após `setContentView()` e conferir IDs

### Cores não mudam
**Causa:** Lógica de alternância incorreta  
**Solução:** Usar `(indice + 1) % cores.size` para ciclar

### Gradle sync falha
**Causa:** Cache corrompido  
**Solução:** `File → Invalidate Caches → Invalidate and Restart`

---

## 📚 Recursos Úteis

- [Documentação Android - Build your first app](https://developer.android.com/training/basics/firstapp)
- [Kotlin for Android](https://developer.android.com/kotlin)
- [Views and Layouts](https://developer.android.com/guide/topics/ui/declaring-layout)
- [Material Design Colors](https://m3.material.io/styles/color/overview)

---

## 💡 Dicas

1. **Teste frequentemente:** Rode o app a cada mudança
2. **Use o Logcat:** Ajuda a debugar crashes
3. **Leia os erros:** Mensagens de erro do Android são descritivas
4. **Consulte os slides:** Aula 01 tem todos os conceitos necessários
5. **Peça ajuda:** Abra uma issue ou pergunte no grupo

---

## 🏆 Critérios de Avaliação

| Critério | Peso | Descrição |
|----------|------|-----------|
| **Funcionalidade** | 40% | App funciona, botão muda cores |
| **Código** | 30% | Qualidade, organização, comentários |
| **Layout** | 20% | Interface organizada e responsiva |
| **Extras** | 10% | Funcionalidades adicionais |

---

**Boa sorte! 🚀**

_Dúvidas? Abra uma issue com tag `dúvida` ou pergunte no grupo da turma._
