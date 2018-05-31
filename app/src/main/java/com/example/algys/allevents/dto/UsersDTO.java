package com.example.algys.allevents.dto;

import android.provider.ContactsContract;

import java.net.PasswordAuthentication;
import java.util.Date;

public class UsersDTO {
    private long id;
    private String name;
    private String surname;
    private Date birthday;
    private ContactsContract.CommonDataKinds.Email email;
    private ContactsContract.CommonDataKinds.Phone phone;
    private PasswordAuthentication password;

    public UsersDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ContactsContract.CommonDataKinds.Email getEmail() {
        return email;
    }

    public void setEmail(ContactsContract.CommonDataKinds.Email email) {
        this.email = email;
    }

    public ContactsContract.CommonDataKinds.Phone getPhone() {
        return phone;
    }

    public void setPhone(ContactsContract.CommonDataKinds.Phone phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public PasswordAuthentication getPassword() {
        return password;
    }

    public void setPassword(PasswordAuthentication password) {
        this.password = password;
    }
}
