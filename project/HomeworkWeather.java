package project;


import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import project.dto.WeatherResponse;
import project.enums.Periods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static project.enums.Periods.GET_WEATHER_IN_NEXT_5_DAYS;
import static project.enums.Periods.NOW;

public abstract class HomeworkWeather implements WeatherProvider {

        // GET: https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/5day/{locationKey}

        private static final String HOME_HOST = "dataservice.accuweather.com"; //host
        private static final String FORECAST = "forecasts"; //передача
        private static final String API_VERSION = "v1";  //версия
        private static final String FORECAST_TYPE = "daily"; //ежедневно
        private static final String FORECAST_PERIOD = "5day"; // на пероид 5 дней
        private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";

        private static final String LOCATION_KEY = "474212_PC"; //{LocationKey} SPB
        private static final String API_KEY = "NCpzIgzd9LfH7ApfIdqSuU99OaBHfjIJ";


        private static OkHttpClient client = new OkHttpClient();
        private ObjectMapper objectMapper = new ObjectMapper();


    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(HOME_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String responseList = client.newCall(request).execute().body().string();

            List<WeatherResponse> weatherResponseList = this.objectMapper.readValue(responseList, this.objectMapper.getTypeFactory().constructCollectionType(List.class, WeatherResponse.class));

            WeatherResponse weather = weatherResponseList.get(0);

            System.out.println("Сейчас в городе " + ApplicationGlobalState.getInstance().getSelectedCity() +
                    "  температура: " + weather.getTemperature().getMetric().getValue()
                    + " C, и " + weather.getWeatherText() + ".");
        }
    }

        public void getWeatherForFiveDays(Periods periods) throws IOException  {
            if (periods.equals(Periods.FIVE_DAYS)) {
                String cityKey = detectCityKey();
                HttpUrl url = new HttpUrl.Builder()
                        .scheme("http")
                        .host(HOME_HOST)
                        .addPathSegment(FORECAST)
                        .addPathSegment(API_VERSION)
                        .addPathSegment(FORECAST_TYPE)
                        .addPathSegment(FORECAST_PERIOD)
                        .addPathSegment(cityKey)
                        .addQueryParameter("apikey", API_KEY)
                        .addQueryParameter("language", "ru-ru")
                        .addQueryParameter("metric", "true")
                        .build();

                Request request = new Request.Builder()
                        .addHeader("accept", "application/json")
                        .url(url)
                        .build();

                String responseList = client.newCall(request).execute().body().string();

                int firstIndexBody = responseList.indexOf("[{\"Date\"");
                int lastIndexBody = responseList.lastIndexOf("}");
                responseList = responseList.substring(firstIndexBody, lastIndexBody);

                List<WeatherResponse> weatherResponseList = this.objectMapper.readValue(responseList, this.objectMapper.getTypeFactory().constructCollectionType(List.class, WeatherResponse.class));

                for (WeatherResponse weather : weatherResponseList) {
                    System.out.println("В городе " + ApplicationGlobalState.getInstance().getSelectedCity() + " на следующую дату " + weather.getDate().substring(0, 10) +
                            " ожидается такая погода: Минимальная температура " + weather.getTemperature().getMinimum().getValue() +
                            " C. Максимальная температура " + weather.getTemperature().getMaximum().getValue() +
                            " C. Днем - " + weather.getDay().getIconPhrase() +
                            " . Ночью - " + weather.getNight().getIconPhrase() + ".");
                }

            }
        }


        public String detectCityKey() throws IOException{
            String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

            HttpUrl detectLocationURL = new HttpUrl.Builder()
                    .scheme("http")
                    .host(HOME_HOST)
                    .addPathSegment("locations")
                    .addPathSegment(API_VERSION)
                    .addPathSegment("cities")
                    .addPathSegment("autocomplete")
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("q", selectedCity)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(detectLocationURL)
                    .build();

            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new IOException("Невозможно прочесть информацию о городе. " +
                        "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
            }
            String jsonResponse = response.body().string();
            System.out.println("Произвожу поиск города " + selectedCity);

            if (objectMapper.readTree(jsonResponse).size() > 0) {
                String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
                String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
                System.out.println("Найден город " + cityName + " в стране " + countryName);
            } else throw new IOException("Server returns 0 cities");

            return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
        }
}

