package com.lcyanxi.worker.algorithm;

/**
 * 给定无序数组移除一个数使得留下的乘积最大
 * @linke(https://mp.weixin.qq.com/s/Ct5AxXCuDhyHCg7ykCg1kQ)
 * Created by lichang on 2019/10/29
 */
public class MultiplyMax {

    public static void main(String[] args) {
        int[] arr =new int[]{4,3,5,-7,-21,9,-1,-5,6,0};
        int index=findRemoveIndex(arr);
        System.out.println("删除下标元素："+arr[index]);
    }

    private static int findRemoveIndex(int[] arr){
        //标记小于零的个数
        int num=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<=0){
                num++;
            }
        }
        System.out.println("num:"+num);
        int index=0;
        if ((num & 1) == 0){
            //偶数个负数
            if (num==arr.length){
                //所有元素都是负数
                for (int i=0;i<arr.length;i++){
                    if (arr[index]<arr[i]){
                        index=i;
                    }
                }
                return index;
            }else {
                for (int i=0;i<arr.length;i++){
                    if (arr[index]<0 || arr[index]<arr[i]){
                        index=i;
                    }
                }
                return index;
            }
        }else {
            //基数个负数
            for (int i=0;i<arr.length;i++){
                if (arr[i]<=0){
                    if (arr[index]>0 || arr[i]>arr[index]){
                        index=i;
                    }
                }
            }
            return index;
        }

    }
}
