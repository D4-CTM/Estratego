package GUI.MarvelTactica;

import Datos.Datardos;
import Pop_Ups.RegSuggestion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegScene extends JFrame implements ActionListener{
    Datardos datos = new Datardos();
       
    public RegScene(Datardos datos){
        Registration();
    }
    
    JFrame Canva;
    JTextField Username;
    JPasswordField Pass;
    JButton BTNRegister, BTNCancel, BTNReveal;
    
    private void Registration(){  
        if (datos.getUser("").equals("Guest"))
            new RegSuggestion().setVisible(false);
        //JFrame        
        Canva = new JFrame();
        
        Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icons\\Icon.png")).getImage());
        Canva.setSize(500,260);
        Canva.setTitle("Registration form");
        Canva.setResizable(false);
        Canva.setLocationRelativeTo(null);
        Canva.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        //Main Panel
        JPanel Caja = new JPanel();
        
        Caja.setLayout(null);
        Caja.setSize(500,310);
        Caja.setBackground(Color.black);
        //Texto aclarativo
        JLabel UpperText = new JLabel();
        
        UpperText.setFont(new Font("Lucida Bright",3,28));
        UpperText.setBounds(100,15,350,35);
        UpperText.setText("Account registration");
        UpperText.setForeground(Color.white);
        //Username info
        Username = new JTextField();
        JLabel txtUser = new JLabel();
        
        txtUser.setFont(new Font("Lucida Bright",3,18));
        txtUser.setBounds(25,65,350,35);
        txtUser.setText("USERNAME: ");
        txtUser.setForeground(Color.white);
        Username.setFont(new Font("Lucida Bright",0,16));
        Username.setBounds(145, 65, 315, 35);
        //Pass info
        Pass = new JPasswordField();
        JLabel txtPass = new JLabel();
        
        txtPass.setFont(new Font("Lucida Bright",3,18));
        txtPass.setBounds(25,115,350,35);
        txtPass.setText("PASSWORD: ");
        txtPass.setForeground(Color.white);
        Pass.setFont(new Font("Lucida Bright",0,16));
        Pass.setBounds(145, 115, 265, 35);
        //Boton revelar contrasegna        
        ImageIcon image = new ImageIcon(getClass().getResource("Icons\\eye.png"));
        Image Scaleimage = image.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon Eye = new ImageIcon(Scaleimage);        
        BTNReveal = new JButton();
        
        BTNReveal.setIcon(Eye);
        BTNReveal.addActionListener(this);
        BTNReveal.setBounds(425,115,35,35);
        //Boton registrar
        BTNRegister = new JButton();
        
        BTNRegister.addActionListener(this);
        BTNRegister.setText("Create account");
        BTNRegister.setFont(new Font("Lucida Bright",3,20));
        BTNRegister.setBounds(25,165,210,40);
        //Boton cancelar
        BTNCancel = new JButton();
        
        BTNCancel.addActionListener(this);
        BTNCancel.setText("cancel");
        BTNCancel.setFont(new Font("Lucida Bright",3,22));
        BTNCancel.setBounds(250,165,210,40);
        //adicion de complementos
        Canva.add(Caja);
        Caja.add(txtUser);
        Caja.add(UpperText);
        Caja.add(Username);
        Caja.add(Pass);
        Caja.add(txtPass);
        Caja.add(BTNReveal);
        Caja.add(BTNRegister);
        Caja.add(BTNCancel);
        
        Canva.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BTNReveal){
            
            if (Pass.echoCharIsSet()){
                Pass.setEchoChar((char)0);
            } else {
                Pass.setEchoChar('\u2022');
            }
            
        }
        
        if (e.getSource() == BTNCancel){
            Canva.dispose();
            new MainScene(datos).setVisible(false);
        }
        
        if (e.getSource() == BTNRegister){                  
            if (Pass.getText().length() >= 5 && Pass.getText().matches("[\\d\\w]+") && Pass.getText().charAt(0) == Pass.getText().toUpperCase().charAt(0) && Username.getText().isBlank() == false){
                int tamagno = datos.getUsernames().size();
                for (int loop = 0; loop < tamagno; loop++){
                    if (!Username.getText().equals(datos.getUsernames().get(loop)) && (loop == datos.getUsernames().size() - 1)){
                        datos.getUsernames().add(Username.getText());
                        datos.getMirrorUsernames().add(Username.getText());
                        datos.getPasses().add(Pass.getText());
                        datos.getWins().add(0);
                        datos.getLosses().add(0);
                        datos.getMirrorPuntos().add(0);
                        datos.getPuntos().add(0);
                        datos.getHeroes().add(0);
                        datos.getVillanos().add(0);

                        datos.setUser(Username.getText());

                        Canva.dispose();
                        new MainScene(datos).setVisible(false);
                    } 
                }
            } else new RegSuggestion().setVisible(false);
            
        }
    }
    
}
