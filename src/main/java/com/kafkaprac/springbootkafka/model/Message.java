package com.kafkaprac.springbootkafka.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    private String message;
    private int identifier;

    public Message() {
    }

    public Message(@JsonProperty("message") String message,
                   @JsonProperty("identifier") int identifier) {
        this.message = message;
        this.identifier = identifier;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", identifier=" + identifier +
                '}';
    }
}
