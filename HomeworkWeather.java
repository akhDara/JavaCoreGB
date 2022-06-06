import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class HomeworkWeather {

    // GET: https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/5day/{locationKey}

    private static final String HOME_HOST = "dataservice.accuweather.com"; //host
    private static final String FORECAST = "forecasts"; //передача
    private static final String API_VERSION = "v1";  //версия
    private static final String FORECAST_TYPE = "daily"; //ежедневно
    private static final String FORECAST_PERIOD = "5day"; // на пероид 5 дней

    private static final String LOCATION_KEY = "474212_PC"; //{LocationKey} SPB
    private static final String API_KEY = "qVEPPtsFlC5QacBJLX62hdiiKGSVyIBy"; //API ключ доступа

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();


        HttpUrl url = new HttpUrl.Builder()
            .scheme("http")
            .host(HOME_HOST)
            .addPathSegment(FORECAST)
            .addPathSegment(API_VERSION)
            .addPathSegment(FORECAST_TYPE)
            .addPathSegment(FORECAST_PERIOD)
            .addPathSegment(LOCATION_KEY)
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("language", "ru-ru")
            .addQueryParameter("metric", "true")
            .build();

        System.out.println(url.toString());

        Request requesthttp = new Request.Builder()
            .addHeader("accept", "application/json")
            .url(url)
            .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);
    }
}
