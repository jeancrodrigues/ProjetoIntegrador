/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.FuncionarioPers;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Funcionario;

/**
 *
 * @author RAFAEL
 */
public class FuncionarioRN {
    private Funcionario func;
    private FuncionarioPers pers;
    
    DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public FuncionarioRN() {
        pers = new FuncionarioPers();
        func = new Funcionario();
    }
    
    
    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }
    
    public void gravar(){
        pers.gravar(func);
    }
    
    public Date stringToDate(String dado) throws ParseException {
        if (!dado.equals(null)) {
            Date data;
      data = new Date(df.parse(dado).getTime());
            return data;
        }
        return null;
    }
    
    public String dateToString(Date dado) {
        String data = "";
        return data = sdf.format(dado).trim();
    }
}
