package br.com.rafaelsilveiradev.screenmatch.principal;

import br.com.rafaelsilveiradev.screenmatch.model.DadosSerie;
import br.com.rafaelsilveiradev.screenmatch.model.DadosTemporadas;
import br.com.rafaelsilveiradev.screenmatch.services.ConsumoAPI;
import br.com.rafaelsilveiradev.screenmatch.services.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();


    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=123e42a0&";
    private final String SEASON = "&season=";

    public void exibeMenu(){
        System.out.println("Digite o nome da série para buscar: ");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ","+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporadas> temporadas = new ArrayList<>();

		for (int i = 1; i < dados.totalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + SEASON + i + API_KEY);
			DadosTemporadas dadosTemporadas = conversor.obterDados(json, DadosTemporadas.class);
			temporadas.add(dadosTemporadas);
		}
		temporadas.forEach(System.out::println);
    }
}
