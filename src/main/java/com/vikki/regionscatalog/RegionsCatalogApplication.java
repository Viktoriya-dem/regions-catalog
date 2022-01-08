package com.vikki.regionscatalog;

import com.vikki.regionscatalog.model.Region;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MappedTypes(Region.class)
@MapperScan("com.vikki.regionscatalog.mapper")
@SpringBootApplication
@EnableCaching
public class RegionsCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionsCatalogApplication.class, args);
	}

}
