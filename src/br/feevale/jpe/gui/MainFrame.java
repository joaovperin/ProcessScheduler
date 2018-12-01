/*
 * Copyright (C) 2018 joaovperin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.feevale.jpe.gui;

import br.feevale.jpe.core.SchedulerImpl;
import br.feevale.jpe.bean.Process;
import br.feevale.jpe.core.Scheduler;

/**
 * Main frame of the GUI
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form SISOPInterface
     */
    public MainFrame() {
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

        timeBox = new javax.swing.JComboBox<>();
        lblTime = new javax.swing.JLabel();
        lblPriority = new javax.swing.JLabel();
        priorityBox = new javax.swing.JComboBox<>();
        btAddProcess = new javax.swing.JButton();
        labelProcessCount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        quantumBox = new javax.swing.JComboBox<>();
        lblQuantum = new javax.swing.JLabel();
        labelCurrentTime = new javax.swing.JLabel();
        btAddProcess1 = new javax.swing.JButton();
        btAddProcess2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        timeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50" }));

        lblTime.setText("Time");

        lblPriority.setText("Priority");

        priorityBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        btAddProcess.setText("Add Process");
        btAddProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddProcessActionPerformed(evt);
            }
        });

        labelProcessCount.setText("Processes Count: 0");

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        jScrollPane1.setViewportView(outputTextArea);

        quantumBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        quantumBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                quantumBoxItemStateChanged(evt);
            }
        });

        lblQuantum.setText("Quantum");

        labelCurrentTime.setText("Current Time: 0");

        btAddProcess1.setText("Start");
        btAddProcess1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddProcess1ActionPerformed(evt);
            }
        });

        btAddProcess2.setText("Stop");
        btAddProcess2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddProcess2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTime))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(priorityBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAddProcess))
                            .addComponent(lblPriority))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelProcessCount, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(labelCurrentTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantum)
                            .addComponent(quantumBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAddProcess2)
                            .addComponent(btAddProcess1))
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime)
                    .addComponent(lblPriority)
                    .addComponent(lblQuantum)
                    .addComponent(labelCurrentTime)
                    .addComponent(btAddProcess1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priorityBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAddProcess)
                    .addComponent(labelProcessCount)
                    .addComponent(quantumBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAddProcess2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddProcessActionPerformed
        // TODO add your handling code here:
        Integer time = Integer.parseInt(timeBox.getSelectedItem().toString());
        Integer priority = Integer.parseInt(priorityBox.getSelectedItem().toString());
        Integer pid = scheduler.nextPid();
        Integer currentTime = scheduler.getCurrentTime();
        Process p = new Process(pid, priority, time, currentTime);
        scheduler.addProcess(p);
    }//GEN-LAST:event_btAddProcessActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        scheduler = new SchedulerImpl();
        scheduler.startRunning();
    }//GEN-LAST:event_formWindowOpened

    private void quantumBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_quantumBoxItemStateChanged
        Integer quantum = Integer.parseInt(quantumBox.getSelectedItem().toString());
        scheduler.setQuantum(quantum);
    }//GEN-LAST:event_quantumBoxItemStateChanged

    private void btAddProcess1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddProcess1ActionPerformed
        scheduler.startScheduler();
    }//GEN-LAST:event_btAddProcess1ActionPerformed

    private void btAddProcess2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddProcess2ActionPerformed
        scheduler.stopScheduler();
    }//GEN-LAST:event_btAddProcess2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddProcess;
    private javax.swing.JButton btAddProcess1;
    private javax.swing.JButton btAddProcess2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel labelCurrentTime;
    public static javax.swing.JLabel labelProcessCount;
    private javax.swing.JLabel lblPriority;
    private javax.swing.JLabel lblQuantum;
    private javax.swing.JLabel lblTime;
    public static javax.swing.JTextArea outputTextArea;
    private javax.swing.JComboBox<String> priorityBox;
    private javax.swing.JComboBox<String> quantumBox;
    private javax.swing.JComboBox<String> timeBox;
    // End of variables declaration//GEN-END:variables
    Scheduler scheduler;
}
