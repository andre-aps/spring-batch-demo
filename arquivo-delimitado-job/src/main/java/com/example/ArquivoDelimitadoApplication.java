package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArquivoDelimitadoApplication {

    //    args: arquivoClientes=file:arquivo-delimitado-job/src/main/resources/clientes-delimitado.txt arquivoClientesSaida=file:arquivo-delimitado-job/src/main/resources/clientes-delimitado-saida.txt
    public static void main(String[] args) {
        SpringApplication.run(ArquivoDelimitadoApplication.class, args);
    }

}
