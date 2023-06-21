package com.bigdeal.incheonerang.matching.dto;

public class LocationDTO {

    private int matchingCode;
    private int locationCode;
    private String locationName;
    private int locationCount;

    public LocationDTO() {}

    public LocationDTO(int matchingCode, int locationCode, String locationName, int locationCount) {
        this.matchingCode = matchingCode;
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.locationCount = locationCount;
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "matchingCode=" + matchingCode +
                ", locationCode=" + locationCode +
                ", locationName='" + locationName + '\'' +
                ", locationCount=" + locationCount +
                '}';
    }

    public int getMatchingCode() {
        return matchingCode;
    }

    public void setMatchingCode(int matchingCode) {
        this.matchingCode = matchingCode;
    }

    public int getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocationCount() {
        return locationCount;
    }

    public void setLocationCount(int locationCount) {
        this.locationCount = locationCount;
    }
}
