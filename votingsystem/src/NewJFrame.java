/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SMPS
 */
public class NewJFrame extends javax.swing.JFrame {
Connection cn=null;
Statement st=null;
Statement st2=null;
ResultSet rs=null;
ResultSet rs1=null;
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VD = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        tfVP = new javax.swing.JTextField();
        VOP = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        M = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("VotingDetails");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(101, 8, 192, 40);

        VD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "voterid", "votername", "vote"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(VD);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 375, 80);

        jButton1.setText("verify");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 190, 61, 23);
        getContentPane().add(tfVP);
        tfVP.setBounds(210, 240, 73, 20);

        VOP.setText("calculate");
        VOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VOPActionPerformed(evt);
            }
        });
        getContentPane().add(VOP);
        VOP.setBounds(110, 280, 75, 23);

        jLabel2.setText("VotePercentage");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 230, 77, 50);

        M.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNO", "PartyName", "Voted", "Candidate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(M);
        if (M.getColumnModel().getColumnCount() > 0) {
            M.getColumnModel().getColumn(0).setResizable(false);
            M.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 330, 295, 78);

        jButton2.setText("ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(130, 440, 43, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Chrysanthemum.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-11, -11, 410, 790);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   try{
       Class.forName("java.sql.Driver");
       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem","root","1234");
             st = cn.createStatement();
                String query= "SELECT *FROM vote;";
                 rs = st.executeQuery(query);
           DefaultTableModel t1=(DefaultTableModel)VD.getModel();
            int i=0; 
            String h="no";
            String m="yes";
            int j=0;
            while(rs.next())
                   { 
                      i=rs.getInt("voterID");
                     String A =rs.getString("votername");
                      j=rs.getInt("vote");
                      if(j>0)
                      {
                                    t1.addRow(new Object[]{i,A,m});
                      }
                      else if(j==0)
                              {
                         t1.addRow(new Object[]{i,A,h});
                      }
              else
                          JOptionPane.showMessageDialog(null,"NO such record Found");
                   }        
                  
        }
   catch(Exception e){
                 JOptionPane.showMessageDialog(null,"Error in connectivity");
                         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void VOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VOPActionPerformed
 try{
       Class.forName("java.sql.Driver");
       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem","root","1234");
             st = cn.createStatement();
              st2 = cn.createStatement();
                String query= "SELECT COUNT(vote) as 'totvot' from vote;";
                 String M= "SELECT COUNT(vote) as 'totvotel' from vote WHERE vote=1;";
                 rs = st.executeQuery(query);
                rs1 = st2.executeQuery(M);
                 int i=0;
                 int j=0;
              double cal =0;
              if(rs.next())
              {
                  i =rs.getInt("totvot");
                  
                  
              }
            if(rs1.next())
              {
                  
                  j =rs1.getInt("totvotel");
                  
              }
               cal =j*100/i;
                tfVP.setText(""+cal);
                 
                 
                 
                 
                 
                 
                 
 }  catch(Exception e){
                 JOptionPane.showMessageDialog(null,e);
                         }
    }//GEN-LAST:event_VOPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      try{
       Class.forName("java.sql.Driver");
       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem","root","1234");
             st = cn.createStatement();
                 String query= "SELECT *FROM party;";
                 rs = st.executeQuery(query);
           DefaultTableModel t1=(DefaultTableModel)M.getModel();
 int i =0;
 int j =0;
 

 while(rs.next())
                   { 
                      i=rs.getInt("sno");
                     String A =rs.getString("Partyname");
                      j=rs.getInt("vote");
                      String H =rs.getString("Candidate");
                      t1.addRow(new Object[]{i,A,j,H});
                     }
            
                  
        }
   catch(Exception e){
                 JOptionPane.showMessageDialog(null,"Error in connectivity");
                         }
                                             
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable M;
    private javax.swing.JTable VD;
    private javax.swing.JButton VOP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfVP;
    // End of variables declaration//GEN-END:variables
}
