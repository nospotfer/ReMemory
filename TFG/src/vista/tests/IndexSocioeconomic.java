/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import model.Pacient;

/**
 *
 * @author a630703
 */
public class IndexSocioeconomic extends Test {

    /**
     * Creates new form Test
     *
     * @param pacientActual
     */
    public IndexSocioeconomic(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "Índex socioeconòmic";
        numPaginesTotal = this.getComponentCount();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        indexSocioeconomicScroll = new javax.swing.JScrollPane();
        indexSocioeconomicPanel = new javax.swing.JPanel();
        indexSocioeconomicFoto = new javax.swing.JLabel();

        indexSocioeconomicFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/socioeconomic.png"))); // NOI18N

        javax.swing.GroupLayout indexSocioeconomicPanelLayout = new javax.swing.GroupLayout(indexSocioeconomicPanel);
        indexSocioeconomicPanel.setLayout(indexSocioeconomicPanelLayout);
        indexSocioeconomicPanelLayout.setHorizontalGroup(
            indexSocioeconomicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexSocioeconomicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(indexSocioeconomicFoto)
                .addContainerGap())
        );
        indexSocioeconomicPanelLayout.setVerticalGroup(
            indexSocioeconomicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexSocioeconomicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(indexSocioeconomicFoto)
                .addContainerGap())
        );

        indexSocioeconomicScroll.setViewportView(indexSocioeconomicPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(indexSocioeconomicScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(indexSocioeconomicScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel indexSocioeconomicFoto;
    private javax.swing.JPanel indexSocioeconomicPanel;
    private javax.swing.JScrollPane indexSocioeconomicScroll;
    // End of variables declaration//GEN-END:variables
}