package com.company.entity;

public class Theatre {

    private Long theatreId;
    private String theatreName;
    private String city;
    private String locality;

    public Theatre(Long theatreId, String theatreName, String city, String locality) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.city = city;
        this.locality = locality;
    }


    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
}
