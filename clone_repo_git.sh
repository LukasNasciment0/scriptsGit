#!/bin/bash

# Verifica se a URL do repositório foi fornecida
#if [ -z "$1" ]; then
 #   echo "Uso: $0 <URL-do-repositório>"
  #  exit 1
#fi

# Substitua pelo seu token pessoal
GITHUB_USERNAME=${GITHUB_USERNAME}
GITHUB_TOKEN=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

# Obtém a URL do repositório
#REPO_URL=$1
echo "Cole o URL do repositório: "
read REPO_URL

# Constrói a URL com o token
AUTH_REPO_URL=$(echo "$REPO_URL" | sed "s#https://#https://$GITHUB_USERNAME:$GITHUB_TOKEN@#")

# Clona o repositório
echo "Clonando o repositório $REPO_URL..."
git clone "$AUTH_REPO_URL"

# Verifica se o clone foi bem-sucedido
if [ $? -eq 0 ]; then
    echo "Clone concluído com sucesso!"
else
    echo "Erro ao clonar o repositório."
    exit 1
fi
