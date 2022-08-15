/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trans.persistencia;
import trans.modelos.Veiculo;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author ueg
 */

    public class VeiculoDAO implements IVeiculoCRUD{
    
        private Connection conexao = null;
        
        public VeiculoDAO() throws Exception{
            try {
                conexao = ConexaoBD.getConexao();
            } catch (Exception erro) {
                throw erro;
            }
        }

    @Override
    public void incluir(Veiculo objVeiculo) throws Exception {
        try {
            String sql = null;
            sql =   "insert into veiculo(placa, marca, modelo, valor_compra)"
                    + "values(?,?,?,?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objVeiculo.getPlaca());
            preparedStatement.setString(2, objVeiculo.getMarca());
            preparedStatement.setString(3, objVeiculo.getModelo());
            preparedStatement.setString(4, objVeiculo.getValor_Compra());
            preparedStatement.executeUpdate();
        }catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro Incluir: "+ erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }

    @Override
    public Veiculo consultar(int id) throws Exception {
        Veiculo veiculo = null;
        try {
            String sql = null;
            sql = "select * from veiculo where id_veiculo =  ?";
            PreparedStatement preparedStatement = null;
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                veiculo = getVeiculoResultSet(resultSet);
            }
            
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro Incluir: "+ erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
        
        return veiculo;
    }
    
    private Veiculo getVeiculoResultSet(ResultSet resultSet) throws Exception {
        Veiculo veiculo = new Veiculo();
        
        veiculo.setId_Veiculo(resultSet.getInt("id_veiculo"));
        veiculo.setPlaca(resultSet.getString("placa"));
        veiculo.setModelo(resultSet.getString("modelo"));
        veiculo.setMarca(resultSet.getString("marca"));
        veiculo.setValor_Compra(resultSet.getString("valor_compra"));
        return veiculo;
    }
        

    @Override
    public void alterar(Veiculo objVeiculo) throws Exception {
        try {
            String sql = null;
            sql =   "update veiculo set placa = ?, marca = ?, modelo = ?, valor_compra =?  where id_veiculo =? ";
            PreparedStatement preparedStatement = null;
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objVeiculo.getPlaca());
            preparedStatement.setString(2, objVeiculo.getMarca());
            preparedStatement.setString(3, objVeiculo.getModelo());
            preparedStatement.setString(4, objVeiculo.getValor_Compra());
            preparedStatement.setInt(5, objVeiculo.getId_Veiculo());
            preparedStatement.executeUpdate();
            
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro Alterar: "+ erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            String sql = null;
            sql = "delete from veiculo where id_veiculo = ?";
            PreparedStatement preparedStatement = null;
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro Incluir: "+ erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }

    @Override
    public List<Veiculo> listagemDeVeiculos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
