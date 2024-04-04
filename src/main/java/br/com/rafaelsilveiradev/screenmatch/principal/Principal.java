package br.com.rafaelsilveiradev.screenmatch.principal;

import br.com.rafaelsilveiradev.screenmatch.services.ConsumoAPI;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=123e42a0&";
    private final String SEASON = "&season=";

    public void exibeMenu(){
        System.out.println("Digite o nome da série para buscar: ");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ","+") + API_KEY);
    }
}
