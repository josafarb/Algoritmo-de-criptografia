package algoritmocriptografia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josafa
 */
public class AlgoritmoCriptografia {

    ArrayList<String> alfabeto = new ArrayList<>();

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String textoPlano = leitor.next();
        Algoritmo algoritmo = new Algoritmo();
        String retorno = algoritmo.criptografar(textoPlano.toLowerCase());
        System.out.println("Texto criptografado : " + retorno);
        System.out.println("Texto descriptografado " + algoritmo.descriptografar(retorno));

    }

}
