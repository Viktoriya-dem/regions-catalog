package com.vikki.regionscatalog.exception;

public class RegionNotFoundException extends RuntimeException {
    public RegionNotFoundException() {
        super("This region not found!");
    }
}
