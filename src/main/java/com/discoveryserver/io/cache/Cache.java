package com.discoveryserver.io.cache;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public sealed interface Cache<K, V> permits MetaDataCache {

    void put(K key, V value);
    void remove(K key);
    List<V> getCluster(K key);
    boolean contains(K key);
}
