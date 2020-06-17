package br.com.recycling.exception;

/**
 *
 * @author Fabio Cassimiro
 */
public class PasswordsDontMatch extends Exception {

    public PasswordsDontMatch(String msg) {
        super(msg);
    }
}
