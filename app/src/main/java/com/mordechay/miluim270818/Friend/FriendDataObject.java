package com.mordechay.miluim270818.Friend;


public class FriendDataObject {
    private int imgFriendPerson,txtFriendDuty,txtFriendName,txtFriendTel;

    public FriendDataObject(int imgFriendPerson, int txtFriendduty, int txtFriendName, int txtFriendTel) {
        this.imgFriendPerson = imgFriendPerson;
        this.txtFriendDuty = txtFriendduty;
        this.txtFriendName = txtFriendName;
        this.txtFriendTel = txtFriendTel;
    }

    public int getImgFriendPerson() {
        return imgFriendPerson;
    }

    public void setImgFriendPerson(int imgFriendPerson) {
        this.imgFriendPerson = imgFriendPerson;
    }

    public int getTxtFriendDuty() {
        return txtFriendDuty;
    }

    public void setTxtFriendDuty(int txtFriendduty) {
        this.txtFriendDuty = txtFriendduty;
    }

    public int getTxtFriendName() {
        return txtFriendName;
    }

    public void setTxtFriendName(int txtFriendName) {
        this.txtFriendName = txtFriendName;
    }

    public int getTxtFriendTel() {
        return txtFriendTel;
    }

    public void setTxtFriendTel(int txtFriendTel) {
        this.txtFriendTel = txtFriendTel;
    }
}