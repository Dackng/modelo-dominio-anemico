package com.dackng.modelodominioanemico;

import com.dackng.modelodominioanemico.cuota.Cuota;
import com.dackng.modelodominioanemico.cuota.Pago;
import com.dackng.modelodominioanemico.service.PagoCuotaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@Slf4j
public class ModeloDominioAnemicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModeloDominioAnemicoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Cuota cuota = new Cuota(new BigDecimal(10), new BigDecimal(5), new BigDecimal(15)
                    , new BigDecimal(15),"FALTA DE PAGO");
            log.info("ACTUAL CUOTA OBTENIDA => " + cuota);
            PagoCuotaService pagoCuotaService = new PagoCuotaService(cuota);//simulando la carga de base datos
            Pago pago = new Pago(new BigDecimal(15));
            log.info("Pago => " + pago.toString());
            cuota = pagoCuotaService.registrarConObjetosAnemicos(pago);
            log.info("NUEVA CUOTA OBTENIDA =>" + cuota);
        };
    }

}

