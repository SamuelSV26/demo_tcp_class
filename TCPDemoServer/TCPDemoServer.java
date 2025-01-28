public class TCPDemoServer {
    public static void main(String[] args) {
        TCPServer tcpServer = new TCPServer(9090);
        tcpServer.start();
    }
}
