package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArquivoFlatCustomizadoApplication {

    //    args: arquivosLancamento=file:arquivo-flat-customizado-job/src/main/resources/lancamentos* demonstrativosOrcamentarios=file:arquivo-flat-customizado-job/src/main/resources/demonstrativosOrcamentarios
    public static void main(String[] args) {
        SpringApplication.run(ArquivoFlatCustomizadoApplication.class, args);
    }

}
