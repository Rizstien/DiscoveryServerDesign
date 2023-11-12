package com.discoveryserver.io.server;

import com.discoveryserver.io.cache.Cache;
import com.discoveryserver.io.domain.ServiceMetaData;
import com.discoveryserver.io.exception.ClusterNotFoundException;

import java.util.List;

public final class DefaultDiscoveryServer implements DiscoveryServer {

    private static Cache cache;

    public DefaultDiscoveryServer(Cache cache) {
        this.cache = cache;
    }


    @Override
    public void registerService(ServiceMetaData metaData) {
        cache.put(metaData.clusterID(), metaData);
    }

    @Override
    public List<ServiceMetaData> fetchService(long clusterID) {
        if(cache.contains(clusterID))
            return cache.getCluster(clusterID);
        else
            throw new ClusterNotFoundException("Cluster not found for clusterID "+clusterID);
    }

    @Override
    public void removeService(ServiceMetaData metaData) {
        cache.remove(metaData);
    }

    @Override
    public boolean checkHeartBeat(ServiceMetaData metaData) {
        return true;
    }
}
