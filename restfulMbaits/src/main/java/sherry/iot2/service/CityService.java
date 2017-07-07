package sherry.iot2.service;

import sherry.iot2.domain.City;

import java.util.List;

/**
 * Created by Crossing on 2017-7-5.
 */
public interface CityService {
    List<City> findAllCity();

    City findCityById(Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
