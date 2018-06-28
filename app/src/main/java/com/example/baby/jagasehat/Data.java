package com.example.baby.jagasehat;

/**
 * Created by FZulfikar on 6/2/2018.
 */

public class Data {

    String userID;
    String jkUser;
    String usiaUser;
    String tpUser;
    String kerjaUser;
    String emailUser;

    public Data(){

    }

    public Data(String userID, String jkUser, String usiaUser, String tpUser, String kerjaUser, String emailUser) {
        this.userID = userID;
        this.jkUser = jkUser;
        this.usiaUser = usiaUser;
        this.tpUser = tpUser;
        this.kerjaUser = kerjaUser;
        this.emailUser = emailUser;
    }

    public String getUserID() {
        return userID;
    }

    public String getJkUser() {
        return jkUser;
    }

    public String getUsiaUser() {
        return usiaUser;
    }

    public String getTpUser() {
        return tpUser;
    }

    public String getKerjaUser() {
        return kerjaUser;
    }

    public String getEmailUser() {
        return emailUser;
    }
}
