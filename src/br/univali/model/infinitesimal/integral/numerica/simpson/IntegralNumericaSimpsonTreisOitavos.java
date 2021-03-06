/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model.infinitesimal.integral.numerica.simpson;

import br.univali.model.funcoes.Funcao;
import br.univali.model.infinitesimal.integral.numerica.IntegralNumerica;
import java.util.Objects;

/**
 *
 * @author Alisson
 */
public class IntegralNumericaSimpsonTreisOitavos extends IntegralNumerica{

    public IntegralNumericaSimpsonTreisOitavos(Integer pontos, Double pontoInicial, Double pontoFinal, Funcao funcao) {
        super(pontos, pontoInicial, pontoFinal, funcao);
    }

    @Override
    public Double calcular() {
        Double resposta=0.0;
        int j=0;
        Double valorX = pontoInicial;
        for(int ponto_atual=0;ponto_atual<pontos;ponto_atual++){
            
            if(ponto_atual==0 || ponto_atual==pontos-1){
                resposta+=funcao.calcular(valorX);
            }else if(j%2==0){
                resposta+=2*funcao.calcular(valorX);
            }else{
                resposta+=3*(funcao.calcular(valorX)+funcao.calcular(valorX+h));
                valorX+=h;
                ponto_atual++;
            }
            valorX+=h;
            j++;
        }
        resposta= 3*(resposta*h)/8;
        return resposta;
    }
    
}
