package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        // Configuracao inicial da lista
        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Ana");
        list.add("Joao");

        list.add(2, "Marcos");

        System.out.println(list.size());

        // Criando a lista utilizando for Each
        for (String x : list) {
            System.out.println(x);
        }

        // Removendo elementos que comecem com a letra M da lista!
        System.out.println("----------------");
        list.removeIf(x -> x.charAt(0) == 'M');

        for (String x : list) {
            System.out.println(x);
        }


        // Verificando o indice de alguma posicao da Lista
        System.out.println("----------------");
        System.out.println("index of Bob: " + list.indexOf("Bob"));
        System.out.println("index of Marco: " + list.indexOf("Marco"));


        // Filtrando os elementos de uma lista
        System.out.println("----------------");
        List<String> result = list.stream().filter(x -> x.charAt(0) =='A').collect(Collectors.toList());
        for (String x : result) {
            System.out.println(x);
        }

        // Encontrando o primeiro elemento que atenda o predicado
        System.out.println("----------------");
        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
        System.out.println(name);

    }
}
