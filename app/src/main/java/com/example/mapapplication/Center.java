package com.example.mapapplication;

public class Center {

    private String name;
    private double lng;
    private double lan;
    private boolean appt;

    public Center(double lan, double lng, String name, boolean appt) {

        this.lng = lng;
        this.lan = lan;
        this.name = name;
        this.appt = appt;

    }

    public boolean requiresAppt() {
        return appt;
    }

    public double getLan() {
        return lan;
    }

    public String getname() {
        return name;
    }


    public double getLng() {
        return lng;
    }


}
