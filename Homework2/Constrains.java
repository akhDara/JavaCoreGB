package Homework2;

public class Constrains {
   private String[][] arrays;

   public void createArrays(String[][] arrays) { //проверка при создания массива
      try {
         checkSizeArray(arrays);
         this.arrays = arrays;
      } catch (MyArraySizeException e) {
         e.printStackTrace();
      } catch (NullPointerException a) { //нельзя нулевое значение
         System.out.println("В параметр массива передано нулевое значение");
         a.printStackTrace();
      }
   }

   private void checkSizeArray (String[][] arrays) throws MyArraySizeException {
      if (arrays.length != 4 || checkLengthStrings(arrays)){
         throw new MyArraySizeException("Размер массива не соответствует 4х4");
      }
   }

   private boolean checkLengthStrings(String[][] arrays) {
      for (String [] arr: arrays){
         if (arr.length!=4){
            return true;
         }
      }
      return false;
   }

   public  void sumAmmount() {
      if (arrays == null) {
         System.out.println("У класса не инициализирован массив строк, суммировать нечего");
         return;
      }

      try {
         sumArray();
      } catch (MyArrayDataException e) {
         e.printStackTrace();
      }
   }

   private void sumArray() throws MyArrayDataException {
      int result = 0;
      for (int x = 0; x < arrays.length; x++) {
         String[] arr = arrays[x];
         for (int y = 0; y < arr.length; y++) {
            try {
               result+=Integer.parseInt(arr[y]);
            }
            catch (NumberFormatException e) {
               throw new MyArrayDataException("Массив содержит не только числа, суммирование не возможно. Ошибка в ячейке: " + x + ":" + y);
            }
         }
      }
      System.out.println("Сумма элементов массива: " + result);
   }

}
