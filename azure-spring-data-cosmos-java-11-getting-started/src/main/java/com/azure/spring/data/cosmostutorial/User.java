// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.data.cosmostutorial;

import com.azure.core.models.GeoPoint;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "myContainer", ru = "400")
public class User {
    private String id;
    private String firstName;
    private Integer mmsi;
    private GeoJsonPoint location;


    @PartitionKey
    private String lastName;

    public User() {}

    public User(String id, String firstName, String lastName, Integer mmsi, GeoJsonPoint location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mmsi = mmsi;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("User: %s %s, %s, %d", firstName, lastName, id, mmsi);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getMmsi() {
        return this.mmsi;
    }

    public void setMmsi(Integer mmsi) {
        this.mmsi = mmsi;
    }

    public GeoJsonPoint getLocation() {
        return this.location;
    }

    public void setLocation(GeoJsonPoint point) {
        this.location = point;
    }
}

