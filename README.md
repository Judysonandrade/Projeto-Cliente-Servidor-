# Projeto Cliente-Servidor em Java

## Objetivo

Este projeto implementa uma comunicação Cliente/Servidor usando **sockets TCP** na linguagem Java. O cliente estabelece uma conexão com o servidor, envia uma mensagem de texto e recebe uma resposta confirmando que a mensagem foi recebida.

O projeto foi desenvolvido para demonstrar os conceitos básicos de comunicação em rede na camada de transporte: conexão, envio de dados, recebimento de resposta e encerramento da conexão.

## Funcionamento

1. O `Servidor` abre a porta `5000` e aguarda uma conexão.
2. O `Cliente` conecta-se ao endereço `localhost` na porta `5000`.
3. O cliente envia uma mensagem ao servidor.
4. O servidor recebe a mensagem e envia uma confirmação como resposta.
5. Cliente e servidor exibem as mensagens no terminal e encerram a conexão.

> `localhost` é usado porque os dois programas são executados no mesmo computador. Para executar em máquinas diferentes, substitua `localhost` no arquivo `Cliente.java` pelo endereço IP da máquina que executa o servidor.

## Estrutura

```text
Cliente.java    Aplicação que se conecta ao servidor, envia a mensagem e recebe a resposta.
Servidor.java   Aplicação que aguarda o cliente, recebe a mensagem e responde.
```

Os arquivos `.class` são criados automaticamente durante a compilação e não precisam ser enviados na entrega.

## Bibliotecas utilizadas

Todas as bibliotecas utilizadas fazem parte do Java padrão; não é necessário instalar dependências extras.

| Biblioteca | Finalidade |
| --- | --- |
| `java.net.ServerSocket` | Abre a porta no servidor e aguarda conexões TCP. |
| `java.net.Socket` | Cria a conexão TCP entre cliente e servidor e permite a troca de dados. |
| `java.io.ObjectOutputStream` | Envia objetos Java pela conexão; neste projeto, envia uma `String`. |
| `java.io.ObjectInputStream` | Lê objetos recebidos pela conexão; neste projeto, lê uma `String`. |
| `java.io.IOException` | Trata possíveis erros de entrada, saída e comunicação de rede. |

## Como compilar e executar

### Requisito

É necessário ter o Java instalado. Verifique no terminal:

```powershell
java --version
javac -version
```

### 1. Abrir o terminal na pasta do projeto

No VS Code, abra o terminal integrado em **Terminal > New Terminal**. Confirme que os arquivos estão na pasta atual:

```powershell
dir
```

### 2. Compilar os programas

```powershell
javac Cliente.java Servidor.java
```

### 3. Iniciar o servidor

```powershell
java Servidor
```

Saída esperada:

```text
Servidor iniciado na porta: 5000
Aguardando conexao do cliente...
```

### 4. Executar o cliente em outro terminal

Deixe o terminal do servidor aberto. Crie um segundo terminal no VS Code e execute:

```powershell
java Cliente
```

Saída esperada no cliente:

```text
Conectado ao servidor!
Mensagem enviada: Professor, o cliente conectou-se ao servidor usando comunicacao TCP.
Resposta do servidor: Servidor recebeu sua mensagem com sucesso: Professor, o cliente conectou-se ao servidor usando comunicacao TCP.
```

No terminal do servidor, será exibida a conexão do cliente e a mensagem recebida.

## Protocolo de transporte

O projeto utiliza **TCP**. Esse protocolo estabelece uma conexão entre cliente e servidor e garante que os dados enviados cheguem de forma confiável e na ordem correta.

## Entrega

Para a entrega solicitada, envie por e-mail somente os arquivos:

```text
Cliente.java
Servidor.java
```
