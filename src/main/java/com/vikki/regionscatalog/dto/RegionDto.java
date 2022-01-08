package com.vikki.regionscatalog.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegionDto {

    private Integer id;
    private String title;
    private String abbreviation;

    public RegionDto() {

    }

    public RegionDto(String title, String abbreviation) {
        this.title = title;
        this.abbreviation = abbreviation;
    }


    @Override
    public String toString() {
        return "RegionDto{" +
                "title='" + title + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
