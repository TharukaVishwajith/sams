package com.uok.sams.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "location")
public class Location extends BaseEntity{

    private String faculty;

    private String name;

    private double lat;

    private double lon;

    @OneToMany(mappedBy = "location")
    private List<QRClient> qrClients;

//    Building ID
    @Column(name = "location_code")
    private String locationCode;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QRClient> getQrClients() {
        return qrClients;
    }

    public void setQrClients(List<QRClient> qrClients) {
        this.qrClients = qrClients;
    }
}
