package com.discoveryserver.io.cache;

import com.discoveryserver.io.domain.ServiceMetaData;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public non-sealed class MetaDataCache implements Cache<Long, ServiceMetaData>{

    ConcurrentHashMap<Long, List<ServiceMetaData>> cache;

    public MetaDataCache(ConcurrentHashMap<Long, List<ServiceMetaData>> cache) {
        this.cache = cache;
    }

    @Override
    public void put(Long key, ServiceMetaData value) {
        this.cache.computeIfAbsent(key, k-> new CopyOnWriteArrayList<>()).add(value);
    }

    @Override
    public void remove(Long key) {
        this.cache.remove(key);
    }

    @Override
    public List<ServiceMetaData> getCluster(Long key) {
        return this.cache.get(key);
    }

    @Override
    public boolean contains(Long key) {
        return cache.containsKey(key);
    }

}
