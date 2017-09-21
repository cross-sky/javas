package sherry.entity;

import org.springframework.context.annotation.Bean;

/**
 * Created by Crossing on 2017-7-20.
 */
//@Bean
public class DeviceInfo {
    private String str; //cngdzhxz001  len=11
    private Integer id;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "str='" + str + '\'' +
                ", id=" + id +
                '}';
    }
}
