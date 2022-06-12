package project.enums;


import project.entity.WeatherData;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface WeatherProvider {

  void getWeather(Periods period) throws IOException;
  List<WeatherData> getAllFromDb() throws IOException, SQLException;
}
