/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Classe responsavel pela conexao com o banco de dados
 * NÃO é permitido criar uma instância dessa classe
 * A conexão pode ser obtida com o método getInstanciaConexao
 * 
 * @author Jean
 */
public class ConexaoUtil {
    
    private static Connection conexao;
    
    private ConexaoUtil(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("ConexaoUtil" + ex.getMessage());
            //Logger.getLogger(ConexaoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getInstanciaConexao(){        
        try{        
            if(conexao == null || conexao.isClosed()){
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/locadoraveiculos", "root", "1234");                
            }
            return conexao;
        } catch(SQLException e) {
            System.out.println("ConexaoUtil" + e.getMessage());
        }        
        return null;        
    }    
}
