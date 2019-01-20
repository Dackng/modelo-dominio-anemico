package com.dackng.modelodominioanemico.cuota;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Pago {
    private BigDecimal monto;

    public void validarMonto(BigDecimal interesCuota){
        if (monto.compareTo(interesCuota) < 0) new Exception("Monto de pago es menor que interes");
    }
}
