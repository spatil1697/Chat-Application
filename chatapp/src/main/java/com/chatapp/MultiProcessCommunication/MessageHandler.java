package com.chatapp.MultiProcessCommunication;

/**
 * The MessageHandler class manages message processing by appending a counter to messages.
 * It also provides functionality to process messages without modifying them and to track the message count.
 */

public class MessageHandler {
    private int messageCounter = 1; // Start at 1

    public String processMessage(String message) {
        String processedMessage = message + " (Count: " + messageCounter + ")";
        messageCounter++;
        return processedMessage;
    }
    
    public String processMessageWithoutCounter(String message) {
        return message;
    }

    public int getMessageCounter() {
        return messageCounter;
    }
}
