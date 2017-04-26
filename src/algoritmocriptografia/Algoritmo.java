/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmocriptografia;

import java.util.ArrayList;

/**
 *
 * @author josafa
 */
public class Algoritmo {

    public Algoritmo() {
        inserirLetras();
    }
    private ArrayList<String> alfabeto;

    public void inserirLetras() {
        alfabeto = new ArrayList<>();
        alfabeto.add("a");
        alfabeto.add("b");
        alfabeto.add("c");
        alfabeto.add("d");
        alfabeto.add("e");
        alfabeto.add("f");
        alfabeto.add("g");
        alfabeto.add("h");
        alfabeto.add("i");
        alfabeto.add("j");
        alfabeto.add("k");
        alfabeto.add("l");
        alfabeto.add("m");
        alfabeto.add("n");
        alfabeto.add("o");
        alfabeto.add("p");
        alfabeto.add("q");
        alfabeto.add("r");
        alfabeto.add("s");
        alfabeto.add("t");
        alfabeto.add("u");
        alfabeto.add("v");
        alfabeto.add("x");
        alfabeto.add("w");
        alfabeto.add("y");
        alfabeto.add("z");
    }

    /* Para criptografar o algoritmo quebra a string e cada caracter é deslocado 7 posições */
    public String criptografar(String textoPlano) {

        String[] textoSeparado = textoPlano.split("");
        StringBuilder textoDeslocadoSetePosicoes = new StringBuilder();
        int posicaoDaLetra = -1;

        for (String letra : textoSeparado) {

            posicaoDaLetra = alfabeto.indexOf(letra);
            int deslocamento = 7;
            int contador = 0;

            while (contador < deslocamento) {
                if (posicaoDaLetra < (alfabeto.size() - 1)) {
                    posicaoDaLetra++;
                    contador++;
                } else if (posicaoDaLetra == (alfabeto.size() - 1)) {
                    posicaoDaLetra = 0;
                    contador++;

                }
            }
            textoDeslocadoSetePosicoes.append(alfabeto.get(posicaoDaLetra));
        }

        String[] primeiroPassoSeparado = textoDeslocadoSetePosicoes.toString().split("");
        StringBuilder textoCriptografado = new StringBuilder();

        if (textoDeslocadoSetePosicoes.length() % 2 == 0) {
            int contador2 = 0;
            while (contador2 < primeiroPassoSeparado.length) {
                textoCriptografado.append(primeiroPassoSeparado[contador2 + 1]);
                textoCriptografado.append(primeiroPassoSeparado[contador2]);
                contador2 += 2;
            }

        } else {

            int contador2 = 0;
            while (contador2 < primeiroPassoSeparado.length) {
                if (contador2 < (primeiroPassoSeparado.length - 1)) {
                    textoCriptografado.append(primeiroPassoSeparado[contador2 + 1]);
                    textoCriptografado.append(primeiroPassoSeparado[contador2]);
                    contador2 += 2;
                } else {
                    textoCriptografado.append(primeiroPassoSeparado[contador2]);
                    contador2++;
                }

            }
        }
        return textoCriptografado.toString();

    }
    
    public String descriptografar(String textoCriptografado){
        StringBuilder textoRealocadoSetePosicoes = new StringBuilder();
        StringBuilder textoDescriptografado = new StringBuilder();
        
        String[] primeiroPasso = textoCriptografado.split("");
        int i = primeiroPasso.length;
         if (primeiroPasso.length % 2 == 0) {
            int contador2 = 0;
            while (contador2 < primeiroPasso.length) {
                
                textoRealocadoSetePosicoes.append(primeiroPasso[contador2 + 1]);
                textoRealocadoSetePosicoes.append(primeiroPasso[contador2]);
                
                contador2 += 2;
            }

        } else {

            int contador2 = 0;
            while (contador2 < primeiroPasso.length) {
                if (contador2 < (primeiroPasso.length - 1)) {
                    
                    textoRealocadoSetePosicoes.append(primeiroPasso[contador2 + 1]);
                    textoRealocadoSetePosicoes.append(primeiroPasso[contador2]);
                    
                    contador2 += 2;
                } else {
                    textoRealocadoSetePosicoes.append(primeiroPasso[contador2]);
                    contador2++;
                }

            }
        }
         
         String [] textoRealocadoSetePosicoesSeparado = textoRealocadoSetePosicoes.toString().split("");
         int posicaoDaLetra = 0;
         for (String letra : textoRealocadoSetePosicoesSeparado) {

            posicaoDaLetra = alfabeto.indexOf(letra);
            String a = letra;
            int deslocamento = 0;
            int contador = 7;

            while (contador > deslocamento) {
                if (posicaoDaLetra <= (alfabeto.size() - 1) && posicaoDaLetra > 0) {
                    posicaoDaLetra--;
                    contador--;
                } else if (posicaoDaLetra == 0) {
                    posicaoDaLetra = 25;
                    contador--;

                }
            }
            textoDescriptografado.append(alfabeto.get(posicaoDaLetra));
        }

        return textoDescriptografado.toString();
    }
}
