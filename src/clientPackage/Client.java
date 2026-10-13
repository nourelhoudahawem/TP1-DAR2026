package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try {
            System.out.println("Je suis un client pas encore connecté...");

            Socket socket = new Socket("192.168.31.16", 5000);

            System.out.println("Je suis un client connecté");

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}