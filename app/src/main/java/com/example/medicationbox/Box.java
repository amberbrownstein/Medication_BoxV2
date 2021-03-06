package com.example.medicationbox;

import java.util.ArrayList;
import java.util.Calendar;

public class Box {
    public ArrayList<Perscription> products = new ArrayList<>();
    private Calendar shipmentDate;

    public Box(int i){
        if(i == 0){
            shipmentDate = Calendar.getInstance();
        }
        /*else {
            Calendar earliest = usr.shipments.get(usr.shipments.size() - 1).shipmentDate;
            earliest.add(Calendar.DATE, Integer.parseInt(usr.perscriptions.get(0).getQuantity()));
            shipmentDate = earliest;
        }*/
    }

    public void addMed(Perscription p){
        products.add(p);
    }

    public Perscription removeMed(int i){
        return products.remove(i);
    }

    public void changeDate(Calendar c){
        shipmentDate = c;
    }
}
