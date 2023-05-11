package myservlet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4711);
        while (true) {
            Socket mySocket = serverSocket.accept();

            MyServlet ms = new MyServlet(mySocket);
            ms.start();

//            new MyServlet(mySocket).start();
        }
    }}
