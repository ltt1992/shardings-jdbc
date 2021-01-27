package com.gogonew.tes;

public class MyHashMap<K,V> {

    private static final int DEFAULT_SIZE = 1<< 4;//16 2的整数次幂 ，为了减少hash冲突
    private Entry<K,V>[] data;
    private int size = 0;//存了多少个数
    private int cap;//初始化空间

    public MyHashMap(){
        this(DEFAULT_SIZE);
    }

    public MyHashMap(int cap){
        if(cap > 0){
            data = new Entry[cap];
            size = 0;
            this.cap = cap;
        }else {

        }
    }

    public void put(K key,V value){
        //key value enable null
        int hash = hash(key);
        Entry<K,V> newE = new Entry<>(key,value,null);
        Entry<K, V> hashM = data[hash];
        while (hashM != null){
            if(hashM.key.equals(key)){
                hashM.value = value;
                return;
            }
            hashM = hashM.next;
        }
        newE.next = data[hash];
        data[hash] = newE;
        size++;
    }

    public V get(K key){
        int hash = hash(key);
        Entry<K,V> e = data[hash];
        while (e != null){
            if (e.key.equals(key)){
                return e.value;
            }
            e = e.next;
        }
        return null;
    }


    private int hash(K key){
        int h = 0;
        if(key == null) h = 0;
        else h = key.hashCode() ^ (h >>> 16);
        return h % cap;
    }




    private class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        int cap;
        public Entry(K key,V value,Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String,Object> myHashMap = new MyHashMap<>();
        myHashMap.put("1","1");
        System.out.println(myHashMap.get("1"));
    }
}
