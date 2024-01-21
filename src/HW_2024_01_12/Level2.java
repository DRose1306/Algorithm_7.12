package HW_2024_01_12;

import java.util.Arrays;

public class Level2 {
    public static void main(String[] args) {
        //Дан массив объектов типа Person, который содержит поля name (тип String) и age (тип int).
        // Необходимо отсортировать этот массив по возрасту в порядке убывания, используя алгоритм Merge sort.
        Person[] people = {
                new Person("Alice", 25),
                new Person("Bob", 20),
                new Person("Charlie", 30),
                new Person("David", 35),
                new Person("Eve", 28)
        };
        System.out.println("Given Array");
        System.out.println(Arrays.toString(people));
        mergeSort(people);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(people));
    }

    private static void mergeSort(Person[] arr) {
        int lengthArr = arr.length; // длина массива

        if (lengthArr == 1) { // условие выхода
            return;
        }

        int mid = lengthArr / 2;
        Person[] leftArr = new Person[mid]; // левый подмассив
        Person[] rightArr = new Person[lengthArr - mid]; // правый подмассив

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

    private static void merge(Person[] arr, Person[] leftArr, Person[] rightArr) {
        int leftArrLength = leftArr.length;
        int rightArrLength = rightArr.length;
// контролируем индексы подмассивов
        int leftIndex = 0;
        int rightIndex = 0;
// контролируем индекс в основном массиве
        int arrIndex = 0;

        while (leftIndex < leftArrLength && rightIndex < rightArrLength) {
            if (leftArr[leftIndex].getAge() > rightArr[rightIndex].getAge()) { // сравниваем элемент в левом и правом подмассиве
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

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
