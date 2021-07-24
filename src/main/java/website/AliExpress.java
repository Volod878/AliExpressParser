package website;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * На сайте https://flashdeals.aliexpress.com/en.htm?
 * товар подгружается со страницы https://gpsfront.aliexpress.com/getRecommendingResults.do?
 * поэтому будем работать с ней
 */
public class AliExpress {
    private String link = "https://gpsfront.aliexpress.com/getRecommendingResults.do?" +
            "callback=jQuery1830551620685788792_1627129140476" +
            "&widget_id=5547572" +
            "&platform=pc" +
            "&limit=10" +
            "&offset=0" +
            "&phase=1" +
            "&productIds2Top=" +
            "&postback=ca4e89b3-4062-4bf2-8729-041d2b5a6e2c" +
            "&_=1627131176950";

    private static final String begin = "\"results\":";
    private static final String end = ",\"finished\":false";


    public URL createURL(int offset) {
        // меняем значение offset
        int beginOffsetValue = link.indexOf("offset=") + 7;
        int endOffsetValue = link.indexOf("&phase");
        link = link.substring(0, beginOffsetValue) + offset + link.substring(endOffsetValue);

        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getArrayResult(String string) {
        // возвращаем только данные о товаре
        return string.substring(string.indexOf(begin) + 10).split(end)[0];
    }
}
