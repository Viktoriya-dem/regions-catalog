package com.vikki.regionscatalog.exception;

public class NoRegionException extends RuntimeException {
    public NoRegionException() {
        super("No region in base!");
    }
}
