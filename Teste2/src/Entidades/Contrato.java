package Entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Contrato {
    public LocalDate data;
    public BigDecimal valorPorHora;
    public BigDecimal quantidadeHoras;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        data = data;
    }

    public BigDecimal getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(BigDecimal valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public BigDecimal getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(BigDecimal quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public BigDecimal getValorTotal (){
        return getValorPorHora().multiply(getQuantidadeHoras());
    }
}
