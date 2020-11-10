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


        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");

        ProcessBuilder builder = new ProcessBuilder();
        ProcessBuilder alert = new ProcessBuilder();
        if (isWindows) {
            builder.command("cmd.exe", "/c", "echo "+ conteudo +" >  "+ nomearquivo +".txt");
            alert.command("cmd.exe", "/c", "msg %username% o arquivo "+ nomearquivo +" foi criado com sucesso");

        } else {
            builder.command("sh", "-c", "/bin/bash ./Build.sh "+ conteudo +" "+ nomearquivo);
            alert.command("sh", "-c", "zenity --info --text=\" o arquivo "+ nomearquivo +" foi gerado com sucesso\"");
        }


        builder.directory(new File(System.getProperty("user.home")));
        try {
            builder.start();
            alert.start();
        } catch (IOException e) {
            System.out.println("error");
        }

        return ResponseEntity.ok("o arquivo " +nomearquivo + " foi criado com sucesso !");
    }

}
