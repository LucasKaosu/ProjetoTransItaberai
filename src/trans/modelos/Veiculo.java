/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trans.modelos;

/**
 *
 * @author ueg
 */
public class Veiculo {
    //Atributos
    private int id_Veiculo = 0;
    private String placa = "";
    private String marca = "";
    private String modelo = "";
    private String valor_Compra = "";
    
    //Métodos

    public Veiculo() {
    }
    public Veiculo(int id_Veiculo,
                    String placa,
                    String marca,
                    String modelo,
                    String valor_Compra){
        this.id_Veiculo = id_Veiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valor_Compra = valor_Compra;
    }

    public int getId_Veiculo() {
        return id_Veiculo;
    }

    public void setId_Veiculo(int id_Veiculo) {
        this.id_Veiculo = id_Veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getValor_Compra() {
        return valor_Compra;
    }

    public void setValor_Compra(String valor_Compra) {
        this.valor_Compra = valor_Compra;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "id_Veiculo=" + id_Veiculo + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", valor_Compra=" + valor_Compra + '}';
    }

   
    
    
}
