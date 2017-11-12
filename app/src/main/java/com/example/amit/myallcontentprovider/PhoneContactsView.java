package com.example.amit.myallcontentprovider;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Amit on 1/20/2017.
 */

public class PhoneContactsView {
    RecyclerView rvContactsView;

    public RecyclerView getRvContactsView() {
        return rvContactsView;
    }

    public void setRvContactsView(RecyclerView rvContactsView) {
        this.rvContactsView = rvContactsView;
    }

    public void setContactImagePic(int contactImagePic) {
        ContactImagePic = contactImagePic;
    }

    private int ContactImagePic;
    private String ContactName;
    private String ContactPhoneNumber;
    private String ContactEmailId;

    public String getContactEmailId() {
        return ContactEmailId;
    }

    public void setContactEmailId(String contactEmailId) {
        ContactEmailId = contactEmailId;
    }

    public String getContactPhoneNumber() {

        return ContactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        ContactPhoneNumber = contactPhoneNumber;
    }

    public String getContactName() {

        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public int getContactImagePic() {
        return ContactImagePic;
    }
}
