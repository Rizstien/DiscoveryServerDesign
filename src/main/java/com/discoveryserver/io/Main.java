package com.discoveryserver.io;

import com.discoveryserver.io.cache.Cache;
import com.discoveryserver.io.cache.MetaDataCache;
import com.discoveryserver.io.domain.ServiceMetaData;
import com.discoveryserver.io.server.DefaultDiscoveryServer;
import com.discoveryserver.io.server.DiscoveryServer;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        Cache cache = new MetaDataCache(new ConcurrentHashMap<Long, List<ServiceMetaData>>());

        DiscoveryServer discoveryServer = new DefaultDiscoveryServer(cache);

        discoveryServer.registerService(new ServiceMetaData(1,
                "s1",
                "127.0.0.1",
                32,
                "https://test",
                39192091));


        discoveryServer.registerService(new ServiceMetaData(1,
                "s2",
                "127.0.0.1",
                32,
                "https://test",
                39192091));


        discoveryServer.registerService(new ServiceMetaData(2,
                "s3",
                "127.0.0.1",
                32,
                "https://test",
                39192091));


        System.out.println(discoveryServer.fetchService(1));
    }
}