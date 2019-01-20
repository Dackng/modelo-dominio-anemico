package com.dackng.modelodominioanemico.service;

import com.dackng.modelodominioanemico.cuota.Cuota;
import com.dackng.modelodominioanemico.cuota.Pago;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class PagoCuotaService {

    Cuota cuota; //simulando algun repository e.g cuotaRepository;

    public Cuota registrarSinObjetosAnemicos(Pago pago){
        //consultar cuota en base de datos=> cuotaRepository.findById(pago.getId());
        pago.validarMonto(cuota.getInteres());
        cuota.actualizarSaldo(pago);
        cuota.actualizarEstado();
        //guardar pacuota en base de datos
        return cuota;
    }

    public Cuota registrarConObjetosAnemicos(Pago pago){
        //consultar cuota en base de datos=> cuotaRepository.findById(pago.getId());
        if (pago.getMonto().compareTo(cuota.getInteres()) < 0) new Exception("Monto de pago es menor que interes");
        BigDecimal diferencia = cuota.getSaldo().subtract(pago.getMonto());
        cuota.setSaldo(diferencia);
        cuota.getListaPagos().add(pago);
        if (cuota.getSaldo().compareTo(BigDecimal.ZERO) == 0) cuota.setEstado("PAGADO");
        //guardar pacuota en base de datos
        return cuota;
    }
}
