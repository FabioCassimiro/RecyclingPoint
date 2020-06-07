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
public class UserNotFound extends Exception {

    /**
     * Creates a new instance of <code>UserNotFound</code> without detail
     * message.
     */
    public UserNotFound() {
    }

    /**
     * Constructs an instance of <code>UserNotFound</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public UserNotFound(String msg) {
        super(msg);
    }
}
