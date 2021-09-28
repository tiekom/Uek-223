package ch.zli.m223.punchclock.exception;

public class LocalDateTimeIsInvalid extends Exception {
    public LocalDateTimeIsInvalid(String errorMessage) {
        super(errorMessage);
    }
}
