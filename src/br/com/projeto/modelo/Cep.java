package br.com.projeto.modelo;

public class Cep {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;

    public Cep(CepRecord record){
        this.cep = record.cep();
        this.logradouro = record.logradouro();
        this.bairro = record.bairro();
        this.localidade = record.localidade();
        this.uf = record.uf();
        this.ddd = record.ddd();
    }

    @Override
    public String toString() {
        return """
                CEP: %s
                Rua: %s
                Bairro: %s
                Localidade: %s
                Estado: %s
                DDD: %s
                """.formatted(cep, logradouro, bairro, localidade, uf, ddd);
    }
}
