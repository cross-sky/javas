package sherry.iot2.dao;

import org.apache.ibatis.annotations.Param;
import sherry.iot2.domain.City;

import java.util.List;

/**
 * Created by Crossing on 2017-7-5.
 */
public interface CityDao {
    List<City> findAllCity();

    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
