#!/bin/bash

# Carregar as credenciais a partir de variáveis de ambiente
USERNAME=${GITHUB_USERNAME}
TOKEN=${GITHUB_TOKEN_NEW} 

# Definir URL do repositório com autenticação via token
REPO_URL="https://$USERNAME:$TOKEN@github.com/LukasNasciment0/scriptsGit.git"

# Verifica se há alterações a serem adicionadas
if [[ -n $(git status --porcelain) ]]; then
    echo "Adicionando alterações..."
    
    # Atualizar .gitignore
    echo "*.log" >> .gitignore
    echo "*.swp" >> .gitignore
    echo "*.swo" >> .gitignore
    echo "*.sh.swo" >> .gitignore
    echo "node_modules/" >> .gitignore

    git add .gitignore

    git add .

    # Verificar se o argumento de commit foi fornecido
    if [[ -z "$1" ]]; then
        echo "Nenhuma mensagem de commit fornecida. Usando mensagem padrão."
        COMMIT_MSG="Commit automático: alterações"
    else
        COMMIT_MSG="$1"
    fi

    git commit -m "$COMMIT_MSG"
else
    echo "Nenhuma alteração para adicionar."
fi

# Faz push para o repositório remoto
echo $USERNAME
echo $TOKEN

echo "Fazendo push para o repositório remoto..."
git push "$REPO_URL"

