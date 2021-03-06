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
 * SampleTextPanel.java
 *
 * Created on 21 February 2004, 18:40
 */
package FontViewer.components;
import FontViewer.windows.*;

import java.io.*;
import java.awt.*;
import java.util.*;
import java.lang.ref.*;
import javax.swing.*;
import javax.swing.text.*;

public class SampleTextPanel extends javax.swing.JPanel {
    // Constants
    private final int BOLD = 0;
    private final int ITALIC = 1;
    private final int UNDERLINE = 2;
    
    private Vector<Integer> fontSizes;
    private String sampleText;
    
    // Font info
    private String fname;
    private String floc;
    private int fsize;
    
    // Font properties
    private boolean[] fontProperties = {false, false, false};
    
    // Parent
    private MainWindow mw;
    
    /** Creates new form SampleTextPanel */
    public SampleTextPanel(MainWindow mw, int[] sizes) {
        this.mw = mw;
        sampleText = java.util.ResourceBundle.getBundle("FontViewer.resources.Opcion").getString("defaultSampleText");

        initFontSizes(sizes);
        initComponents();
        
        // Set default settings
        fname = "Default";
        floc = "System Font";
        fontSizeComboBox.setSelectedItem(fontSizes.get(9));
    }
    
    private void initFontSizes(int[] sizes) {
        fontSizes = new Vector<>(sizes.length);
        
        for (int i=0; i<sizes.length; i++) {
            fontSizes.add(new Integer(sizes[i]));
        }
    }
    
    public void setSampleText(String s) {
        sampleText = s;
        previewTextPane.setText(sampleText);
    }

    public void setCurrentFont(String name, String loc) {
        fname = name;
        floc = loc;
        
        if (!loc.equals("System Font")) {
            try {
                Font chosenFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(loc + File.separator + fname));
                WeakReference<Font> wrf = new WeakReference<>(chosenFont);
                fname = ((Font)wrf.get()).getName();
            } catch (Exception e) {
                new JOptionPane().showMessageDialog(this, "Error loading font.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        updateDisplay();
    }
    
    public void setFavButtonAction(String action) {
        addFavouritesButton.setText(action);
    }
    
    private void updateDisplay() {
        // Set font name
        fontName.setText(fname);
        fontName.setToolTipText(fname);
        
        // Set document style
        Style s = previewTextPane.getStyle("default");
        StyleConstants.setFontFamily(s, fname);
        StyleConstants.setFontSize(s, fsize);
        StyleConstants.setBold(s, fontProperties[BOLD]);
        StyleConstants.setItalic(s, fontProperties[ITALIC]);
        StyleConstants.setUnderline(s, fontProperties[UNDERLINE]);
        
        // Update text pane
        previewTextPane.setParagraphAttributes(s, true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        previewTextPaneScollPane = new javax.swing.JScrollPane();
        previewTextPane = new AATextPane();
        topPanel = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        fontPropertiesPanel = new javax.swing.JPanel();
        boldButton = new javax.swing.JToggleButton();
        italicsButton = new javax.swing.JToggleButton();
        underlineButton = new javax.swing.JToggleButton();
        addFavouritesButton = new javax.swing.JButton();
        fontInfoPanel = new javax.swing.JPanel();
        fontSizePanel = new javax.swing.JPanel();
        fontSizeLabel = new javax.swing.JLabel();
        fontSizeComboBox = new JComboBox<>(fontSizes);
        fontName = new javax.swing.JLabel();
        fontNameLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout(2, 2));

        setBorder(new javax.swing.border.TitledBorder(" Sample Text "));
        previewTextPaneScollPane.setBorder(null);
        previewTextPane.setBorder(null);
        previewTextPane.setEditable(false);
        previewTextPane.setText(sampleText);
        previewTextPaneScollPane.setViewportView(previewTextPane);

        add(previewTextPaneScollPane, java.awt.BorderLayout.CENTER);

        topPanel.setLayout(new java.awt.GridLayout(2, 0, 0, 2));

        topPanel.setPreferredSize(new java.awt.Dimension(10, 42));
        optionsPanel.setLayout(new java.awt.BorderLayout(2, 2));

        optionsPanel.setPreferredSize(new java.awt.Dimension(10, 24));
        fontPropertiesPanel.setLayout(new java.awt.GridLayout(1, 3, 2, 0));

        fontPropertiesPanel.setPreferredSize(new java.awt.Dimension(64, 20));
        boldButton.setText("B");
        boldButton.setToolTipText("Bold");
        boldButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        boldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boldButtonActionPerformed(evt);
            }
        });

