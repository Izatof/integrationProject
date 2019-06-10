/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntnu.integrationproject.Interface;

import com.ntnu.integrationproject.Connexion;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import org.bson.Document;

/**
 *
 * @author GaëlDIDIDER
 */
public class JDialogCreateTest extends javax.swing.JDialog {

    /**
     * Creates new form JDialogCreateTest
     */
    
    String title;
    JFrame parent1;
    private Connexion tests;
    Connexion topics;
    Connexion questions;
    TreePath selectPath=null;
    List<String> res=new ArrayList<String>();
    boolean edit = false;
    
    private DefaultMutableTreeNode root= new DefaultMutableTreeNode("Question");
    
    public JDialogCreateTest(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        parent1 = (JFrame) parent;
        this.setTitle("Questions");                
        topics = new Connexion("Topics");
        questions=new Connexion("Questions");
        updateTree();
        initComponents();
        tests = new Connexion("Tests");
        res = tests.requete(new HashMap());
    }
    public JDialogCreateTest(java.awt.Frame parent, boolean modal, String t) {
        super(parent, modal);
        parent1 = (JFrame) parent;
        title=t;
        edit=true;
        this.setTitle("Questions");                
        topics = new Connexion("Topics");
        questions=new Connexion("Questions");
        updateTree();
        initComponents();
        tests = new Connexion("Tests");
        res = tests.requete(new HashMap());
        Document doc=tests.resultat(t);
        jTextField1.setText(doc.getString("_id"));        
        List<Document> list=new ArrayList<Document>();
        list=(List)doc.get("Questions");
        for(Document d : list){
            JTextField jtf = new JTextField();
            jtf.setText(d.get("_id").toString());
            JSpinner js =new JSpinner();
            SpinnerNumberModel model;
            model = new SpinnerNumberModel((double)d.get("Coeff"), 0.0, 1000.0, 0.5);
            js.setModel(model);
            JButton jb = new JButton();
            jb.setText("❌");
            jb.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jPanel1.remove(jtf);
                    jPanel2.remove(js);
                    jPanel3.remove(jb);
                    jPanel3.getParent().revalidate();
                    jPanel3.getParent().repaint();
                }
            });
            jPanel1.add(jtf);
            jPanel2.add(js);
            jPanel3.add(jb);
        }
    }
    public void updateTree(){
        List<String> res1=new ArrayList<String>();
        List<String> res2=new ArrayList<String>();
        res1=topics.requete(new HashMap());
            Map tmp1 = new HashMap<String,String>();        
        for(String s : res1){
            //Document res3 = topics.resultat(s);
            tmp1.put("Topic", s);
            res2=questions.requete(tmp1);
            if(!res2.isEmpty()){
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(s);
                root.add(newNode);
                for(String s2 : res2){
                    newNode.add(new DefaultMutableTreeNode(s2));
                }
            tmp1 = new HashMap<String,String>();
            }
            
            
            
            
        }
        //System.out.println(root.getChildAt(root.getChildCount()-1));
        /*jTree1=new JTree(root);
        jTree1.revalidate();
        jTree1.repaint();
        jTree1.doLayout();
        this.revalidate();
        this.repaint();
        this.doLayout();  */      
        //initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree(root);
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jLabel1.setText("Select Questions below");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(20, 1));

        jPanel2.setLayout(new java.awt.GridLayout(20, 1));

        jPanel3.setLayout(new java.awt.GridLayout(20, 1));

        jPanel4.setLayout(new java.awt.GridLayout(0, 2));

        jLabel2.setText("Question Title");
        jPanel4.add(jLabel2);

        jLabel3.setText("Coefficient");
        jPanel4.add(jLabel3);

        jLabel4.setText("Test's Title:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new JDialog123 (parent1, false).setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
        selectPath=evt.getNewLeadSelectionPath();
        System.out.println(selectPath);
        if(selectPath.getPathCount()==3){
            JTextField jtf = new JTextField();
            jtf.setText(selectPath.getPathComponent(selectPath.getPathCount()-1).toString());
            JSpinner js =new JSpinner();
            SpinnerNumberModel model;
            model = new SpinnerNumberModel(1.0, 0.0, 1000.0, 0.5);
            js.setModel(model);
            JButton jb = new JButton();
            jb.setText("❌");
            jb.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jPanel1.remove(jtf);
                    jPanel2.remove(js);
                    jPanel3.remove(jb);
                    jPanel3.getParent().revalidate();
                    jPanel3.getParent().repaint();
                }
            });
            jPanel1.add(jtf);
            jPanel2.add(js);
            jPanel3.add(jb);
            this.revalidate();
            this.repaint();
        }
    }//GEN-LAST:event_jTree1ValueChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        List<String> s=new ArrayList<String>();        
        Map<String,Object> map= new HashMap();
        if("".equals(jTextField1.getText()))
        {
            showMessageDialog(null,"You have to write a Test's title.");
        }
        else
        {
            if(res.contains(jTextField1.getText())&&!(edit))
            {
                showMessageDialog(null,"This Test's title is already used.");
            }
            else{
                if(jPanel1.getComponents().length==0){
                    showMessageDialog(null,"You have to add at least one question to the test.");
                }
                else{
                    Map<String,Object> tmp= new HashMap();
                    tmp.put("_id", jTextField1.getText());
                    Map<String,Object> add = new HashMap();
                    List<HashMap> doc=new ArrayList();
                    for(int i=0;i<jPanel1.getComponents().length;i++){
                        String quest=((JTextField)(jPanel1.getComponents()[i])).getText();
                        float coeff=Float.parseFloat(((JSpinner)(jPanel2.getComponents()[i])).getValue().toString());
                        add.put("_id", quest);
                        add.put("Coeff",coeff);
                        doc.add((HashMap) add);
                        add = new HashMap();
                        }
                    tmp.put("Questions",doc);                    
                    if(edit){
                        System.out.println(edit);
                        tests.update(title,tmp);
                    }
                    else{
                        tests.insert(tmp);
                    }                    
                    new JDialog123 (parent1, false).setVisible(true);
                    this.setVisible(false);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogCreateTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogCreateTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogCreateTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogCreateTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogCreateTest dialog = new JDialogCreateTest(new javax.swing.JFrame(), true, "plop");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
