package com.discoveryserver.io.server;

import com.discoveryserver.io.domain.ServiceMetaData;
import com.discoveryserver.io.domain.ServiceMetaData;

import java.util.List;

public sealed interface DiscoveryServer permits DefaultDiscoveryServer {

    void registerService(ServiceMetaData metaData);
    List<ServiceMetaData> fetchService(long clusterID);
    void removeService(ServiceMetaData metaData);
    boolean checkHeartBeat(ServiceMetaData metaData);

}
