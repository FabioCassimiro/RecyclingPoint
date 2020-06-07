/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recycling.exception;

/**
 *
 * @author WINDOWS
 */
public class InvalidRegistration extends Exception {

    /**
     * Creates a new instance of <code>InvalidRegistration</code> without detail
     * message.
     */
    public InvalidRegistration() {
    }

    /**
     * Constructs an instance of <code>InvalidRegistration</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidRegistration(String msg) {
        super(msg);
    }
}
