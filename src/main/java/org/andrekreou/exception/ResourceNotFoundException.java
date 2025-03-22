package org.andrekreou.exception;

/**
 * General use exception subclass that is to be used when no entity has been found
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
