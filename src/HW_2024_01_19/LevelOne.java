package HW_2024_01_19;

public class LevelOne {
    public static void main(String[] args) {

    }

    static int[] growSize(int[] array, int newElements) {
        int[] tempArray = new int[array.length + newElements];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        return tempArray;
    }
}
