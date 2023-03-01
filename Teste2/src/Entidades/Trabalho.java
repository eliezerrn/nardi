package Entidades;

import Enum.Nivel;

import java.math.BigDecimal;
import java.util.List;

public class Trabalho {

    public String nome;
    public Nivel nivel;
    public BigDecimal salarioBase;
    public List<Contrato> Contratos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public List<Contrato> getContratos() {
        return Contratos;
    }

    public void adicionaContrato(Contrato contrato){
        getContratos().add(contrato);
    }

    public void removerContrato(Contrato contrato){
        getContratos().remove(contrato);
    }

    //TODO Eliezer terminar de fazer a média;
    public BigDecimal valorMedioMes (Integer ano, Integer mes){
        return BigDecimal.TEN;
    }
}
