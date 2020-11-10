package com.ufpb.desafio.RestController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class UsuarioController {


    @GetMapping("/api/v1/desafio/{nomearquivo}/{conteudo}")
    public ResponseEntity<?> consultar(@PathVariable("nomearquivo") String nomearquivo, @PathVariable("conteudo") String conteudo) {


        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "echo "+ conteudo +" >  "+ nomearquivo +".txt");
        ProcessBuilder alert = new ProcessBuilder("cmd.exe", "/c", "msg %username% o arquivo "+ nomearquivo +" foi criado com sucesso");
        pb.directory(new File(System.getProperty("user.home")));
        try {
            pb.start();
            alert.start();
        } catch (IOException e) {
            System.out.println("error");
        }

        return ResponseEntity.ok("o arquivo " +nomearquivo + " foi criado com sucesso !");
    }

}
