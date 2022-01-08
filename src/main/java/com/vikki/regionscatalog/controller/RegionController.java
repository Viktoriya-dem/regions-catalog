package com.vikki.regionscatalog.controller;

import com.vikki.regionscatalog.model.Region;
import com.vikki.regionscatalog.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping()
    public List<Region> getAll() {
        return regionService.getAll();
    }

    @GetMapping("/{id}")
    public Region getById(@PathVariable int id) {
        return regionService.getById(id);
    }

    @GetMapping("/title/{title}")
    public Region getByTitle(@PathVariable String title) {
        return regionService.getByTitle(title);
    }

    @PutMapping()
    @ResponseBody
    public void update(@RequestParam int id, @RequestParam String title, @RequestParam String abbreviation) {
        regionService.updateById(id, title, abbreviation);
    }

    @PostMapping()
    @ResponseBody
    public void add(@RequestParam String title, @RequestParam String abbreviation) {
        regionService.add(title, abbreviation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        regionService.deleteById(id);
    }
}
