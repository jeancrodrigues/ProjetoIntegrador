/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.FuncionarioPers;
import model.Funcionario;

/**
 *
 * @author Jean
 */
public class LoginUsuarioUtil {

    private LoginUsuarioUtil() {
    }
    
    private class UsuarioRN {

        private FuncionarioPers funcionarioPers;       
        
        private Funcionario funcionario;

        public UsuarioRN() {
            funcionarioPers = new FuncionarioPers();
        }

        public Funcionario getFuncionarioLogado() {
            return funcionario;
        }

        public boolean setLoginFuncionario(String usuario, String senha) {
            this.funcionario = funcionarioPers.procurarPorNomeUsuario(usuario);
            return funcionario != null && funcionario.getSenha() == senha;
        }
    }
}
