/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miComponenteTexto;

/**
 *
 * @author Luis
 */
public class editorTipo extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;

    /**
     * Creates new customizer editorTipo
     */
    public editorTipo() {
        initComponents();
    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbTipo = new javax.swing.JComboBox<>();
        jLtipo = new javax.swing.JLabel();

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entero", "Real", "Texto", "SN", "Alfanumérico" }));

        jLtipo.setText("tipo de dato:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLtipo)
                .addGap(18, 18, 18)
                .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLtipo)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLtipo;
    protected javax.swing.JComboBox<String> jcbTipo;
    // End of variables declaration//GEN-END:variables
}
