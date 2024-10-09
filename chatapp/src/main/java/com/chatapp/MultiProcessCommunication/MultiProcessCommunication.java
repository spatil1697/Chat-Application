package com.chatapp.MultiProcessCommunication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The MultiProcessCommunication class sets up a server socket for inter-process communication between two players.
 * It creates sockets for both players, initializes them and starts their communication in separate threads.
 */

public class MultiProcessCommunication {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12346);

        Socket player1Socket = new Socket("localhost", 12346);
        Socket player2Socket = serverSocket.accept();

        Player player1 = new Player(player1Socket, true);
        Player player2 = new Player(player2Socket, false);

        new Thread(player1).start();
        new Thread(player2).start();

        serverSocket.close();
    }
    
}
