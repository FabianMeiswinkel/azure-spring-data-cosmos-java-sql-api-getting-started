// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.data.cosmostutorial;

public class GeoJsonPoint {
    private double[] coordinates;
    protected String type;

    public GeoJsonPoint() {
        coordinates = new double[0];
        type = "POINT";
    }

    public GeoJsonPoint(double longitude, double latitude) {
        coordinates = new double[2];
        coordinates[0] = longitude;
        coordinates[1] = latitude;
        type = "Point";
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }
}