        fontPropertiesPanel.add(boldButton);

        italicsButton.setFont(new java.awt.Font("Dialog", 3, 12));
        italicsButton.setText("I");
        italicsButton.setToolTipText("Italic");
        italicsButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        italicsButton.setPreferredSize(new java.awt.Dimension(20, 20));
        italicsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                italicsButtonActionPerformed(evt);
            }
        });

        fontPropertiesPanel.add(italicsButton);

        underlineButton.setText("U");
        underlineButton.setToolTipText("Underline");
        underlineButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        underlineButton.setPreferredSize(new java.awt.Dimension(20, 20));
        underlineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                underlineButtonActionPerformed(evt);
            }
        });

        fontPropertiesPanel.add(underlineButton);

        optionsPanel.add(fontPropertiesPanel, java.awt.BorderLayout.WEST);

        addFavouritesButton.setText("Add to Favourites");
        addFavouritesButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        addFavouritesButton.setPreferredSize(new java.awt.Dimension(130, 20));
        addFavouritesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFavouritesButtonActionPerformed(evt);
            }
        });

        optionsPanel.add(addFavouritesButton, java.awt.BorderLayout.EAST);

        topPanel.add(optionsPanel);

        fontInfoPanel.setLayout(new java.awt.BorderLayout(2, 2));

        fontSizePanel.setLayout(new java.awt.GridLayout(1, 2));

        fontSizePanel.setPreferredSize(new java.awt.Dimension(112, 24));
        fontSizeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        fontSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fontSizeLabel.setText("Font Size: ");
        fontSizePanel.add(fontSizeLabel);

        fontSizeComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        fontSizeComboBox.setPreferredSize(new java.awt.Dimension(31, 24));
        fontSizeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fontSizeComboBoxItemStateChanged(evt);
            }
        });

        fontSizePanel.add(fontSizeComboBox);

        fontInfoPanel.add(fontSizePanel, java.awt.BorderLayout.EAST);

        fontName.setFont(new java.awt.Font("Dialog", 0, 12));
        fontName.setText("No font selected");
        fontInfoPanel.add(fontName, java.awt.BorderLayout.CENTER);

        fontNameLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        fontNameLabel.setText("Font Name: ");
        fontInfoPanel.add(fontNameLabel, java.awt.BorderLayout.WEST);

        topPanel.add(fontInfoPanel);

        add(topPanel, java.awt.BorderLayout.NORTH);

    }//GEN-END:initComponents

    private void fontSizeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fontSizeComboBoxItemStateChanged
        fsize = ((Integer)fontSizes.get(fontSizeComboBox.getSelectedIndex())).intValue();
        updateDisplay();
        mw.setFontSize(fsize);
    }//GEN-LAST:event_fontSizeComboBoxItemStateChanged

    private void underlineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_underlineButtonActionPerformed
        fontProperties[UNDERLINE] = underlineButton.isSelected();
        updateDisplay();
    }//GEN-LAST:event_underlineButtonActionPerformed

    private void italicsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_italicsButtonActionPerformed
        fontProperties[ITALIC] = italicsButton.isSelected();
        updateDisplay();
    }//GEN-LAST:event_italicsButtonActionPerformed

    private void boldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boldButtonActionPerformed
        fontProperties[BOLD] = boldButton.isSelected();
        updateDisplay();
    }//GEN-LAST:event_boldButtonActionPerformed

    private void addFavouritesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFavouritesButtonActionPerformed
        if (addFavouritesButton.getText().charAt(0) == 'A') {
            mw.addToFav();
        } else {
            mw.removeFromFav();
        }
    }//GEN-LAST:event_addFavouritesButtonActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        // Do nothing
    }//GEN-LAST:event_exitForm
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFavouritesButton;
    private javax.swing.JToggleButton boldButton;
    private javax.swing.JPanel fontInfoPanel;
    private javax.swing.JLabel fontName;
    private javax.swing.JLabel fontNameLabel;
    private javax.swing.JPanel fontPropertiesPanel;
    private javax.swing.JComboBox<Integer> fontSizeComboBox;
    private javax.swing.JLabel fontSizeLabel;
    private javax.swing.JPanel fontSizePanel;
    private javax.swing.JToggleButton italicsButton;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JTextPane previewTextPane;
    private javax.swing.JScrollPane previewTextPaneScollPane;
    private javax.swing.JPanel topPanel;
    private javax.swing.JToggleButton underlineButton;
    // End of variables declaration//GEN-END:variables
}