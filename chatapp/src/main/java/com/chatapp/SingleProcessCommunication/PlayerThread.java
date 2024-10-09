package com.chatapp.SingleProcessCommunication;

/**
 * The PlayerThread class extends the Thread class and represents a separate thread 
 * that sends an initial message from a Player. 
 */

public class PlayerThread extends Thread {
    
    private Player player;
    private String initialMessage;

    public PlayerThread(Player player, String initialMessage){
        this.player = player;
        this.initialMessage = initialMessage;
    }

    @Override
    public void run() {
        player.sendMessage(initialMessage);
    }
}
