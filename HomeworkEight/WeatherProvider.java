package project;

import com.fasterxml.jackson.core.ObjectCodec;
import project.entity.WeatherData;
import project.enums.Periods;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface WeatherProvider {

     void getWeather(Periods period) throws IOException;

    void getWeatherForFiveDays(Periods periods) throws IOException, SQLException;

    List<WeatherData> getAllFromDb() throws SQLException, IOException;
}
