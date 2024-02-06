public class Main {
    public static void main(String[] args) {
        int numberOfDisks = 3; // Количество дисков
        char sourcePeg = 'A'; // Исходный стержень
        char targetPeg = 'C'; // Целевой стержень
        char auxiliaryPeg = 'B'; // Вспомогательный стержень

        System.out.println("Шаги для решения Ханойской башни с " + numberOfDisks + " дисками:");
        hanoi(numberOfDisks, sourcePeg, targetPeg, auxiliaryPeg);
    }

    // Рекурсивная функция для решения Ханойской башни
    private static void hanoi(int n, char source, char target, char auxiliary) {
        if (n == 1) {
            // Перемещаем верхний диск с исходного стержня на целевой
            System.out.println("Переместите диск 1 с " + source + " на " + target);
            return;
        }

        // Перемещаем (n-1) дисков с исходного стержня на вспомогательный
        hanoi(n - 1, source, auxiliary, target);

        // Перемещаем оставшийся диск с исходного стержня на целевой
        System.out.println("Переместите диск " + n + " с " + source + " на " + target);

        // Перемещаем (n-1) дисков с вспомогательного стержня на целевой
        hanoi(n - 1, auxiliary, target, source);
    }
}

