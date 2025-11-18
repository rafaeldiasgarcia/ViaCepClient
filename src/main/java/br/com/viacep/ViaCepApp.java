package br.com.viacep;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ViaCepApp {

    private static final String API_BASE_URL = "https://viacep.com.br/ws/";

    public Endereco buscarEnderecoPorCep(String cep) {
        String cepLimpo = cep.replaceAll("[^0-9]", "");
        String url = API_BASE_URL + cepLimpo + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.err.println("Erro na requisição: Status " + response.statusCode());
                return null;
            }

            String jsonBody = response.body();

            try (JsonReader reader = Json.createReader(new StringReader(jsonBody))) {

                JsonObject jsonObject = reader.readObject();

                if (jsonObject.containsKey("erro") && jsonObject.getBoolean("erro")) {
                    System.out.println("CEP " + cepLimpo + " não encontrado pela API.");
                    return null;
                }

                Endereco endereco = new Endereco();
                endereco.setCep(jsonObject.getString("cep"));
                endereco.setLogradouro(jsonObject.getString("logradouro"));

                endereco.setComplemento(jsonObject.getString("complemento", ""));

                endereco.setBairro(jsonObject.getString("bairro"));
                endereco.setLocalidade(jsonObject.getString("localidade"));
                endereco.setUf(jsonObject.getString("uf"));
                endereco.setDdd(jsonObject.getString("ddd"));

                return endereco;
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro fatal ao buscar CEP: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        ViaCepApp app = new ViaCepApp();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escreva o CEP: ");
        String cepConsulta = scanner.nextLine();

        System.out.println("Buscando CEP: " + cepConsulta + "...");

        Endereco resultado = app.buscarEnderecoPorCep(cepConsulta);

        if (resultado != null) {
            System.out.println(resultado.toString());
        } else {
            System.out.println("A busca não retornou um endereço válido.");
        }
    }
}