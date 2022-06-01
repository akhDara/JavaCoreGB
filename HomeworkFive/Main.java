package HomeworkFive;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AppData data = new AppData();
        data.readCSVDocument("example.csv");
        System.out.println(Arrays.toString(data.getHeader()));
        System.out.println(Arrays.deepToString(data.getData()));

        data.writeNewCSVDocument("new_example.csv");
    }

}
