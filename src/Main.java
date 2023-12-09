public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = arraySum(array, 0);
        System.out.println("summ =  " + result);
        System.out.println();

        /*** Первое задание ***/
        //Дано натуральное число N. Выведите слово YES, если число N является точной степенью двойки, или слово NO в противном случае.
        //Операцией возведения в степень пользоваться нельзя!
        //
        //
        //Ввод YES
        //Вывод 8
        //
        //
        //Ввод NO
        //Вывод 3
        System.out.println("задание номер 1");

        int num = 4;
        if (pow2(num)) {
            System.out.println("YES");
            System.out.println(num);
        } else {
            System.out.println("NO");
            System.out.println(num);
        }
        System.out.println();


        /*** Второе задание ***/

        //Дано натуральное число N. Вычислите сумму его цифр.
        //При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется).
        //Ввод 179
        //Вывод 17
        //Ввод 985
        //Вывод 22

        System.out.println("задание номер 2");

        int sum = sumOfN(1234, 1000);
        System.out.println("Сумма цифр заданного числа равна " + sum);
        System.out.println();

        /*** Третье задание ***/

        //Напишите рекурсивный метод, который выводит на экран числа Фибоначчи до N-ого элемента.

        System.out.println("задание номер 3");

        int n = 15;
        System.out.print("Ряд чисел Фибоначи до " + n + "го элемента : ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonachi(i) + " ");
        }
        System.out.println();
        System.out.println();



        /*** Четвёртое задание ***/

        //Напишите рекурсивный метод, который проверяет, является ли строка палиндромом.
        System.out.println("задание номер 4");
        String str = "levela";
        if (polindrom(str, 0, str.length() - 1)) {
            System.out.println("Строка " + str + " является полиндромом");
        } else System.out.println("Строка " + str + " не является полиндромом");

    }

    public static int arraySum(int[] array, int index) {

        if (index == array.length) {
            return 0;
        } else {
            return array[index] + arraySum(array, index + 1);
        }
    }

    public static boolean pow2(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 0) {
            pow2(n / 2);
            return true;
        }
        return false;
    }

    public static int sumOfN(int n, int divider) {
        if ((n / divider == 0) || (n % divider == 0)) {
            return n;
        } else {
            return n / divider + sumOfN(n % divider, divider / 10);
        }
    }

    public static int fibonachi(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonachi(n - 1) + fibonachi(n - 2);
        }
    }

    public static boolean polindrom(String str, int left, int right) {
        if (left >= right) {
            return true;
        }
        return (str.charAt(left) == str.charAt(right)) && polindrom(str, left++, right--);
    }
}
