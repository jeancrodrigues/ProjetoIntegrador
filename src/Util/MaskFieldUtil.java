/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Jean
 */
public class MaskFieldUtil extends PlainDocument {
    private static final long serialVersionUID = 1L;

    public final String ONLY_NUMBERS_MASK = "[^0-9]";
    public final String ONLY_LETTERS_MASK = "[^A-Z|^ a-z |^ ]";
    public final String ONLY_LETTERS_NUMBERS_MASK = "[^A-Z|^ a-z |^0-9|^ ]";
    
    private int maxlength;
    private String mask = "";
    private boolean upperCase = false;
        
    public MaskFieldUtil(int maxlength) {
        this.maxlength = maxlength;
    }
    
    public MaskFieldUtil(String mask,int maxlength) {
        this.maxlength = maxlength;
        this.mask = mask;
    }
    
    public MaskFieldUtil(String mask,int maxlength,boolean upperCase) {
        this.maxlength = maxlength;
        this.mask = mask;
        this.upperCase = upperCase;
    }
    
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        try {
            boolean fixedLengh = (!((getLength() + str.length()) > maxlength));
            if (maxlength == 0 || fixedLengh) {
                if(upperCase)
                    str = str.toUpperCase();
                
                super.insertString(offs, str.replaceAll(mask, ""), a);
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}

