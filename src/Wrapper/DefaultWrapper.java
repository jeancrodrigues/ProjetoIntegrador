/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrapper;

import com.towel.el.annotation.Resolvable;

/**
 *
 * @author Jean
 */
public class DefaultWrapper {
    
    @Resolvable(colName="Código")
    protected Integer id;

    public Integer getId() {
        return id;
    }
}
