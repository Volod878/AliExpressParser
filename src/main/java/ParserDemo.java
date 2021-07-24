import org.json.JSONArray;
import website.AliExpress;
import website.parser.WebParser;
import write.CSV_Writer;

import java.net.URL;

public class ParserDemo {
    public static void main(String[] args) {
        AliExpress aliExpress = new AliExpress();
        JSONArray products = new JSONArray();
        String fileName = "results.csv";

        for (int i = 0; i < 10; i++) {
            // создаем URL для загрузки новых данных
            URL urlAli = aliExpress.createURL(i * 10);

            // загружаем Json в виде Java строки
            String resultJson = WebParser.parseUrl(urlAli);
            resultJson = AliExpress.getArrayResult(resultJson);

            // парсим полученный JSON и добавляем его в products
            WebParser.parseJSONData(resultJson, products);
            System.out.println("Количество загруженных товаров: " + products.length());
        }

        // запись json в CSV файл
        CSV_Writer.writeJsonToCsv(products, fileName);
    }
}
