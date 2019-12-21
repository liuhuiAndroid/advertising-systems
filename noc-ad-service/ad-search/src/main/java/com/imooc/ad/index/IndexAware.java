package com.imooc.ad.index;

/**
 * 索引的增删改查
 *
 * @param <K>
 * @param <V>
 */
public interface IndexAware<K, V> {

    V get(K key);

    void add(K key, V v);

    void update(K key, V v);

    void delete(K key, V v);

}
