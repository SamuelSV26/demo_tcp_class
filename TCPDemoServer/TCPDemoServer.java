import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPDemoServer {
    public static void main(String[] args) {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(new File("configuration.properties")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCPDemoClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPDemoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sslRout = p.getProperty("SSL_CERTIFICATE_ROUTE");
        String sslPassword = p.getProperty("SSL_PASSWORD");
        System.setProperty("javax.net.ssl.keyStore", sslRout);
        System.setProperty("javax.net.ssl.keyStorePassword", sslPassword);
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
        System.setProperty("javax.net.ssl.trustStore", sslRout);
        System.setProperty("javax.net.ssl.trustStorePassword", sslPassword);
        System.setProperty("javax.net.ssl.trustStoreType", "PKCS12");

        TCPServer tcpServer = new TCPServer(9090);
        tcpServer.start();

    }

}
