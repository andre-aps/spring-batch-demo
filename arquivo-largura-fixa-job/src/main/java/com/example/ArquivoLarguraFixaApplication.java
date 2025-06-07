package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArquivoLarguraFixaApplication {

    //    args: arquivoClientes=file:arquivo-largura-fixa-job/src/main/resources/clientes-largura-fixa.txt arquivoClientesSaida=file:arquivo-largura-fixa-job/src/main/resources/clientes-largura-fixa-saida.txt
    public static void main(String[] args) {
        SpringApplication.run(ArquivoLarguraFixaApplication.class, args);
    }

}
