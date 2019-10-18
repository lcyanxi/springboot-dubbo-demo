package com.lcyanxi.worker.algorithm;

import lombok.Data;

import java.util.HashMap;

/**
 * LRU算法实现
 * Created by lichang on 2019/10/18
 */
public class LruCache {
    private Node head;
    private Node end;
    private int limit ;
    private HashMap<Object,Node> hashMap;

    public LruCache(int limit){
        this.limit=limit;
        this.hashMap=new HashMap<>();
    }

    /**
     * 添加数据
     * @param key key值
     * @param value value值
     */
    public void put(Object key,Object value){
        Node node=hashMap.get(key);
        //判断缓存里是否有这个数据
        if (node == null){
            //判断缓存容器是否够用
            if (hashMap.size()>=limit){
                hashMap.remove(head.getKey());
                head=head.getNext();
            }
            Node nowNode=new Node(key,value);

            if (head == null && end == null){
                head=nowNode;
                end=nowNode;
            }else {
                end.setNext(nowNode);
                nowNode.setPre(end);
                nowNode.setNext(null);
                end=nowNode;
            }
            hashMap.put(key,nowNode);
        }else {
            // 判断是否尾结点
            node.setValue(value);

            if (node == end){
                return;
            } else if (node == head){
                head=head.getNext();
            }else {
                node.getPre().setNext(node.getNext());
                node.getNext().setPre(node.getPre());
            }
            //更新节点到尾部
            end.setNext(node);
            node.setPre(end);
            node.setNext(null);
            end=node;
            hashMap.put(key,node);
        }
    }

    public Object get(Object key){
        Node node=hashMap.get(key);
        if (node == null){
            return null;
        }
        if (node == end){
            return node.getValue();
        }
        if (node==head){
            head=head.getNext();
        }else {
            node.getPre().setNext(node.getNext());
            node.getNext().setPre(node.getPre());
        }

        //更新节点到尾部
        end.setNext(node);
        node.setPre(end);
        node.setNext(null);
        end=node;
        return node.getValue();
    }

    public static void main(String[] args) {
        LruCache lruCache=new LruCache(5);
        lruCache.put("001","用户1信息");
        lruCache.put("002","用户2信息");
        lruCache.put("003","用户3信息");
        lruCache.put("004","用户4信息");
        lruCache.put("005","用户5信息");
        lruCache.put("006","用户6信息");
        System.out.println("第一个节点:"+lruCache.head.getValue());
        System.out.println("最后一个节点:"+lruCache.end.getValue());
        lruCache.get("004");
        System.out.println("第一个节点:"+lruCache.head.getValue());
        System.out.println("最后一个节点:"+lruCache.end.getValue());


    }

}

@Data
class Node{
    private Node pre;
    private Node next;
    private Object key;
    private Object value;

    public Node(Object key,Object value){
        this.key=key;
        this.value=value;
    }
}