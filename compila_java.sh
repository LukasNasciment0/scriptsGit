
#!/bin/bash

#script para compilar e rodar o programa java com um argumento (arquivo)
PROGRAMA=$1
ARQUIVO=$2

javac PROGRAMA
java PROGRAMA.java ARQUIVO

echo "Programa Compilado e Rodado!!!!"


