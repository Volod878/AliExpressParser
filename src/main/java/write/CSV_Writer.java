package write;

import org.json.CDL;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;

public class CSV_Writer {
    public static void writeJsonToCsv(JSONArray products, String fileName) {

        try(FileWriter writer = new FileWriter(fileName, false)) {
            // конвертируем указанный JSONArray в отформатированную строку,
            // и записываем в файл формата CSV
            writer.write(CDL.toString(products));
            System.out.println("Данные сохранены в файл " + fileName);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
