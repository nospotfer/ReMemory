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
public class UBE extends Test {

    /**
     * Creates new form Test
     *
     * @param pacientActual
     */
    public UBE(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "UBE";
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

        ubeScroll = new javax.swing.JScrollPane();
        ubePanel = new javax.swing.JPanel();
        ubeFoto = new javax.swing.JLabel();

        ubeFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/alcohol.png"))); // NOI18N

        javax.swing.GroupLayout ubePanelLayout = new javax.swing.GroupLayout(ubePanel);
        ubePanel.setLayout(ubePanelLayout);
        ubePanelLayout.setHorizontalGroup(
            ubePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ubePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ubeFoto)
                .addContainerGap())
        );
        ubePanelLayout.setVerticalGroup(
            ubePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ubePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ubeFoto)
                .addContainerGap())
        );

        ubeScroll.setViewportView(ubePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ubeScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ubeScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ubeFoto;
    private javax.swing.JPanel ubePanel;
    private javax.swing.JScrollPane ubeScroll;
    // End of variables declaration//GEN-END:variables
}
