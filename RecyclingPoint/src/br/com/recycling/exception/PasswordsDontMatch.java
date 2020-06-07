
package br.com.recycling.exception;

/**
 *
 * @author WINDOWS
 */
public class PasswordsDontMatch extends Exception {

    public PasswordsDontMatch() {
        
    }
    public PasswordsDontMatch(String msg) {
        super(msg);
    }
}
