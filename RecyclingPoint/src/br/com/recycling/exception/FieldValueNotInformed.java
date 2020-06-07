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
public class FieldValueNotInformed extends Exception {

    /**
     * Creates a new instance of <code>FieldValueNotInformed</code> without
     * detail message.
     */
    public FieldValueNotInformed() {
    }

    /**
     * Constructs an instance of <code>FieldValueNotInformed</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FieldValueNotInformed(String msg) {
        super(msg);
    }
}
