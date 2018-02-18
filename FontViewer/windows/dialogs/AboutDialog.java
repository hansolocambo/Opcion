/*
  Opcion Font Viewer
  Copyright (C) 2004 Paul Chiu. All Rights Reserved.

  This program is free software; you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation; either version 2 of the License, or
  (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
*/

/*
 * AboutDialog.java
 *
 * Created on 1 February 2004, 15:55
 */
package FontViewer.windows.dialogs;
import FontViewer.components.*;

import java.io.*;
import javax.swing.*;

public class AboutDialog extends javax.swing.JDialog {
    private final String homepage = "http://opcion.sourceforge.net";
    private Icon logo;
    
    /** Creates new form AboutDialog */
    public AboutDialog(JFrame parent) {
        // Set parent
        super(parent);

        // Get logo
        ClassLoader cl = this.getClass().getClassLoader();
        logo = new ImageIcon(cl.getResource("FontViewer/resources/icons/Logo.gif"));
        
        // Initialize components
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        logoLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        homepagePanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        creditsPanel = new javax.swing.JPanel();
        creditsScrollPane = new javax.swing.JScrollPane();
        creditsTextArea = new TextAreaFromFile("credits.txt");
        licensesPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        copyrightLabel = new javax.swing.JLabel();

        setTitle("About");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        logoLabel.setIcon(logo);
        getContentPane().add(logoLabel, java.awt.BorderLayout.WEST);

        contentPanel.setLayout(new java.awt.BorderLayout());

        homepagePanel.setBorder(new javax.swing.border.TitledBorder(" Opcion Font Viewer v1.0.0 "));
        jButton1.setText("Visit Homepage");
        jButton1.setToolTipText(homepage);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        homepagePanel.add(jButton1);

        contentPanel.add(homepagePanel, java.awt.BorderLayout.NORTH);

        creditsPanel.setLayout(new javax.swing.BoxLayout(creditsPanel, javax.swing.BoxLayout.Y_AXIS));

        creditsPanel.setBorder(new javax.swing.border.TitledBorder(" Credits "));
        creditsScrollPane.setBorder(null);
        creditsTextArea.setBackground((java.awt.Color) javax.swing.UIManager.getDefaults().get("windowBorder"));
        creditsScrollPane.setViewportView(creditsTextArea);

        creditsPanel.add(creditsScrollPane);

        contentPanel.add(creditsPanel, java.awt.BorderLayout.CENTER);

        licensesPanel.setBorder(new javax.swing.border.TitledBorder(" Licenses "));
        jButton2.setText("Opcion License (GPL)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        licensesPanel.add(jButton2);

        jButton3.setText("JGoodies License (BSD)");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        licensesPanel.add(jButton3);

        contentPanel.add(licensesPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        copyrightLabel.setFont(new java.awt.Font("Dialog", 1, 10));
        copyrightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyrightLabel.setText("Copyright (c) 2004 Paul Chiu");
        getContentPane().add(copyrightLabel, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-470)/2, (screenSize.height-295)/2, 470, 295);
    }//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TextAreaFromFileDialog taffd = new TextAreaFromFileDialog((JFrame)this.getParent(), "JGoodies License", "jgoodiesLicense.txt");
        taffd.setWrap(false);
        taffd.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TextAreaFromFileDialog taffd = new TextAreaFromFileDialog((JFrame)this.getParent(), "Opcion License", "opcionLicense.txt");
        taffd.setWrap(false);
        taffd.show();        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        com.xlreader.shared.io.S_ToBrowserDefault.s_displayURL(homepage);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        this.dispose();
    }//GEN-LAST:event_exitForm
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel copyrightLabel;
    private javax.swing.JPanel creditsPanel;
    private javax.swing.JScrollPane creditsScrollPane;
    private javax.swing.JTextArea creditsTextArea;
    private javax.swing.JPanel homepagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel licensesPanel;
    private javax.swing.JLabel logoLabel;
    // End of variables declaration//GEN-END:variables
}