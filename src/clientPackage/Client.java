package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        String hote = "localhost";
        int port = 1234;
        try (Socket socket = new Socket(hote, port);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connecté au serveur.");
            int x;
            do {
                System.out.print("Entrez un entier (0 pour quitter) : ");
                x = sc.nextInt();
                out.writeInt(x);
                out.flush();
                int resultat = in.readInt();
                System.out.println(x + " * 5 = " + resultat);
            } while (x != 0);

            System.out.println("Communication terminée. Fermeture du socket.");
        } catch (IOException e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
    }
}