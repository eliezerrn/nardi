package Entidades;

import Enum.Nivel;
import Utillitarios.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    public BigDecimal valorMedioMes (Integer ano, Integer mes){
						
		BigDecimal total = getSalarioBase();
        LocalDate dataInicioMes = Util.getData("01/" + mes + "/" + ano,null);
        LocalDate dataFimMes = Util.getUltimaDataMes(mes);

        total = total.add(getContratos().stream().filter(f -> f.getData().isAfter(dataInicioMes) && f.getData().isBefore(dataFimMes))
                .map(Contrato::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add));
		
        return total.divide(BigDecimal.valueOf(2), RoundingMode.HALF_EVEN);
    }
}