package clientserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 4711);
            OutputStream os = clientSocket.getOutputStream();

            Scanner keyboardScanner = new Scanner(System.in);
            String input = keyboardScanner.nextLine();

            while (!input.isEmpty()) {
                os.write((input + "\n").getBytes());
                input = keyboardScanner.nextLine();
            }

            os.close();

        } catch (IOException ioe) {
            System.out.println("Er ging iets mis bij het versturen van een bericht!");
            ioe.printStackTrace();
        }
    }
}
