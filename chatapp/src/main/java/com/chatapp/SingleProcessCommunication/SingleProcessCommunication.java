package com.chatapp.SingleProcessCommunication;

/**
 * The Main class serves as the entry point to the program.
 * It creates two Player instances and starts their communication process.
 */

public class SingleProcessCommunication {
    
    public static void main(String[] args) {
        Player player1 = new Player("Initiator", true);
        Player player2 = new Player("Player 2", false);

        player1.setOpponent(player2);
        player2.setOpponent(player1);

        PlayerThread thread1 = new PlayerThread(player1, "Hello from Initiator");
        thread1.start();
    }
}