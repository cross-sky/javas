package sherry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import sherry.happ.entity.DeviceHot;
import sherry.happ.service.DeviceRepository;
import sherry.happ.service.DeviceRepositoryImpl;

/**
 * Created by Crossing on 2017-7-4.
 */
@SpringBootApplication
//@MapperScan("sherry.iot2.dao")
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public DeviceRepository deviceRepository() {
//        return new DeviceRepositoryImpl();
//    }

//    @Bean
//    public Converter<String, DeviceHot>deviceConvert(){
//        return new Converter<String, DeviceHot>() {
//            @Override
//            public DeviceHot convert(String s) {
//                return deviceRepository().findDevice(Long.valueOf(s));
//            }
//        };
//    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
