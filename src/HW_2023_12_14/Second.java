package HW_2023_12_14;

import java.nio.charset.StandardCharsets;

public class Second {
    public static void main(String[] args) {
        //Решите задачу: Расставьте в алфавитном порядке буквы. Разрешается
        //использование техники Разделяй и властвуй. Полученные данные напечатайте.
        //На вход строка: "poiuytrewqlkjhgfdsamnbvcxz"
        //На выходе должно быть: ABCDEFGHIJKLMNOPQRSTUVWXYZ (с большой буквы)
        String str = "poiuytrewqlkjhgfdsamnbvcxz";
        System.out.println("Старая строка: " + str);
        System.out.println();
        toString(toByteArr(str));


    }

    public static void toString(byte[] unicode){
        byte[] sortArr = quickSort(unicode, 0, unicode.length - 1);
        String str2 = new String(sortArr).toUpperCase();
        System.out.println("Новая строка: " + str2);
    }

    /*** метод для преобразования строки в массив битов ***/
    public static byte[] toByteArr(String str) {
        byte[] unicode = str.getBytes(StandardCharsets.UTF_8);
        return unicode;
    }

    /*** методы для сортировки массива ***/
    public static byte[] quickSort(byte[] array, int start, int end) {
        if (start < end) {
            int indexPivot = partition(array, start, end);
            quickSort(array, start, indexPivot - 1);
            quickSort(array, indexPivot + 1, end);
        }
        return array;
    }

    public static int partition(byte[] array, int start, int end) {
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

    public static void swap(byte[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = (byte) temp;
    }

}
