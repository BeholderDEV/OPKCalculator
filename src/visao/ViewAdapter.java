/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import minimos_quadrados.Point;

/**
 *
 * @author Alisson
 */
public class ViewAdapter {
    
    public static Double[][] stringToMatrix(String tamanho, String matriz){
        Scanner sc = new Scanner(tamanho);
        int numberOfEquations = sc.nextInt();
        sc = new Scanner(matriz);
        Double matrix[][] = new Double[numberOfEquations][numberOfEquations+1];
        int j = 0;
        do  {
            for (int i = 0; i <= numberOfEquations; i++){
                matrix[j][i] = sc.nextDouble();
            }
            j++;
        } while (sc.hasNextLine());
        return matrix;
    }
    
    /**
     *
     * @param matrizExpandida
     * @param vetorSolucao
     * @return
     */
    public static String matrixToString(Double[][] matrizExpandida){
        int linhas = matrizExpandida.length;
        int colunas = matrizExpandida[0].length;
        String matrizEscalonada = "";
        //Escreve a matriz expandida do sistema no formato decimal definido em df.
        for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                        if ( !(j == colunas-1) )
                                matrizEscalonada += matrizExpandida[i][j] + " ";	
                        else matrizEscalonada += "| "+matrizExpandida[i][j];
                }
                matrizEscalonada += "\n";
        }
        
        return "Matriz escalonada:\n"+ matrizEscalonada;
    }
    
    public static String vetorSolucaoToString(Double[] vetorSolucao){
        String vetorFinal = "";
        //Escreve o vetor solucao do sistema no formato decimal definido em df.
        for (int i = 0; i < vetorSolucao.length; i++) {
                if ( !(i == vetorSolucao.length) )
                {
                    vetorFinal +=vetorSolucao[i]+"; ";
                }
                else{
                    vetorFinal +=vetorSolucao[i];
                }
        }
        vetorFinal = vetorFinal.substring(0, vetorFinal.length()-2);
        return vetorFinal;
    }
    public static List<Point> stringsToPoints(String stringXs, String stringYs){
        List<Point> points= new ArrayList<>();
        Scanner sx = new Scanner(stringXs);
        Scanner sy = new Scanner(stringYs);
        do  {
            Double tempx = sx.nextDouble();
            Double tempy = sy.nextDouble();
            points.add(new Point(tempx, tempy));
        } while (sx.hasNext());
        return points;
    }
    
    public static String doubleVectorToString(Double[] doubles){
        String resposta = "";
        
        for (int i = 0; i < doubles.length; i++){
            resposta+="a"+i+" = "+doubles[i]+"\n";
        }
        
        
        return resposta;
    }
        
    public static String doubleVectorEquation(Double[] doubles){
        String resposta = "";
       
        for (int i =  doubles.length-1; i >= 0; i--){
            if(doubles[i]!=0){
                resposta+=doubles[i];
                if(i>0){
                    resposta+=" x^"+i+" + ";
                }
            }
        }
        
        resposta = resposta.replace("+ -", "- ");
        return resposta;
    }
}
