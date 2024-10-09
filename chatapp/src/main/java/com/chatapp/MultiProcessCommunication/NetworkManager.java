package com.chatapp.MultiProcessCommunication;
import java.io.*;
import java.net.*;

/**
 * The NetworkManager class handles network communication over a socket connection.
 * It provides methods to send and receive messages as well as to close the socket and its streams.
 */

public class NetworkManager {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public NetworkManager(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
