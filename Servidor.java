import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private ServerSocket serverSocket;

    private void criarServidor(int porta) throws IOException {
        serverSocket = new ServerSocket(porta);
        System.out.println("Servidor iniciado na porta: " + porta);
    }

    private Socket aguardarConexao() throws IOException {
        System.out.println("Aguardando conexao do cliente...");

        Socket clientSocket = serverSocket.accept();

        System.out.println("Cliente conectado!");
        return clientSocket;
    }

    private long calcularFatorial(int n){
        long resultado = 1;

        for(int i=1; i<=n;i++){
            resultado *= i;
        }

        return resultado;
    }

    private void tratarConexao(Socket clientSocket) {
        try {
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(clientSocket.getOutputStream());

            outputStream.flush();

            ObjectInputStream inputStream =
                    new ObjectInputStream(clientSocket.getInputStream());

            
            int numero = (Integer) inputStream.readObject();

            System.out.println("Numero Recebido: "
                    + numero);

            long Fatorial = calcularFatorial(numero);

            String resposta = "O fatorial de " + numero + " e " + Fatorial;

            outputStream.writeObject(resposta);
            outputStream.flush();

            inputStream.close();
            outputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao tratar a conexao: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor();

            servidor.criarServidor(5000);

            Socket clientSocket = servidor.aguardarConexao();

            servidor.tratarConexao(clientSocket);

            clientSocket.close();
            servidor.serverSocket.close();

        } catch (IOException e) {
            System.out.println("Erro no servidor: " + e.getMessage());
        }
    }
}