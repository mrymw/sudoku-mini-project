package com.mrymw.exception;

import java.io.IOException;

public class InvalidCharacterException extends IOException {
    public InvalidCharacterException(String message) {
        super(message);
    }
}
