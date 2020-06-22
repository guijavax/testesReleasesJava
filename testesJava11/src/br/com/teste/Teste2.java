package br.com.teste;

import java.util.stream.Collectors;

public class Teste2 {

    public static void main(String ... args) {

        String str = "Guilherme\nAlves\nCarneiro\nBorges\n";
        System.out.print(str);

        System.out.println(str.lines().collect(Collectors.toUnmodifiableList()));

    }
}
