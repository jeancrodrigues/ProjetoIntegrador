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
 * @author RAFAEL
 */
public class OnlyLettersUpperCaseUtil extends PlainDocument {

    private int maxlength;

    public OnlyLettersUpperCaseUtil(int maxlength) {
        this.maxlength = maxlength;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        try {
            boolean fixedLengh = (!((getLength() + str.length()) > maxlength));
            if (maxlength == 0 || fixedLengh) {
                super.insertString(offs, str.toUpperCase().replaceAll("[^A-Z|^ a-z|^ ]", ""), a);
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}