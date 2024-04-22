package br.com.projeto.geraArquivo;

import br.com.projeto.conexaoApi.ConsultaApi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CriaArquivo {

    public CriaArquivo(ArrayList listaCep, ConsultaApi api) throws IOException {

        FileWriter escrita = new FileWriter("ceps.json");
        escrita.write(api.getGson().toJson(listaCep));
        escrita.close();
    }
}
