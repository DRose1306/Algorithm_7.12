package HW_2024_01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level1 {
    //Level 1
    //У вас есть список из n элементов, которые представляют собой оценки студентов по математике.
    // Вам нужно отсортировать этот список в порядке убывания оценок с использованием алгоритма сортировки Merge sort.
    // Для решения этой задачи напишите функцию, которая принимает на вход список оценок и возвращает новый список,
    // отсортированный в порядке убывания.
    //{ 3, 8, 1, 9, 4, 2, 7, 6, 5 };
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 9, 4, 2, 7, 6, 5};
        System.out.println("Given Array");
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(array));

    }

    private static void mergeSort(int[] arr) {
        int lengthArr = arr.length; // длина массива

        if (lengthArr == 1) { // условие выхода
            return;
        }

        int mid = lengthArr / 2;
        int[] leftArr = new int[mid]; // левый подмассив
        int[] rightArr = new int[lengthArr - mid]; // правый подмассив

// копируем элементы из массива в подмассивы
        for (int i = 0; i < mid; ++i) {
            leftArr[i] = arr[i];
        }
        for (int j = 0; j < lengthArr - mid; ++j) {
            rightArr[j] = arr[j + mid];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);
// когда достигли базового условия, начинаем слияние
        merge(arr, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftArrLength = leftArr.length;
        int rightArrLength = rightArr.length;
// контролируем индексы подмассивов
        int leftIndex = 0;
        int rightIndex = 0;
// контролируем индекс в основном массиве
        int arrIndex = 0;

        while (leftIndex < leftArrLength && rightIndex < rightArrLength) {
            if (leftArr[leftIndex] > rightArr[rightIndex]) { // сравниваем элемент в левом и правом подмассиве
                arr[arrIndex] = leftArr[leftIndex]; // если условие верно, то элемент в левом меньше, сохраняем его в 0 ячейку основного массива
                leftIndex++;
                arrIndex++;
            } else {
                arr[arrIndex] = rightArr[rightIndex];
                rightIndex++;
                arrIndex++;
            }
        }
// копируем элементы если остались из левого
        while (leftIndex < leftArrLength) {
            arr[arrIndex] = leftArr[leftIndex];
            leftIndex++;
            arrIndex++;
        }
// копируем элементы из правого
        while (rightIndex < rightArrLength) {
            arr[arrIndex] = rightArr[rightIndex];
            rightIndex++;
            arrIndex++;
        }
    }
}
