package com.dackng.modelodominioanemico.cuota;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Slf4j
public class Cuota {
    private BigDecimal amortizacion, interes, monto, saldo;
    private String estado;
    private Set<Pago> listaPagos;

    //Simulando la carga de datos obtenido de base de datos
    public Cuota(BigDecimal amortizacion, BigDecimal interes, BigDecimal monto, BigDecimal saldo, String estado) {
        this.amortizacion = amortizacion;
        this.interes = interes;
        this.monto = monto;
        this.saldo = saldo;
        this.estado = estado;
        this.listaPagos = new HashSet<>();
    }

    public void actualizarSaldo(Pago pago){
        saldo = saldo.subtract(pago.getMonto());
        listaPagos.add(pago);
    }

    public void actualizarEstado(){
        if (saldo.compareTo(BigDecimal.ZERO) == 0) estado = "PAGADO";
    }
}

