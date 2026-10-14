
package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("192.168.31.17");
            InetSocketAddress adresse =
                    new InetSocketAddress(ip, 5000);

            Socket socket = new Socket();
            socket.connect(adresse);

            System.out.println("Client connecte au serveur !");

            DataInputStream in =
                    new DataInputStream(socket.getInputStream());
            DataOutputStream out =
                    new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            int choix;

            do {
                System.out.println("\n--- CALCULATRICE ---");
                System.out.println("1. Addition (x + 5)");
                System.out.println("2. Soustraction (x - 5)");
                System.out.println("3. Multiplication (x * 5)");
                System.out.println("4. Division (x / 5)");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");

                choix = scanner.nextInt();
                out.writeInt(choix);
                out.flush();

                if (choix >= 1 && choix <= 4) {
                    System.out.print("Donner la valeur de x : ");
                    double x = scanner.nextDouble();

                    out.writeDouble(x);
                    out.flush();

                    String resultat = in.readUTF();
                    System.out.println("Resultat : " + resultat);
                } else if (choix != 0) {
                    System.out.println("Choix invalide !");
                }

            } while (choix != 0);

            socket.close();
            scanner.close();
            System.out.println("Client deconnecte.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
