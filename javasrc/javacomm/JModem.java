import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * JModem - simple communications program.
 * WARNING this file was built with the NetBeans Developer IDE
 * and parts of it should not be modified with a text editor.
 * @author    Ian F. Darwin, http://www.darwinsys.com/
 * @version   $Id: JModem.java,v 1.18 2004/04/11 23:50:40 ian Exp $
 */
public class JModem extends javax.swing.JFrame {

  /** The Model. */
  JMModel theModel;

  /** The TextArea */
  JTextArea theTextArea;
  /** The courier font for the text areas and fields. */
  protected Font plainFont;
  /** The valid baud rates (actually BPS rates). */
  private int[] baudot = { 9600, 19200, 38400, 57600, 115200 };
  /** The types of remote systems. */
  private String sysTypes[] = { "Unix", "DOS", "Other" };

  private int M_RECEIVE = -1, M_SEND = +1;
  private int xferDirection = M_RECEIVE;

  /** Constructor */
  public JModem() {
    theModel = new JMModel(this);
    initComponents();
    finishConstructor();
    pack();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the FormEditor.
   */
  private void initComponents () {//GEN-BEGIN:initComponents
    setTitle ("JModem");
    addWindowListener (new java.awt.event.WindowAdapter () {
        public void windowClosing (java.awt.event.WindowEvent evt) {
          exitForm (evt);
        }
      }
    );
    getContentPane ().setLayout (new java.awt.BorderLayout ());

    jMenuBar1 = new javax.swing.JMenuBar ();
      fileMenu = new javax.swing.JMenu ();
      fileMenu.setText ("File");
        saveLogFileMenuItem = new javax.swing.JMenuItem ();
        saveLogFileMenuItem.setText ("Save Log");
        saveLogFileMenuItem.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              saveLogFileMenuItemActionPerformed (evt);
            }
          }
        );
        fileMenu.add(saveLogFileMenuItem);

        fileMenu.addSeparator();

        exitMenuItem = new javax.swing.JMenuItem ();
        exitMenuItem.setText ("Exit");
        exitMenuItem.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              exitMenuItemActionPerformed (evt);
            }
          }
        );
        fileMenu.add(exitMenuItem);

      jMenuBar1.add(fileMenu);

      helpMenu = new javax.swing.JMenu ();
      helpMenu.setText ("Help");
        helpAboutMenuItem = new javax.swing.JMenuItem ();
        helpAboutMenuItem.setText ("Item");
        helpAboutMenuItem.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              helpAboutMenuItemActionPerformed (evt);
            }
          }
        );
        helpMenu.add(helpAboutMenuItem);

      jMenuBar1.add(helpMenu);


    setJMenuBar(jMenuBar1);
    connectPanel = new javax.swing.JPanel ();
    connectPanel.setLayout (new java.awt.FlowLayout ());

      connectPanelLabel = new javax.swing.JLabel ();
      connectPanelLabel.setText ("Connection");
      connectPanelLabel.setForeground (java.awt.Color.red);
      connectPanel.add (connectPanelLabel);

      portsLabel = new javax.swing.JLabel ();
      portsLabel.setText ("Port:");
      connectPanel.add (portsLabel);

      portsComboBox = new javax.swing.JComboBox ();
      portsComboBox.addActionListener (new java.awt.event.ActionListener () {
          public void actionPerformed (java.awt.event.ActionEvent evt) {
            portsComboBoxActionPerformed (evt);
          }
        }
      );
      connectPanel.add (portsComboBox);

      buadLabel = new javax.swing.JLabel ();
      buadLabel.setText ("Speed");
      connectPanel.add (buadLabel);

      baudComboBox = new javax.swing.JComboBox ();
      baudComboBox.addActionListener (new java.awt.event.ActionListener () {
          public void actionPerformed (java.awt.event.ActionEvent evt) {
            baudComboBoxActionPerformed (evt);
          }
        }
      );
      connectPanel.add (baudComboBox);

      databitsPanel = new javax.swing.JPanel ();
      databitsPanel.setPreferredSize (new java.awt.Dimension(50, 50));
      databitsPanel.setMinimumSize (new java.awt.Dimension(0, 0));
      databitsPanel.setLayout (new javax.swing.BoxLayout (databitsPanel, 1));

        d7RadioButton = new javax.swing.JRadioButton ();
        d7RadioButton.setText ("7");
        databitsPanel.add (d7RadioButton);

        d8RadioButton = new javax.swing.JRadioButton ();
        d8RadioButton.setSelected (true);
        d8RadioButton.setText ("8");
        databitsPanel.add (d8RadioButton);

      connectPanel.add (databitsPanel);

      parityPanel = new javax.swing.JPanel ();
      parityPanel.setPreferredSize (new java.awt.Dimension(50, 50));
      parityPanel.setLayout (new javax.swing.BoxLayout (parityPanel, 1));

        pNoneRadioButton = new javax.swing.JRadioButton ();
        pNoneRadioButton.setSelected (true);
        pNoneRadioButton.setText ("None");
        pNoneRadioButton.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              pNoneRadioButtonActionPerformed (evt);
            }
          }
        );
        parityPanel.add (pNoneRadioButton);

        pEvenRadioButton = new javax.swing.JRadioButton ();
        pEvenRadioButton.setText ("Even");
        pEvenRadioButton.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              evenRadioButtonActionPerformed (evt);
            }
          }
        );
        parityPanel.add (pEvenRadioButton);

        pOddRadioButton = new javax.swing.JRadioButton ();
        pOddRadioButton.setText ("Odd");
        pOddRadioButton.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              oddRadioButtonActionPerformed (evt);
            }
          }
        );
        parityPanel.add (pOddRadioButton);

      connectPanel.add (parityPanel);

      sysTypeLabel = new javax.swing.JLabel ();
      sysTypeLabel.setText ("Remote:");
      connectPanel.add (sysTypeLabel);

      sysTypeComboBox = new javax.swing.JComboBox ();
      sysTypeComboBox.addActionListener (new java.awt.event.ActionListener () {
          public void actionPerformed (java.awt.event.ActionEvent evt) {
            sysTypeComboBoxActionPerformed (evt);
          }
        }
      );
      connectPanel.add (sysTypeComboBox);

      connectButton = new javax.swing.JButton ();
      connectButton.setText ("Connect");
      connectButton.addActionListener (new java.awt.event.ActionListener () {
          public void actionPerformed (java.awt.event.ActionEvent evt) {
            connectButtonActionPerformed (evt);
          }
        }
      );
      connectPanel.add (connectButton);

    getContentPane().add(connectPanel, BorderLayout.NORTH);

    xferPanel = new javax.swing.JPanel ();
    xferPanel.setLayout (new java.awt.FlowLayout ());

      xferPanelLabel = new javax.swing.JLabel ();
      xferPanelLabel.setText ("File Transfer");
      xferPanelLabel.setForeground (java.awt.Color.red);
      xferPanel.add (xferPanelLabel);

      jPanel6 = new javax.swing.JPanel ();
      jPanel6.setLayout (new javax.swing.BoxLayout (jPanel6, 1));

        sendRadioButton = new javax.swing.JRadioButton ();
        sendRadioButton.setSelected (true);
        sendRadioButton.setText ("Send");
        sendRadioButton.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              sendRadioButtonActionPerformed (evt);
            }
          }
        );
        jPanel6.add (sendRadioButton);

        recvRadioButton = new javax.swing.JRadioButton ();
        recvRadioButton.setText ("Receive");
        recvRadioButton.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              recvRadioButtonActionPerformed (evt);
            }
          }
        );
        jPanel6.add (recvRadioButton);

      xferPanel.add (jPanel6);

      xferFilenameLabel = new javax.swing.JLabel ();
      xferFilenameLabel.setText ("Filename:");
      xferPanel.add (xferFilenameLabel);

      xferFileNameTF = new javax.swing.JTextField ();
      xferFileNameTF.setPreferredSize (new java.awt.Dimension(100, 20));
      xferPanel.add (xferFileNameTF);

      jPanel7 = new javax.swing.JPanel ();
      jPanel7.setLayout (new javax.swing.BoxLayout (jPanel7, 1));

        xferModeTextRadioButton = new javax.swing.JRadioButton ();
        xferModeTextRadioButton.setText ("Text");
        jPanel7.add (xferModeTextRadioButton);

        xferModeBinRadioButton = new javax.swing.JRadioButton ();
        xferModeBinRadioButton.setSelected (true);
        xferModeBinRadioButton.setText ("Binary");
        jPanel7.add (xferModeBinRadioButton);

      xferPanel.add (jPanel7);

      xferButton = new javax.swing.JButton ();
      xferButton.setText ("Transfer");
      xferButton.addActionListener (new java.awt.event.ActionListener () {
          public void actionPerformed (java.awt.event.ActionEvent evt) {
            xferButtonActionPerformed (evt);
          }
        }
      );
      xferPanel.add (xferButton);

    getContentPane ().add (xferPanel, BorderLayout.SOUTH);

  }//GEN-END:initComponents

  /** Save the session log to disk.
   */
  private void saveLogFileMenuItemActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveLogFileMenuItemActionPerformed
    theModel.saveLogFile();
  }//GEN-LAST:event_saveLogFileMenuItemActionPerformed

  private void helpAboutMenuItemActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAboutMenuItemActionPerformed
    note("JModem 0.0 (c) 2000 Ian F. Darwin\nhttp://www.darwinsys.com/");
  }//GEN-LAST:event_helpAboutMenuItemActionPerformed

  private void baudComboBoxActionPerformed (java.awt.event.ActionEvent evt) {
    // Add your handling code here:
  }

  private void portsComboBoxActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portsComboBoxActionPerformed
    // Add your handling code here:
  }//GEN-LAST:event_portsComboBoxActionPerformed

  /** A TextArea subclass with funky keypress forwarding: send to
   * remote, not to local. This IS a terminal emulator, after all.
   */
  class MyTextArea extends JTextArea {
    MyTextArea(int r, int c) {
      super(r, c);
    }

    /** Handle local KeyEvents: send KeyTyped to the remote. */
    protected void processComponentKeyEvent(java.awt.event.KeyEvent evt) {
      if (evt.getID() != KeyEvent.KEY_TYPED)
        return;

      // send keystrokes to remote, for processing.
      // do nothing locally, to avoid user keystrokes appearing twice!
      if (theModel.state != JMModel.S_CONNECTED) {
        getToolkit().beep();  // or just connect()?
        return;
      }
      char ch = evt.getKeyChar();
      if (ch == '\n') {    // XX if systemtype == dos
        // sendChar('\r');
        theModel.sendChar('\n');
        return;
      }
      theModel.sendChar(ch);
    }
  }

  /** Finish the initializations. */
  private void finishConstructor() {
    // Create the textarea with a JScrollpane wrapping it.
    // Install it in Centre of the TextArea.
    theTextArea = new MyTextArea(20, 80);
    getContentPane().add(new JScrollPane(theTextArea), BorderLayout.CENTER);
    plainFont = new Font("courier", Font.PLAIN, 13);
    theTextArea.setFont(plainFont);
    xferFileNameTF.setFont(plainFont);

    theModel.populateComboBox();
    portsComboBox.setSelectedIndex(0);

    // Load up the baud rate combo box
    for (int i=0; i<baudot.length; i++) {
      baudComboBox.addItem(Integer.toString(baudot[i]));
    }
    baudComboBox.setSelectedIndex(0);

    // Load up the System Type combo box
    for (int i=0; i<sysTypes.length; i++) {
      sysTypeComboBox.addItem(sysTypes[i]);
    }
    sysTypeComboBox.setSelectedIndex(0);

    // put radio buttons into groups to enforce single-selection
    ButtonGroup b1 = new ButtonGroup();
    b1.add(d7RadioButton);
    b1.add(d8RadioButton);

    ButtonGroup b2 = new ButtonGroup();
    b2.add(pNoneRadioButton);
    b2.add(pEvenRadioButton);
    b2.add(pOddRadioButton);

    ButtonGroup b3 = new ButtonGroup();
    b3.add(sendRadioButton);
    b3.add(recvRadioButton);

    ButtonGroup b4 = new ButtonGroup();
    b4.add(xferModeTextRadioButton);
    b4.add(xferModeBinRadioButton);
    xferModeBinRadioButton.setEnabled(true);
  }

  private void recvRadioButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recvRadioButtonActionPerformed
    xferDirection = M_RECEIVE;
  }//GEN-LAST:event_recvRadioButtonActionPerformed

  private void sendRadioButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendRadioButtonActionPerformed
    xferDirection = M_SEND;
  }//GEN-LAST:event_sendRadioButtonActionPerformed

  private void exitMenuItemActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
    System.exit(0);
  }//GEN-LAST:event_exitMenuItemActionPerformed

  private void sysTypeComboBoxActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sysTypeComboBoxActionPerformed
    // Add your handling code here:
  }//GEN-LAST:event_sysTypeComboBoxActionPerformed

  private void pNoneRadioButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pNoneRadioButtonActionPerformed
    // Add your handling code here:
  }//GEN-LAST:event_pNoneRadioButtonActionPerformed

  private void oddRadioButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oddRadioButtonActionPerformed
    // Add your handling code here:
  }//GEN-LAST:event_oddRadioButtonActionPerformed

  private void evenRadioButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evenRadioButtonActionPerformed
    // Add your handling code here:
  }//GEN-LAST:event_evenRadioButtonActionPerformed



  /** This method basically toggles between Connected mode and
   * disconnected mode.
   */
  private void connectButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
    if (theModel.state == JMModel.S_CONNECTED) {
      theModel.disconnect();  // calls our disconnect() if OK
    } else {
      theModel.connect();    // calls our connect() if OK
    }
  }//GEN-LAST:event_connectButtonActionPerformed

  /** Show that we have connected to the serial port. */
  void connect() {
      connectButton.setText("Disconnect");
      theTextArea.setEditable(true);
      theTextArea.requestFocus();
  }

  /** Show that we have connected to the serial port. */
  void disconnect() {
      connectButton.setText("Connect");
      theTextArea.setEditable(false);
  }

  private void xferButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xferButtonActionPerformed

    // Do the transfer, using TModem class.
    theModel.xfer();

  }//GEN-LAST:event_xferButtonActionPerformed

  /** Exit the Application */
  private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
    System.exit (0);
  }//GEN-LAST:event_exitForm


