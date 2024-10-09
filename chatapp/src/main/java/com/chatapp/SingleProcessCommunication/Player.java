package com.chatapp.SingleProcessCommunication;

/**
 * The Player class represents a player that can send and receive messages to/from another player.
 * It maintains a counter for the number of messages it has sent and received.
 */

 public class Player {
    private String name;
    private int messageCount = 0;
    private Player opponent;
    private boolean isInitiator;
    private static final int MAX_MESSAGES = 10;

    public Player(String name, boolean isInitiator) {
        this.name = name;
        this.isInitiator = isInitiator;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public void sendMessage(String content) {
        if (messageCount < MAX_MESSAGES) {
            messageCount++;
            if (isInitiator) {
                Message message = new Message(content + " #" + messageCount, messageCount);
                System.out.println(name + " sent: " + message.getContent());
                opponent.receiveMessage(message);    
            }else{
                Message message = new Message(content, messageCount);
                System.out.println(name + " sent: " + message.getContent() + " (Counter: " + message.getCount() + ")");
                opponent.receiveMessage(message);
            }
        }
    }

    public void receiveMessage(Message message) {
        if (!isInitiator) {
            System.out.println(name + " received: " + message.getContent());
        }else{
           
           System.out.println(name + " received: " + message.getContent() + " (Counter: " + message.getCount() + ")");
        }
        
        if (messageCount < MAX_MESSAGES) {
            sendMessage(message.getContent());
        } else if (isInitiator) {
            System.out.println(name + " has sent and received " + MAX_MESSAGES + " messages. Stopping.");
            System.exit(0);
        }
    }

    public int getMessageCount() {
        return messageCount;
    }
 }
