/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model.equacao_diferencial.euler;

import br.univali.model.funcoes.Funcao_Euler;
import br.univali.model.minimos_quadrados.Point;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adson Estevesa
 */
public class EquacaoDiferencialMetododeEulerModificado extends MetododeEuler{
    
    public EquacaoDiferencialMetododeEulerModificado(Double y0, Funcao_Euler funcao, Double h, Double xInicial, Double xFinal) {
        super(y0, funcao, h, xInicial, xFinal);
    }

    public List<Point> calcular(){
        List<Point> points = new ArrayList<>();;
        points.add(new Point(xInicial, y0));
        int j=1;
        for(Double i=xInicial+h;i<=xFinal;i+=h){
            i= new BigDecimal(i).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
            Double y=points.get(j-1).getY()+h*funcao.calcular((i-h)+(h/2), ((points.get(j-1).getY())+((h*funcao.calcular(i-h, points.get(j-1).getY()))/2)));            
            points.add(new Point(i, y));
            j++;
        }
        return points;
    }
}
