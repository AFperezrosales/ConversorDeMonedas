package org.example;

import java.math.BigDecimal;

public class Moneda {
   private String moneda1;
   private String moneda2;
   private BigDecimal valor;
   private BigDecimal resultado;

    public Moneda(String moneda1, String moneda2, BigDecimal valor, BigDecimal resultado) {
        this.moneda1 = moneda1;
        this.moneda2 = moneda2;
        this.valor = valor;
        this.resultado = resultado;
    }

    public Moneda(MonedaRecord monedaRecord) {
        this.moneda1 = monedaRecord.baseCode();
        this.moneda2 = monedaRecord.targetCode();
        this.valor = monedaRecord.conversionRate();
        this.resultado = monedaRecord.conversionResult();
    }

    public String getMoneda1() {
        return moneda1;
    }

    public void setMoneda1(String moneda1) {
        this.moneda1 = moneda1;
    }

    public String getMoneda2() {
        return moneda2;
    }

    public void setMoneda2(String moneda2) {
        this.moneda2 = moneda2;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getResultado() {
        return resultado;
    }

    public void setResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return
                "Moneda 1 ='" + moneda1 + '\'' +
                ", Moneda 2='" + moneda2 + '\'' +
                ", Valor =" + valor +
                ", Resultado =" + resultado;
    }
}
