package com.mordechay.miluim270818.Chat;

import java.util.Date;

public class ChatDataObject {
    private int imgChatPerson;
    private int txtChatUserName;
    private String txtChatContent;
    private Date txtChatItemDate;

//    public ChatDataObject(int imgChatPerson, int txtChatUserName, String txtChatContent, Date txtChatItemDate) {
//        this.imgChatPerson = imgChatPerson;
//        this.txtChatUserName = txtChatUserName;
//        this.txtChatContent = txtChatContent;
//        this.txtChatItemDate = txtChatItemDate;
//    }
    public ChatDataObject(int imgChatPerson, int txtChatUserName, Date txtChatItemDate) {
        this.imgChatPerson = imgChatPerson;
        this.txtChatUserName = txtChatUserName;
        this.txtChatItemDate = txtChatItemDate;
    }

    public int getImgChatPerson() {
        return imgChatPerson;
    }

    public void setImgChatPerson(int imgChatPerson) {
        this.imgChatPerson = imgChatPerson;
    }

    public int getTxtChatUserName() {
        return txtChatUserName;
    }

    public void setTxtChatUserName(int txtChatUserName) {
        this.txtChatUserName = txtChatUserName;
    }

    public String getTxtChatContent() {
        return txtChatContent;
    }

    public void setTxtChatContent(String txtChatContent) {
        this.txtChatContent = txtChatContent;
    }

    public Date getTxtChatItemDate() {
        return txtChatItemDate;
    }

    public void setTxtChatItemDate(Date txtChatItemDate) {
        this.txtChatItemDate = txtChatItemDate;
    }
}
