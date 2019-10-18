package com.lcyanxi.worker.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lichang on 2019/10/18
 */
public class LinkedHashMapLru {

    private int limit ;
    private LinkedHashMap<Object,Object> hashMap;

    public LinkedHashMapLru(int limit) {
        this.limit = limit;
        this.hashMap = new LinkedHashMap<Object, Object>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if (limit+1>hashMap.size()){
                    return true;
                }else {
                    return false;
                }
            }
        };
    }

    public void put(Object key,Object value){
            hashMap.put(key,value);
    }

    public Object get(Object key){
        return hashMap.get(key);
    }

    public void print(){
        for (Map.Entry<Object,Object> entry: hashMap.entrySet()) {
            System.out.print(entry.getValue()+"--");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedHashMapLru lruCache=new LinkedHashMapLru(5);
        lruCache.put("001","用户1信息");
        lruCache.put("002","用户2信息");
        lruCache.put("003","用户3信息");
        lruCache.put("004","用户4信息");
        lruCache.put("005","用户5信息");
        lruCache.print();
        lruCache.put("006","用户6信息");
        lruCache.print();
        lruCache.get("004");
        lruCache.print();


    }
}
