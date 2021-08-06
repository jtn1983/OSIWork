package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 8081;
        try (ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

           out.println("Write your name: ");
           String name = in.readLine();
           out.println(("Are you child (yes/no)"));
           String child = in.readLine();
           String message = "";
           if (child.equals("yes")) {
               message = "child";
           } else {
               message = "adult";
           }
           out.println(String.format("Hi %s, Welcome to %s zone", name, message));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
