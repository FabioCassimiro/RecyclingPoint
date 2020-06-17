package br.com.recycling.exception;

/**
 *
 * @author Fabio Cassimiro
 */
public class RegisteredUserException extends Exception {

    public RegisteredUserException(String msg) {
        super(msg);
    }
}
