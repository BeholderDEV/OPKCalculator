/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.visao.panels;

import br.univali.model.interpolacao.Interpolacao;
import br.univali.visao.JGraph;
import br.univali.visao.UI;
import br.univali.visao.ViewAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alisson
 */
public class InterpolacaoPanel extends javax.swing.JPanel {

    /**
     * Creates new form InterpolacaoPanel
     */
    public InterpolacaoPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        areaInterpolacao = new javax.swing.JTextArea();
        jPanel36 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        xzesInterpolacao = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        yonsInterpolacao = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tipoFuncaoInterpolacao = new javax.swing.JComboBox();
        jPanel33 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        setLayout(new java.awt.BorderLayout(4, 4));

        areaInterpolacao.setColumns(20);
        areaInterpolacao.setRows(5);
        jScrollPane5.setViewportView(areaInterpolacao);

        add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel36.setLayout(new java.awt.BorderLayout(4, 4));

        jPanel35.setLayout(new java.awt.BorderLayout(4, 4));

        jPanel30.setLayout(new java.awt.BorderLayout(4, 4));

        jLabel6.setText("X dos pontos");
        jPanel30.add(jLabel6, java.awt.BorderLayout.WEST);
        jPanel30.add(xzesInterpolacao, java.awt.BorderLayout.CENTER);

        jPanel35.add(jPanel30, java.awt.BorderLayout.NORTH);

        jPanel31.setLayout(new java.awt.BorderLayout(4, 4));

        jLabel9.setText("Y dos pontos");
        jPanel31.add(jLabel9, java.awt.BorderLayout.WEST);
        jPanel31.add(yonsInterpolacao, java.awt.BorderLayout.CENTER);

        jPanel35.add(jPanel31, java.awt.BorderLayout.SOUTH);

        jPanel36.add(jPanel35, java.awt.BorderLayout.NORTH);

        jPanel34.setLayout(new java.awt.BorderLayout(4, 4));

        jPanel32.setLayout(new java.awt.BorderLayout(4, 4));

        jLabel10.setText("Tipo de Interpolação");
        jPanel32.add(jLabel10, java.awt.BorderLayout.WEST);

        tipoFuncaoInterpolacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Polinomial", "SPline" }));
        jPanel32.add(tipoFuncaoInterpolacao, java.awt.BorderLayout.CENTER);

        jPanel34.add(jPanel32, java.awt.BorderLayout.CENTER);

        jPanel33.setLayout(new java.awt.BorderLayout(4, 4));

        jToggleButton1.setText("Grafico");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel33.add(jToggleButton1, java.awt.BorderLayout.WEST);

        jButton5.setText("Calcular");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel33.add(jButton5, java.awt.BorderLayout.CENTER);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/resources/interrogation.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel33.add(jButton4, java.awt.BorderLayout.EAST);

        jPanel34.add(jPanel33, java.awt.BorderLayout.EAST);

        jPanel36.add(jPanel34, java.awt.BorderLayout.SOUTH);

        add(jPanel36, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String stringXs=xzesInterpolacao.getText().toString();
        String stringYs=yonsInterpolacao.getText().toString();

        JGraph graph =new JGraph(ViewAdapter.stringsToPoints(stringXs, stringYs),ViewAdapter.stringsToPoints(stringXs, stringYs));
        try {
            graph.showHTML();
        } catch (Exception ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String stringXs=xzesInterpolacao.getText().toString();
        String stringYs=yonsInterpolacao.getText().toString();
        String tipodeInterpolacao = tipoFuncaoInterpolacao.getSelectedItem().toString();
        Interpolacao interpolacao= new Interpolacao(ViewAdapter.stringsToPoints(stringXs, stringYs), tipodeInterpolacao);
        String textoResposta="";

        if(tipodeInterpolacao.equals("SPline"))
        {
            textoResposta+=ViewAdapter.doubleVectorEquations(interpolacao.getList(), interpolacao.getFunctions());
        }
        else
        {
            textoResposta += ViewAdapter.doubleVectorToString(interpolacao.getList());
        }
        textoResposta+="\nMatriz Inicial: \n";
        textoResposta+=ViewAdapter.matrixToString(interpolacao.getMatrizInicial());
        textoResposta+="\nMatriz Escalonada: \n";
        textoResposta+=ViewAdapter.matrixToString(interpolacao.getMatrizEscalonada());
        areaInterpolacao.setText(textoResposta);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String tipoInterpolacao = tipoFuncaoInterpolacao.getSelectedItem().toString();
        if(tipoInterpolacao.equals("SPline")){
            xzesInterpolacao.setText("1 3 5 10 12 15 18 20 30");
            yonsInterpolacao.setText("2 4 6 20 2 24 88 38 1");
        }
        else if(tipoInterpolacao.equals("Polinomial"))
        {
            xzesInterpolacao.setText("1 3 4 5");
            yonsInterpolacao.setText("-1 0 1 1 -1");
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaInterpolacao;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox tipoFuncaoInterpolacao;
    private javax.swing.JTextField xzesInterpolacao;
    private javax.swing.JTextField yonsInterpolacao;
    // End of variables declaration//GEN-END:variables
}
