package com.example.kkdemo_version1.Model;

public class Relation {

    // Two-way relation
    // First user id
    private long firstId;
    // Second user id
    private long secondId;
    // Relation status active,blocked,
    private int type;

    // Constructor
    public void Relation(){

    }

    // region Getter Setter  ************************************************************

    public long getFirstId() {
        return firstId;
    }

    public void setFirstId(long firstId) {
        this.firstId = firstId;
    }

    public long getSecondId() {
        return secondId;
    }

    public void setSecondId(long secondId) {
        this.secondId = secondId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    // region End of Getter Setter  *****************************************************


}
