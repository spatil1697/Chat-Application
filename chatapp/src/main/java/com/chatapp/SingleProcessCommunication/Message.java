package com.chatapp.SingleProcessCommunication;

/**
 * The Message class represents a message with its content and the number of times it has been sent.
 * It provides methods to retrieve the message content and the associated count.
 */

public class Message {
    private String content;
    private int count;

    public Message(String content, int count) {
        this.content = content;
        this.count = count;
    }

    public String getContent (){
        return content;
    }

    public int getCount(){
        return count;
    }
}
