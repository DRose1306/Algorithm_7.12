package HW_2024_01_25;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Level2 {
    public static void main(String[] args) {
        //Level 2
        //Дан односвязный список. Написать функцию или блок схему, определяющую,
        // образуют ли его элементы симметричную последовательность.
        // Для решения задачи использовать стек и очередь.
        // Функция будет возвращать значение true, если список является симметричным, false – в противном случае.
        //По определению пустой список является симметричным.
        // Поэтому, если список пуст, то возвращаем значение true.
        // Для проверки симметричности списка нужно проверить на равенство все пары элементов,
        // равноотстоящих от середины списка. Каждая пара содержит один элемент из первой половины списка
        // и один – из второй. Элементы первой половины списка последовательно заносятся в очередь,
        // второй половины в стек. Если количество элементов списка будет нечетным,
        // то серединный элемент будет симметричен сам себе и не будет помещен ни в очередь, ни в стек.

        List<String> firstList = new LinkedList<>();

        firstList.add("One");
        firstList.add("Two");
        firstList.add("Three");
        firstList.add("Four");
        firstList.add("Five");
        firstList.add("Six");

        List<String> secondList = new LinkedList<>();

        secondList.add("A");
        secondList.add("B");
        secondList.add("C");
        secondList.add("C");
        secondList.add("B");
        secondList.add("A");

        System.out.println(isSymmetrical(firstList));
        System.out.println(isSymmetrical(secondList));
    }

    static boolean isSymmetrical(List<String> list) {
        if (list.isEmpty()) {
            return true;
        }
        int middle = list.size() / 2;
        Queue<String> myQueue = new LinkedList<>();
        Stack<String> myStack = new Stack<>();


        for (int i = 0; i < list.size() / 2; i++) {
            myQueue.add(list.get(i));
        }
        for (int i = middle + (list.size() % 2); i < list.size(); i++) {
            myStack.add(list.get(i));
        }


        while (!myQueue.isEmpty() && !myStack.isEmpty()) {
            if (!myQueue.poll().equals(myStack.pop())) {
                return false;
            }
        }

        return true;
    }
}

