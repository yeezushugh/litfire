package com.example.kkdemo_version1.Model;

import java.sql.Timestamp;

public class Message {

    // Unique message id
    private long id;
    // Sender id
    private long senderId;
    // Receiver id
    private long receiverId;
    // Message type
    private int type;
    // Message content
    private String content;
    // Message set time
    private Timestamp setTime;
    // Message expire time
    private Timestamp expireTime;
    // Message send time
    private Timestamp sendTime;

    // Constructor
    public void Message(){

    }

    // region Getter Setter  ************************************************************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSetTime() {
        return setTime;
    }

    public void setSetTime(Timestamp setTime) {
        this.setTime = setTime;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }


    // region End of Getter Setter  *****************************************************

}
