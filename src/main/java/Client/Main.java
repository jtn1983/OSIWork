package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8081;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(in.readLine());
            String name = scanner.nextLine();
            out.println(name);
            System.out.println(in.readLine());
            String child = scanner.nextLine();
            out.println(child);
            String resp = in.readLine();
            System.out.println(resp);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
