package pt.ulusofona.lp2.fandeisiaGame;

import java.util.ArrayList;
import java.util.List;

public class FandeisiaGameManager {

    public String[][] getCreatureTypes() {
        /*Deve retornar os tipos de criatura que existem no jogo e que podem ser
        escolhidos para os exércitos dos dois jogadores.*/
        return null;
    }

    public void startGame(String[] content, int rows, int columns) {
       /* Deve inicializar as estruturas de dados relevantes para processar um jogo
       O array content irá descrever o conteúdo inicial do mundo (criaturas e
       tesouros), tendo para isso várias Strings. Cada String vai representar um objecto do mundo.
       Os argumentos rows e columns vão-nos indicar as dimensões do tabuleiro.*/

    }

    public void setInitialTeam(int teamId) {
        /*Indica qual das equipas vai jogar no primeiro turno do jogo.*/

    }

    public void processTurn() {
        /*Deve processar um turno do jogo considerando a equipa actual. Inclui o movimento das criaturas.*/

    }

    public List<Creature> getCreatures() {
        /*Devolve uma lista com todos os objectos Creature que existem no jogo.*/
        return null;
    }

    public boolean gameIsOver() {
        /*Deve devolver true caso já tenha sido alcançada uma das condições de paragem do jogo e false em caso contrário.*/
        return false;
    }

    public List<String> getAuthors() {
        /*Devolve uma lista de Strings com os nomes dos autores do projecto.*/
        List<String> authors = new ArrayList<>();
        String evora = ">Gonçalo Evora 21805468 Aka:ROKT";
        String martim = ">Martim Mourão 21805485 Aka:Mike";
        String deisi = "LP2 Enunciado By: Bruno Cipriano, Rodrigo Correia, Pedro Alves";
        authors.add(evora);
        authors.add(martim);
        authors.add(deisi);
        return authors;
    }

    public List<String> getResults() {
        /*Devolve uma lista de Strings que representem os resultados do jogo, conforme descrito na secção dos
          “Resultados da execução …”. Este método não pode devolver null. Caso não calculem a informação
           respectiva, devem devolver uma lista vazia.*/
        return null;
    }

    public int getElementId(int x, int y) {
        /*Deve devolver o ID do objecto/elemento que se encontra na posição indicada pelas coordenadas (x,y) passadas por
          argumento.*/
        return 0;
    }

    public int getCurrentTeamId() {
        /*Deve devolver o ID da equipa que está activa no turno actual.*/
        return 0;
    }

    public int getCurrentScore(int teamId) {
        /*Deve devolver o número actual de pontos da equipa que tem o ID teamID.*/
        return 0;
    }

}
