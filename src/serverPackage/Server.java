package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 1234;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serveur en attente de connexion sur le port " + port + "...");
            try (Socket socket = serverSocket.accept();
                 DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                System.out.println("Client connecté : " + socket.getInetAddress());
                int x;
                do {
                    x = in.readInt();
                    int resultat = x * 5;
                    System.out.println("Reçu : " + x + " -> envoi : " + resultat);
                    out.writeInt(resultat);
                    out.flush();
                } while (x != 0);

                System.out.println("Fin de la communication. Fermeture des sockets.");
            }
        } catch (IOException e) {
            System.err.println("Erreur serveur : " + e.getMessage());
        }
    }
}