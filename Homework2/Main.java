package Homework2;

public class Main {
    public static void main(String[] args) {
        String[][] arrays = createNewArray(); // объявление о создании в будущем массива
         arrays[7][5]="string"; // нарушает условие массива
        Constrains constrains = new Constrains(); // задаем проверки
        constrains.createArrays(arrays); //ограничения по созданию массива
        constrains.sumAmmount(); //просуммировать элементы массива (если нет exceptions)
    }

    public static String[][] createNewArray() { //наш правильный массив 4*4 в рандомными значениями в ячейках
        String[][] newArray = new String[4][4];
        for (int i = 0; i < newArray.length; i++,System.out.println()) {
            for (int j = 0; j < newArray[i].length; j++) {
                newArray[i][j] = String.valueOf((int) (Math.random() * 45));
                System.out.print(newArray[i][j] + " ");

            }
        }

        return newArray;
    }
}