package HomeworkFive;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AppData {

    public static final String SPLITTER = ";"; //проставить разделители

    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    } //геттеры для header и data

    public Integer[][] getData() {
        return data;
    }

    public void readCSVDocument(String file) { //чтение документа

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ArrayList<Integer[]> lineList = new ArrayList<>();
            header = (reader.readLine().split(SPLITTER));
            String line;
            while ((line = reader.readLine()) != null) { //перебор построчный данных из нашего первого документа
                String[] rowArr = line.split(SPLITTER);
                Integer[] intArr = new Integer[rowArr.length];
                for (int i = 0; i < rowArr.length; i++) {
                    intArr[i] = Integer.parseInt(rowArr[i]);
                }
                lineList.add(intArr);
            }
            data = lineList.toArray(new Integer[][]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNewCSVDocument(String resultFileName) { // сохранение данных в csv файл
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFileName), StandardCharsets.UTF_8));

            StringBuffer oneLine = new StringBuffer();
            for (int i = 0; i < header.length; i++) {
                oneLine.append(header[i]);
                oneLine.append(SPLITTER);
            }
            writer.write(oneLine.toString());
            writer.newLine();

            for (int i = 0; i < data.length; i++) {
                Integer[] rowData = data[i];
                oneLine.delete(0, oneLine.length());
                for (int j = 0; j < rowData.length; j++) {
                    oneLine.append(rowData[j]);
                    oneLine.append(SPLITTER);
                }
                writer.write(oneLine.toString());
                writer.newLine();
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
