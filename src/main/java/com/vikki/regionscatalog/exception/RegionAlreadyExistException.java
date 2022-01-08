package com.vikki.regionscatalog.exception;

public class RegionAlreadyExistException extends RuntimeException {
    public RegionAlreadyExistException() {
        super("This region has already existed!");
    }
}
