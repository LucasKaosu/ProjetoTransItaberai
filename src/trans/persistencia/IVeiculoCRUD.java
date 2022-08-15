/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trans.persistencia;
import trans.modelos.Veiculo;
import java.util.List;

/**
 *
 * @author ueg
 */
public interface IVeiculoCRUD {
    public void incluir(Veiculo objVeiculo) throws Exception;
    public Veiculo consultar(int id) throws Exception;
    public void alterar (Veiculo objVeiculo) throws Exception;
    public void excluir (int id) throws Exception;
    public List<Veiculo> listagemDeVeiculos() throws Exception;
}
