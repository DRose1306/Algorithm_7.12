package HW_2023_12_14;

import java.util.Arrays;
import java.util.Scanner;

public class HW_2023_12_14 {
    public static void main(String[] args) {
//Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент, который будет
//находиться на k-й позиции в конечном отсортированном массиве.
//Массив 1
//Массив 2
//к=7
//- 100 112 256 349 770
//- 72 86 113 119 265 445 892
//Вывод : 256

        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        int[] mergeArr = arrayMerge(arr1, arr2);
        System.out.println("Новый массив до сортировки: " + Arrays.toString(mergeArr) + "\n");

        int[] newMergeArr = quickSort(mergeArr, 0, mergeArr.length - 1);
        System.out.println("Новый уже отсортированный массив: " + Arrays.toString(newMergeArr) + "\n");

        System.out.println("Какой по счету элемент массива вы хотите получить?");
        System.out.println("Введите k, где k желаемый элемент");
        int k = new Scanner(System.in).nextInt();

        getElement(newMergeArr, k);


    }

    /*** слияние массива в один новый ***/
    public static int[] arrayMerge(int[] m, int[] n) {
        int[] newArr = new int[m.length + n.length];

        /*for (int i = 0; i < m.length; i++) {
            newArr[i] = m[i];
        }
        for (int i = 0; i < n.length; i++) {  //после того как записал два массива в новый, подумал что тут O(n^2) решил погуглить, а как еще можно слить 2 массива. До этого не знал про Systen.arraycopy
            newArr[m.length + i] = n[i];
        }
        Arrays.sort(newArr);
        return newArr;*/

        System.arraycopy(m, 0, newArr, 0, m.length);
        System.arraycopy(n, 0, newArr, m.length, n.length);
        //Arrays.sort(newArr); можно сразу вернуть массив уже отсортированным, но думая двруг в задачу входит сортировка именно прописанным методом решил его сюда добавить. Хотя и просто усложняю задачу.
        return newArr;
    }

    /*** получаем элемент на k-й позиции ***/
    public static void getElement(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            if (k - 1 == i) {
                System.out.println("k-й элемент в массиве, число: " + array[i]);
            }
        }
    }

    /*** сортировка нового массива ***/
    public static int[] quickSort(int[] array, int start, int end) {
        if (start < end) {
            int indexPivot = partition(array, start, end);
            quickSort(array, start, indexPivot - 1);
            quickSort(array, indexPivot + 1, end);
        }
        return array;
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int indexPivot = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {

                swap(array, i, indexPivot);
                indexPivot++;
            }
        }
        swap(array, end, indexPivot);
        return indexPivot;
    }

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}

