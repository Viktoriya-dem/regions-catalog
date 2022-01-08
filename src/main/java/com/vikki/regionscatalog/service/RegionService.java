package com.vikki.regionscatalog.service;

import com.vikki.regionscatalog.dto.RegionDto;
import com.vikki.regionscatalog.exception.NoRegionException;
import com.vikki.regionscatalog.exception.RegionAlreadyExistException;
import com.vikki.regionscatalog.exception.RegionNotFoundException;
import com.vikki.regionscatalog.mapper.RegionMapper;
import com.vikki.regionscatalog.model.Region;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionMapper regionMapper;
    private final ModelMapper modelMapper;

    @Cacheable(value = "regions")
    public List<Region> getAll() {
        List<Region> regions = regionMapper.findAll();
        log.info("getting all regions");
        if (regions.size() == 0) {
            throw new NoRegionException();
        } else {
            return regionMapper.findAll();
        }
    }

    @Cacheable(value = "regions", key = "#id")
    public Region getById(Integer id) {
        Optional<Region> optional = Optional.ofNullable(regionMapper.findById(id));
        log.info("getting region by id: {}", id);
        if (optional.isPresent()) {
            return regionMapper.findById(id);
        } else throw new RegionNotFoundException();
    }

    @Cacheable(value = "regions", key = "#title")
    public Region getByTitle(String title) {
        Optional<Region> optional = Optional.ofNullable(regionMapper.findByTitle(title));
        log.info("getting region by title: {}", title);
        if (optional.isPresent()) {
            return regionMapper.findByTitle(title);
        } else throw new RegionNotFoundException();
    }

    public void updateById(Integer id, String title, String abbreviation) {
        Optional<Region> optional = Optional.ofNullable(regionMapper.findById(id));
        if (optional.isPresent()) {
            regionMapper.updateById(id, title, abbreviation);
        } else throw new RegionNotFoundException();
    }

    public void add(String title, String abbreviation) {
        Optional<Region> optional = Optional.ofNullable(regionMapper.findByTitle(title));
        if (optional.isEmpty()) {
            regionMapper.insert(modelMapper.map(new RegionDto(title, abbreviation), Region.class));
        } else throw new RegionAlreadyExistException();
    }

    @CacheEvict("regions")
    public void deleteById(Integer id) {
        Optional<Region> optional = Optional.ofNullable(regionMapper.findById(id));
        if (optional.isPresent()) {
            regionMapper.deleteById(id);
        } else throw new RegionNotFoundException();
    }

}
