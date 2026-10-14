
package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("192.168.31.17");
            InetSocketAddress adresse =
                    new InetSocketAddress(ip, 5000);

            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(adresse);

            System.out.println("Serveur en attente d'un client...");
            System.out.println("Adresse IP : " + ip.getHostAddress());

            Socket socket = serverSocket.accept();
            System.out.println("Client connecte !");

            DataInputStream in =
                    new DataInputStream(socket.getInputStream());
            DataOutputStream out =
                    new DataOutputStream(socket.getOutputStream());

            boolean continuer = true;

            while (continuer) {
                int operation = in.readInt();

                if (operation == 0) {
                    continuer = false;
                } else {
                    double x = in.readDouble();
                    double resultat = 0;

                    switch (operation) {
                        case 1:
                            resultat = x + 5;
                            break;
                        case 2:
                            resultat = x - 5;
                            break;
                        case 3:
                            resultat = x * 5;
                            break;
                        case 4:
                            if (x == 0) {
                                out.writeUTF("Erreur : division par zero !");
                                out.flush();
                                continue;
                            }
                            resultat = x / 5;
                            break;
                        default:
                            out.writeUTF("Operation invalide !");
                            out.flush();
                            continue;
                    }

                    out.writeUTF(String.valueOf(resultat));
                    out.flush();
                    System.out.println("Resultat : " + resultat);
                }
            }

            socket.close();
            serverSocket.close();
            System.out.println("Serveur arrete.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
