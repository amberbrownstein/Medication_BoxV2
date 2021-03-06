package com.example.medicationbox;

import java.util.ArrayList;
import java.util.HashMap;
import android.graphics.Bitmap;

public class User{

    private String name;
    private String email;
    private ArrayList<Payment> pmt;
    private String userUID;
    private ArrayList<Perscription> perscriptions;
    private Insurance insurance;
    private ArrayList<Box> shipments;
    private String password;
    private HashMap<String, Bitmap> pictures;

    public User(){}

    public User(String name, String email, String password, String userUID)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userUID = userUID;
        this.perscriptions = new ArrayList<>();
        this.pictures = new HashMap<String, Bitmap>();
        shipments = new ArrayList<>();
        pmt = new ArrayList<>();
        shipments.add(new Box(0));
	}

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() {
        return name;
    }

    public String getEmail() { return email; }

    public String getUID() { return userUID; }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Perscription getPerscription(String medName) {
        for (Perscription p : perscriptions) {
            if (medName.equals(p.getMedName())) {
                return p;
            }
        }
        return null;
    }

    public Box getBox(int i){
        return shipments.get(i);
    }

    public ArrayList getPmts(){
        return pmt;
    }

    public void addPmt(Payment p){
        pmt.add(p);
    }

    public Payment removePmt(int i){
        return pmt.remove(i);
    }

    public void addPerscription(Perscription perscription) {
        perscriptions.add(perscription);
    }

    public boolean removePerscription(String medName) {
        return perscriptions.remove(medName);
    }

    public HashMap<String, Bitmap> getPictures() {
        return pictures;
    }

    public void setPictures(HashMap<String, Bitmap> pictures) {
        this.pictures = pictures;
    }

    public Bitmap addPicture(String picID, Bitmap picture) {
        pictures.put(picID, picture);
        return pictures.get(picID);
    }

    public Bitmap getPicture(String picID) {
        return pictures.get(picID);
    }

    public Bitmap removePicture(String picID) {
        return pictures.remove(picID);
    }

    public Bitmap changePicture(String picID, Bitmap picture) {
        pictures.put(picID, picture);
        return pictures.get(picID);
    }
}
