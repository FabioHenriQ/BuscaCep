import br.com.projeto.conexaoApi.ConsultaApi;
import br.com.projeto.geraArquivo.CriaArquivo;
import br.com.projeto.modelo.Cep;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual seu CEP? ");
        String cep = "";
        ArrayList<Cep> cepsBuscados = new ArrayList<>();
        String sair = "";

        while (!sair.equalsIgnoreCase("sair")) {
            while (!cep.matches("\\d{8}")) {
                cep = leitura.nextLine().replace("-", "");
                if (cep.matches("\\d{8}")) {
                    System.out.println("Carregando...");
                } else {
                    System.out.println("Inválido");
                }
            }

            try {
                ConsultaApi api = new ConsultaApi(cep);
                Cep meuCep = new Cep(api.cepRecord());
                cepsBuscados.add(meuCep);

                CriaArquivo arquivoCeps = new CriaArquivo(cepsBuscados, api);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Quer consultar outro CEP? (Sim) (Sair)");
            sair = leitura.nextLine();

            if (!sair.equalsIgnoreCase("sair")) {
                cep = "";
                System.out.println("Digite o novo CEP:");
            } else {
                System.out.println("Obrigado!");
            }
        }
    }
}