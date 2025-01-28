import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private int port;;

    public TCPServer(int port) {
        this.port = port;
    }
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress());
                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                String message = dataInputStream.readUTF();
                message = message.trim();
                String[] parts = message.split(":");
                System.out.println("Message from client: " + message);
                NamesManager namesManager = new NamesManager();
                String response = namesManager.generateMessage(parts[0], parts[1]);
                System.out.println("Response: " + response);
                clientSocket.close();
                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
