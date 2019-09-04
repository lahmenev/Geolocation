package com.restapi.example.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Entity
@Table(name = "geolocation")
public class GeolocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "osm_type")
    private String osmType;
    @Column(name = "osm_id")
    private int osmId;
    private double latitute;
    private double lon;
    @Column(name = "display_name")
    private String displayName;
    @Embedded
    private AddressEntity addressEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOsmType() {
        return osmType;
    }

    public void setOsmType(String osmType) {
        this.osmType = osmType;
    }

    public int getOsmId() {
        return osmId;
    }

    public void setOsmId(int osmId) {
        this.osmId = osmId;
    }

    public double getLatitute() {
        return latitute;
    }

    public void setLatitute(double latitute) {
        this.latitute = latitute;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeolocationEntity that = (GeolocationEntity) o;
        return id == that.id &&
                osmId == that.osmId &&
                Double.compare(that.latitute, latitute) == 0 &&
                Double.compare(that.lon, lon) == 0 &&
                Objects.equals(osmType, that.osmType) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(addressEntity, that.addressEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, osmType, osmId, latitute, lon, displayName, addressEntity);
    }
}