// Some of these must be package-level visibility for JMModel,
// until we re-define the interface to that class a little...
// Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel connectPanel;
  private javax.swing.JPanel xferPanel;
  private javax.swing.JLabel connectPanelLabel;
  private javax.swing.JLabel portsLabel;
  protected javax.swing.JComboBox portsComboBox;
  private javax.swing.JLabel buadLabel;
  protected javax.swing.JComboBox baudComboBox;
  private javax.swing.JPanel databitsPanel;
  private javax.swing.JPanel parityPanel;
  private javax.swing.JLabel sysTypeLabel;
  private javax.swing.JComboBox sysTypeComboBox;
  private javax.swing.JButton connectButton;
  private javax.swing.JRadioButton d7RadioButton;
  private javax.swing.JRadioButton d8RadioButton;
  private javax.swing.JRadioButton pNoneRadioButton;
  private javax.swing.JRadioButton pEvenRadioButton;
  private javax.swing.JRadioButton pOddRadioButton;
  private javax.swing.JLabel xferPanelLabel;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JLabel xferFilenameLabel;
  private javax.swing.JTextField xferFileNameTF;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JButton xferButton;
  private javax.swing.JRadioButton sendRadioButton;
  private javax.swing.JRadioButton recvRadioButton;
  private javax.swing.JRadioButton xferModeTextRadioButton;
  private javax.swing.JRadioButton xferModeBinRadioButton;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JMenu helpMenu;
  private javax.swing.JMenuItem saveLogFileMenuItem;
  private javax.swing.JMenuItem exitMenuItem;
  private javax.swing.JMenuItem helpAboutMenuItem;
