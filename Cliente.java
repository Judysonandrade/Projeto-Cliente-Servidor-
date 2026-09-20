import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Conectado ao servidor!");

            ObjectOutputStream outputStream =
                    new ObjectOutputStream(socket.getOutputStream());

            outputStream.flush();

            ObjectInputStream inputStream =
                    new ObjectInputStream(socket.getInputStream());

            String mensagem = "Professor, o cliente conectou-se ao servidor usando comunicacao TCP.";

            System.out.println("Mensagem enviada: " + mensagem);

            outputStream.writeObject(mensagem);
            outputStream.flush();

            String resposta = (String) inputStream.readObject();

            System.out.println("Resposta do servidor: " + resposta);

            inputStream.close();
            outputStream.close();
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro no cliente: " + e.getMessage());
        }
    }
}