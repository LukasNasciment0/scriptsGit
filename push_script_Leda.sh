#!/bin/bash

# Carregar as credenciais a partir de variáveis de ambiente
USERNAME=${GITHUB_USERNAME}
PASSWORD=${GITHUB_PASSWORD}

REPO_URL="https://$USERNAME:$PASSWORD@github.com/eda-ufcg//LukasNasciment0/scriptsGit"
# Verifica se há alterações a serem adicionadas
if [[ -n $(git status -s) ]]; then
    echo "Adicionando alterações..."
    git add .

    

    git commit -m "$1"
else
    echo "Nenhuma alteração para adicionar."
fi

# Faz push para o repositório remoto
echo "Fazendo push para o repositório remoto..."
git push "$REPO_URL"

