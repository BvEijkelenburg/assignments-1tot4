package myservlet;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MyServlet extends Thread {
    private Socket socket;

    public MyServlet(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream is = socket.getInputStream();

            Path file = null;
            Scanner sc = new Scanner(is);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if (line.startsWith("GET")) {
                    String resource = line.substring(4, line.lastIndexOf(" "));
                    file = Path.of("files" + resource);
                }
                System.out.println(line);
                if (line.equals("")) {
                    break;
                }
            }

            OutputStream os = socket.getOutputStream();
            os.write("HTTP/1.1 200 OK\r\n".getBytes());
            os.write("\r\n".getBytes());

            if (file != null && Files.exists(file)) {
                Files.copy(file, os);
            } else {
                os.write("<h1>File not found!</h1>".getBytes());
            }

            os.close();
            is.close();
            sc.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Er ging iets mis bij het afhandelen van dit request!");
        }
    }

}
