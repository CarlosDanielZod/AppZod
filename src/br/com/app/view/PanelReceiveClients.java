package br.com.app.view;

/**
 *
 * @author carlos
 */
public class PanelReceiveClients extends javax.swing.JPanel {


    public PanelReceiveClients(int ticket, String client, String phone, String email) {
        initComponents();
        txtTicket.setText(""+ticket);
        txtClient.setText(client);
        txtPhone.setText(phone);
        txtEmail.setText(email);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTicket = new javax.swing.JPanel();
        lblTicket = new javax.swing.JLabel();
        txtTicket = new javax.swing.JLabel();
        panelClient = new javax.swing.JPanel();
        lblClient = new javax.swing.JLabel();
        txtClient = new javax.swing.JLabel();
        panelPhone = new javax.swing.JPanel();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JLabel();
        panelEmail = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        panelTicket.setBackground(new java.awt.Color(255, 255, 255));
        panelTicket.setMaximumSize(new java.awt.Dimension(75, 30));
        panelTicket.setMinimumSize(new java.awt.Dimension(75, 30));
        panelTicket.setPreferredSize(new java.awt.Dimension(75, 30));
        panelTicket.setLayout(new javax.swing.BoxLayout(panelTicket, javax.swing.BoxLayout.LINE_AXIS));

        lblTicket.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblTicket.setForeground(new java.awt.Color(145, 4, 72));
        lblTicket.setText("Ticket:  ");
        panelTicket.add(lblTicket);

        txtTicket.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        txtTicket.setForeground(new java.awt.Color(145, 4, 72));
        txtTicket.setText("100");
        txtTicket.setMaximumSize(new java.awt.Dimension(30, 30));
        txtTicket.setMinimumSize(new java.awt.Dimension(30, 30));
        txtTicket.setPreferredSize(new java.awt.Dimension(30, 30));
        panelTicket.add(txtTicket);

        add(panelTicket);

        panelClient.setBackground(new java.awt.Color(255, 255, 255));
        panelClient.setMaximumSize(new java.awt.Dimension(230, 30));
        panelClient.setMinimumSize(new java.awt.Dimension(230, 30));
        panelClient.setPreferredSize(new java.awt.Dimension(230, 30));
        panelClient.setLayout(new javax.swing.BoxLayout(panelClient, javax.swing.BoxLayout.LINE_AXIS));

        lblClient.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblClient.setForeground(new java.awt.Color(145, 4, 72));
        lblClient.setText("Cliente:  ");
        panelClient.add(lblClient);

        txtClient.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        txtClient.setForeground(new java.awt.Color(145, 4, 72));
        txtClient.setText("Carlos Daniel da silva araujo");
        panelClient.add(txtClient);

        add(panelClient);

        panelPhone.setBackground(new java.awt.Color(255, 255, 255));
        panelPhone.setMaximumSize(new java.awt.Dimension(150, 30));
        panelPhone.setMinimumSize(new java.awt.Dimension(150, 30));
        panelPhone.setPreferredSize(new java.awt.Dimension(150, 30));
        panelPhone.setLayout(new javax.swing.BoxLayout(panelPhone, javax.swing.BoxLayout.LINE_AXIS));

        lblPhone.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(145, 4, 72));
        lblPhone.setText("Celular:  ");
        panelPhone.add(lblPhone);

        txtPhone.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(145, 4, 72));
        txtPhone.setText("(11) 98977-9072");
        panelPhone.add(txtPhone);

        add(panelPhone);

        panelEmail.setBackground(new java.awt.Color(255, 255, 255));
        panelEmail.setMaximumSize(new java.awt.Dimension(245, 30));
        panelEmail.setMinimumSize(new java.awt.Dimension(245, 30));
        panelEmail.setPreferredSize(new java.awt.Dimension(245, 30));
        panelEmail.setLayout(new javax.swing.BoxLayout(panelEmail, javax.swing.BoxLayout.LINE_AXIS));

        lblEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(145, 4, 72));
        lblEmail.setText("E-mail:  ");
        panelEmail.add(lblEmail);

        txtEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(145, 4, 72));
        txtEmail.setText("carlosdaniel.araujo@hotmail.com.br");
        panelEmail.add(txtEmail);

        add(panelEmail);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblClient;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblTicket;
    private javax.swing.JPanel panelClient;
    private javax.swing.JPanel panelEmail;
    private javax.swing.JPanel panelPhone;
    private javax.swing.JPanel panelTicket;
    private javax.swing.JLabel txtClient;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtPhone;
    private javax.swing.JLabel txtTicket;
    // End of variables declaration//GEN-END:variables
}
