package com.discoveryserver.io.domain;

import java.util.Objects;

public record ServiceMetaData (long clusterID, String name, String IP, Integer port, String healthURL, long lastHealthCheck) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceMetaData that = (ServiceMetaData) o;
        return clusterID == that.clusterID && Objects.equals(name, that.name) && Objects.equals(IP, that.IP) && Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clusterID, name, IP, port);
    }

    @Override
    public String toString() {
        return "ServiceMetaData{" +
                "clusterID=" + clusterID +
                ", name='" + name + '\'' +
                ", IP='" + IP + '\'' +
                ", port=" + port +
                ", healthURL='" + healthURL + '\'' +
                ", lastHealthCheck=" + lastHealthCheck +
                '}';
    }
}
