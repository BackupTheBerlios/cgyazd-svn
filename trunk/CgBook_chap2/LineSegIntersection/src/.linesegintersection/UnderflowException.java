/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package linesegintersection;

/**
 *
 * @author mnm
 */
public class UnderflowException extends RuntimeException {
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public UnderflowException( String message ) {
        super( message );
    }
}