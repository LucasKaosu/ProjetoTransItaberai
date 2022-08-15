/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trans.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ueg
 */
public class ConexaoBD {
    private static Connection conexao = null;
    
    private ConexaoBD() {}
    //Métodos que cria a conexão com o banco de dados
    public static Connection getConexao() throws Exception{
        try {
            if(conexao == null){
                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/trans_itaberai_BD";
                String user = "postgres";
                String password = "123456";
                Class.forName(driver);
                conexao = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException erro) {
            //Erro de encontrar o drive do banco de dados
            throw new Exception("Erro no Drive do Banco de Dados: " + erro.getMessage());
        } catch (SQLException erro){
            //Erro no banco de dados, user, senha
            throw new Exception("Erro de Dados do Banco: " + erro.getMessage());
        }
        return conexao;
    }
}
