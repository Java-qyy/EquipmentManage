package com.hbsi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hbsi.dao")
public class EquipmentmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipmentmanageApplication.class, args);
    }

}
