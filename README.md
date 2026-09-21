# Projeto Cliente-Servidor em Java

## Objetivo

Este projeto implementa uma comunicação Cliente/Servidor utilizando **sockets TCP** na linguagem Java. O cliente estabelece uma conexão com o servidor, envia um número inteiro e recebe como resposta o cálculo do seu fatorial realizado pelo servidor.

O projeto foi desenvolvido para demonstrar os conceitos básicos de comunicação em rede na camada de transporte, incluindo conexão, troca de dados, processamento de requisições e envio de respostas.

## Funcionamento

1. O `Servidor` abre a porta `5000` e aguarda uma conexão.
2. O `Cliente` conecta-se ao endereço `localhost` na porta `5000`.
3. O usuário informa um número inteiro no cliente.
4. O cliente envia esse número ao servidor.
5. O servidor calcula o fatorial do número recebido.
6. O servidor envia o resultado para o cliente.
7. Cliente e servidor exibem as informações no terminal e encerram a conexão.

> `localhost` é usado porque os dois programas são executados no mesmo computador. Para executar em máquinas diferentes, substitua `localhost` no arquivo `Cliente.java` pelo endereço IP da máquina que executa o servidor.

## Estrutura

```text
Cliente.java    Aplicação que se conecta ao servidor, envia um número e recebe o resultado.

Servidor.java   Aplicação que aguarda o cliente, calcula o fatorial e retorna a resposta.
```

Os arquivos `.class` são criados automaticamente durante a compilação.

## Bibliotecas utilizadas

Todas as bibliotecas utilizadas fazem parte do Java padrão; não é necessário instalar dependências extras.

| Biblioteca | Finalidade |
|------------|------------|
| `java.net.ServerSocket` | Abre uma porta no servidor e aguarda conexões TCP. |
| `java.net.Socket` | Cria a conexão TCP entre cliente e servidor e permite a troca de dados. |
| `java.io.ObjectOutputStream` | Envia objetos Java pela conexão. |
| `java.io.ObjectInputStream` | Lê objetos recebidos pela conexão. |
| `java.io.IOException` | Trata possíveis erros de entrada, saída e comunicação de rede. |
| `java.util.Scanner` | Lê o número informado pelo usuário no cliente. |

## Como compilar e executar

### 1. Compilar os programas

```bash
javac Cliente.java Servidor.java
```

### 2. Iniciar o servidor

```bash
java Servidor
```

Saída esperada:

```text
Servidor iniciado na porta: 5000
Aguardando conexao do cliente...
```

### 3. Executar o cliente em outro terminal

Deixe o terminal do servidor aberto. Crie um segundo terminal no VS Code e execute:

```bash
java Cliente
```

Exemplo de execução:

```text
Conectado ao servidor!
Digite um número para calcular o fatorial: 5
Resposta do servidor: O fatorial de 5 e 120
```

No terminal do servidor:

```text
Cliente conectado!
Numero Recebido: 5
```

## Exemplo de cálculo

Entrada:

```text
5
```

Processamento:

```text
5! = 5 × 4 × 3 × 2 × 1
```

Resultado:

```text
120
```

## Protocolo de transporte

O projeto utiliza **TCP (Transmission Control Protocol)**. Esse protocolo estabelece uma conexão entre cliente e servidor e garante que os dados enviados cheguem de forma confiável, sem perdas e na ordem correta.

## Autor

Judyson Andrade Justino
