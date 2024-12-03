#!/bin/bash

# Carregar as credenciais a partir de variáveis de ambiente
USERNAME=${GITHUB_USERNAME}
TOKEN=${GITHUB_TOKEN}

# Perguntando o nome do repositório e guardando a entrada na variável
echo "Digite o nome do repositório: "
read REPONAME

# Verificar se o nome do repositório está vazio
if [[ -z "$REPONAME" ]]; then
    echo "Erro: O nome do repositório não pode estar vazio."
    exit 1
fi

mkdir $REPONAME
cd $REPONAME
# Iniciando o repositório localmente
echo "Iniciando o repositório $REPONAME localmente..."
git init

# Criar um arquivo README
echo "# $REPONAME" > README.md
git add README.md
git commit -m "Adicionando arquivo README"

# Adicionando o repositório remoto
git remote add origin "https://github.com/$USERNAME/$REPONAME.git"

# Criar o repositório remotamente via API
response=$(curl -s -o response.json -w "%{http_code}" -H "Authorization: token $TOKEN" \
     -H "Content-Type: application/json" \
     -d "{\"name\":\"$REPONAME\"}" \
     https://api.github.com/user/repos)

# Verificando se a criação do repositório foi bem-sucedida
if [ "$response" -eq 201 ]; then
    echo "Repositório $REPONAME criado com sucesso no GitHub!"
    
    # Gerar script de commit e push
    commit_push_script="commit_and_push.sh"
    echo "#!/bin/bash" > $commit_push_script
    echo "git add ." >> $commit_push_script
    echo "git commit -m \"Commit automático: Adicionando mudanças iniciais\"" >> $commit_push_script
    echo "git push -u origin main" >> $commit_push_script  # Altere 'main' para 'master' se necessário

    # Tornar o script executável
    chmod +x $commit_push_script
    
    echo "Script '$commit_push_script' criado. Você pode executá-lo para fazer commit e push das mudanças."
else
    echo "Erro ao criar o repositório no GitHub. Código de resposta: $response"
    echo "Mensagem de erro: $(jq '.message' response.json)"
fi

# Limpeza: removendo o arquivo temporário de resposta
rm response.json

