package com.lcyanxi.worker.algorithm;

/**
 * 通过最小堆寻找无序数组中第K大元素
 * Created by lcyanxi on 2019/10/27
 * @linke(https://mp.weixin.qq.com/s/LKrxeFT9S5NEAHlhHI3nSQ)
 */

public class HeapOperatorFindTopN {
    public static void main(String[] args) {
        int findKey = 3;
        int[] arr = new int[]{7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8};
        buildHeapBySize(arr, findKey);
        for (int k = findKey; k < arr.length; k++) {
            if (arr[0] < arr[k]) {
                arr[0] = arr[k];
                downAdjust(arr, 0, findKey);
            }
        }
        //输出堆顶元素
        System.out.println(arr[0]);
    }

    /**
     * 构建堆
     * @param arr  源数据
     * @param size 堆长度
     */
    private static void buildHeapBySize(int[] arr, int size) {
        if (size < 0 || size > arr.length) {
            return;
        }
        //最后一个非叶子节点依次下沉调整
        for (int parentIndex = (size - 2) / 2; parentIndex >= 0; parentIndex--) {
            downAdjust(arr, parentIndex, size);
        }
    }

    /**
     * 下沉调整
     * @param arr 源数据
     * @param parentIndex 父节点
     * @param length  堆长度
     */
    private static void downAdjust(int[] arr, int parentIndex, int length) {
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && arr[childIndex + 1] < arr[childIndex]) {
                childIndex++;
            }
            if (temp <= arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        arr[parentIndex] = temp;
    }
}