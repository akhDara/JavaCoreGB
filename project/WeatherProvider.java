package project;

import com.fasterxml.jackson.core.ObjectCodec;
import project.enums.Periods;


import java.io.IOException;

public interface WeatherProvider {

     void getWeather(Periods period) throws IOException;

    void getWeatherForFiveDays(Periods periods) throws IOException;
}
