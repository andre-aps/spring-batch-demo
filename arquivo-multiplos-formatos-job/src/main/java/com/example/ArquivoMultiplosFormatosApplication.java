package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArquivoMultiplosFormatosApplication {

    //    args: arquivosClientes=file:arquivo-multiplos-formatos-job/src/main/resources/clientes*
    public static void main(String[] args) {
        SpringApplication.run(ArquivoMultiplosFormatosApplication.class, args);
    }

}
