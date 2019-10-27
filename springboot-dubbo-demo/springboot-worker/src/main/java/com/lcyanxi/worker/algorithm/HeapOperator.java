package com.lcyanxi.worker.algorithm;

import java.util.Arrays;

/**
 * 二叉堆算法（最小堆）
 * Created by lcyanxi on 2019/10/27
 */

public class HeapOperator {
    public static void main(String[] args) {
        int[] arry=new int[] {7,1,3,10,5,2,8,9,6};
        buildHeap(arry);
        System.out.println("arry:"+ Arrays.toString(arry));

    }


    /**
     * 构建二叉堆
     * @param arry  源数据
     */
    private static void buildHeap(int[] arry){
        int length=arry.length-1;
       //从最后一个非叶子节点开始遍历
        for (int parentIndex=(arry.length/2)-1;parentIndex>=0;parentIndex--){
            // 父节点数据
            int temp =arry[parentIndex];
            //父节点的左孩子节点
            int childIndex=2*parentIndex+1;
            while (childIndex<=length){
                if (arry[childIndex+1]<arry[childIndex] && childIndex+1<=length){
                    childIndex++;
                }
                //如果父节点小于子节点直接跳出
                if (temp<arry[childIndex]){
                    break;
                }
                arry[parentIndex]=arry[childIndex];
                parentIndex=childIndex;
                childIndex=2*parentIndex+1;
            }
            arry[parentIndex]=temp;
        }
    }
}
