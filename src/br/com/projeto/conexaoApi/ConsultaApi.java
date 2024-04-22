package br.com.projeto.conexaoApi;

import br.com.projeto.modelo.CepRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    private String cep;
    private String json;
    private Gson gson;

    public ConsultaApi(String cep) throws IOException, InterruptedException {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        this.cep = "https://viacep.com.br/ws/"+ cep +"/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.cep))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            this.json = response.body();

        } catch (IllegalArgumentException e) {
            System.out.println("Esse CEP é inválido!");
            System.out.println(e.getMessage());
        }
    }

    public CepRecord cepRecord(){
        return this.gson.fromJson(this.json, CepRecord.class);
    }

    public Gson getGson() {
        return gson;
    }
}
