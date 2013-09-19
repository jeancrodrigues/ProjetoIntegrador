/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.FuncionarioPers;
import javax.persistence.NoResultException;
import model.Funcionario;

/**
 *
 * @author Jean
 */
public class LoginUsuarioUtil {

    private static Funcionario usuarioLogado;

    public static Funcionario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static boolean existeUsuarioLogado() {
        return usuarioLogado != null;
    }

    private LoginUsuarioUtil() {
    }

    public static boolean login(String nomeUsuario, String senha) {
        FuncionarioPers pers = new FuncionarioPers();
        try {
            Funcionario funcionario = pers.procurarPorNomeUsuario(nomeUsuario);
            if (funcionario != null && funcionario.getSenha().equals(senha)) {
                usuarioLogado = funcionario;
                return true;
            }
        } catch (NoResultException ex) {
            System.out.println("Erro login - não existe funcionario com esse nome de usuário.");
            ex.printStackTrace();
        }
        return false;
    }
}