// End of variables declaration//GEN-END:variables

  /** Tell if the user wants 7 or 8-bit words */
  public int getDataBits() {
    if (d7RadioButton.isSelected())
      return 7;
    if (d8RadioButton.isSelected())
      return 8;
    throw new IllegalStateException("No word size in radio button group");
  }

  /** Tell if the user wants even, odd, or no parity. */
  public int getParity() {
    if (pNoneRadioButton.isSelected()) return JMModel.PARITY_NONE;
    if (pEvenRadioButton.isSelected()) return JMModel.PARITY_EVEN;
    if (pOddRadioButton.isSelected())  return JMModel.PARITY_ODD;
    throw new IllegalStateException("No parity in radio button group");
  }

  /** Get the filename */
  public String getXferFileName() {
    return xferFileNameTF.getText();
  }

  /** "One if by send, two if receive" */
  public boolean isSend() {
    if (sendRadioButton.isSelected())
      return true;
    if (recvRadioButton.isSelected())
      return false;
    throw new IllegalStateException("No send/recv set in radio button group");
  }

  /** Convenience routine: Show a standard-form information dialog */
  void note(String message) {
    JOptionPane.showMessageDialog(this, message,
      "JModem Notice", JOptionPane.INFORMATION_MESSAGE);
    return;
  }

  /** Convenience routine: Show a standard-form error dialog */
  void err(String message) {
    JOptionPane.showMessageDialog(this, message,
      "JModem Error", JOptionPane.ERROR_MESSAGE);
    return;
  }

  /** Main: just create and show the application class. */
  public static void main(java.lang.String[] args) {
    new JModem().setVisible(true);
  }
}
