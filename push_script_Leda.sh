#!/bin/bash

# Carregar as credenciais a partir de variáveis de ambiente
USERNAME=${GITHUB_USERNAME}
TOKEN=${GITHUB_TOKEN}  # Usando TOKEN em vez de PASSWORD

# Definir URL do repositório com autenticação via token
REPO_URL="https://$USERNAME:$TOKEN@github.com/LukasNasciment0/scriptsGit"

# Verifica se há alterações a serem adicionadas
if [[ -n $(git status --porcelain) ]]; then
    echo "Adicionando alterações..."
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
echo "Fazendo push para o repositório remoto..."
git push "$REPO_URL"

