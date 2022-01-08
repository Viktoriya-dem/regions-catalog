package com.vikki.regionscatalog.mapper;

import com.vikki.regionscatalog.model.Region;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface RegionMapper {

    @Select("select * from region")
    List<Region> findAll();

    @Select("select * from region where id=#{id}")
    Region findById(@PathVariable("id") final Integer id);

    @Select("select * from region where title=#{title}")
    Region findByTitle(@PathVariable("title") final String title);

    @Update("update region set title=#{title}, abbreviation=#{abbreviation} where id=#{id}")
    void updateById(@PathParam("id") final Integer id, @PathParam("title") final String title,
                            @PathParam("abbreviation") final String abbreviation);

    @Insert("insert into region(title, abbreviation) values(#{title}, #{abbreviation}) returning id")
    void insert(Region region);

    @Delete("delete from region where id=#{id}")
    void deleteById(@PathVariable("id") final Integer id);

}
