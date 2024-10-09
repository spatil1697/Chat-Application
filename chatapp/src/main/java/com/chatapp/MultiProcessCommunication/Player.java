package com.chatapp.MultiProcessCommunication;
import java.io.IOException;
import java.net.Socket;

/**
 * The Player class represents a participant in multi-process communication either as an initiator or a responder.
 * It handles sending and receiving messages through the NetworkManager and processing them with the MessageHandler.
 */

public class Player implements Runnable {
    private NetworkManager networkManager;
    private MessageHandler messageHandler;
    private boolean isInitiator;
    private static final int MAX_MESSAGES = 10;
    

    public Player(Socket socket, boolean isInitiator) throws IOException {
        this.networkManager = new NetworkManager(socket);
        this.messageHandler = new MessageHandler();
        this.isInitiator = isInitiator;
    }

    @Override
    public void run() {
        try {
            if (isInitiator) {
                // Start communication with the initial message
                String startingMessageToSend = "Hello from Initiator #1";
                System.out.println("Initiator sent: " + startingMessageToSend);
                networkManager.sendMessage(startingMessageToSend );
                int sentCount = 1;

                while (sentCount <= MAX_MESSAGES ) {
                    String response = networkManager.receiveMessage();
                    System.out.println("Initiator received: " + response);
    
                    if (sentCount < MAX_MESSAGES) {
                        String messageToSend = "Hello from Initiator #1";
                        for (int i = 2; i <= sentCount + 1; i++) {
                            messageToSend += " #" + i;
                        }
                        
                        String processMessageWithoutCounter = messageHandler.processMessageWithoutCounter(messageToSend);
                        networkManager.sendMessage(processMessageWithoutCounter);
                        System.out.println("Initiator sent: " + processMessageWithoutCounter);
                    }
                    sentCount++;
                }
                
                System.out.println("Initiator has sent and received 10 messages. Stopping.");
            } else {
                while (messageHandler.getMessageCounter() <= MAX_MESSAGES) {
                    String received = networkManager.receiveMessage();
                    System.out.println("Player 2 received: " + received);
                    String processedMessage = messageHandler.processMessage(received);
                    networkManager.sendMessage(processedMessage);
                    System.out.println("Player 2 sent: " + processedMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            networkManager.close();
        }
    }
}
