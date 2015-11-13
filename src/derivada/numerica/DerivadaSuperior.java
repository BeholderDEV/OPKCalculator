/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derivada.numerica;

import funcoes.Funcao;

/**
 *
 * @author 5663296
 */
public class DerivadaSuperior extends DerivadaNumerica{

    public DerivadaSuperior(Double x, Double h, Funcao funcao) {
        super(x, h, funcao);
    }

    @Override
    public Double calcular() {
        return (funcao.calcular(x-h)-funcao.calcular(x))/(h);
    }
    
}