package GUI.MarvelTactica;

import Datos.Datardos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogScene extends JFrame implements ActionListener{
    Datardos datos = new Datardos();
    
    public LogScene(){
        LogMenu();
    }
    
    JButton BTNReveal, BTNCancel, BTNSubmit;
    JTextField txtUsername;
    JPasswordField txtPass;
    JFrame Espacio;
    private void LogMenu(){
        //Size and stuff
        
        Espacio = new JFrame();
        
        Espacio.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icon.png")).getImage());
        Espacio.setTitle("Log in");
        Espacio.setResizable(false);
        Espacio.setSize(600, 325);
        Espacio.setLocationRelativeTo(null);
        Espacio.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        //Panel entero (todo el JFrame)
        JPanel Caja = new JPanel();
        
        Caja.setLayout(null);
        Caja.setVisible(true);
        Caja.setSize(600,325);
        Caja.setBackground(Color.black);
        //Titulo
        JLabel UpperText = new JLabel("Log In");
        
        UpperText.setText("Log In");
        UpperText.setForeground(Color.white);
        UpperText.setFont(new Font("Lucida Bright",3,28));
        UpperText.setBounds(250, 20, 100, 35);
        //Username box
        txtUsername = new JTextField();
        JLabel Userin = new JLabel();
        
        Userin.setText("Username: ");
        Userin.setForeground(Color.white);
        Userin.setFont(new Font("Lucida Bright",3,16));
        Userin.setBounds(50,38,100,35);
        
        txtUsername.setFont(new Font("Lucida Bright",3,24));
        txtUsername.setBounds(50,65,475,45);
        
        //Password box
        txtPass = new JPasswordField();
        JLabel Passin = new JLabel();
        
        Passin.setText("Password: ");
        Passin.setForeground(Color.white);
        Passin.setFont(new Font("Lucida Bright",3,16));
        Passin.setBounds(110,108,100,35);
        
        txtPass.setFont(new Font("Lucida Bright",3,24));
        txtPass.setBounds(110,135,415,45);
        
        //Boton revelar contrasegna
        BTNReveal = new JButton();
        
        BTNReveal.addActionListener(this);
        BTNReveal.setBounds(50,135,45,45);
        
        //Boton submit
        BTNSubmit = new JButton();
        
        BTNSubmit.addActionListener(this);
        BTNSubmit.setText("SUBMIT");
        BTNSubmit.setFont(new Font("Lucida Bright",3,24));
        BTNSubmit.setBounds(50,200,225,65);
        //Boton cancelar
        BTNCancel = new JButton();
        
        BTNCancel.addActionListener(this);
        BTNCancel.setText("CANCEL");
        BTNCancel.setFont(new Font("Lucida Bright",3,24));
        BTNCancel.setBounds(300,200,225,65);
        //Adicion de complementos
        Espacio.add(Caja);
        Caja.add(UpperText);
        Caja.add(txtUsername);
        Caja.add(Userin);
        Caja.add(txtPass);
        Caja.add(Passin);
        Caja.add(BTNReveal);
        Caja.add(BTNSubmit);
        Caja.add(BTNCancel);
        
        Espacio.setVisible(true);   

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BTNReveal){
            if (txtPass.echoCharIsSet()){
                txtPass.setEchoChar((char)0);
            } else {
                txtPass.setEchoChar('\u2022');
            }
            
        }
               
        if (e.getSource() == BTNSubmit){
            for (int loop=0;loop < datos.getUsernames().size(); loop++){
                if (datos.getUsernames().get(loop).equals(txtUsername.getText())){
                    datos.setUser("");
                    datos.setUser(txtUsername.getText());
                    
                    if (datos.getPasses().get(loop).equals(txtPass.getText())){ 
                        
                        Espacio.dispose();
                        datos.setChange(true);
                        new MainScene(datos).setVisible(false);
                        loop = datos.getUsernames().size() + 2;
                    } else System.out.println("Contra incorrecta");
                    
                } else if (loop + 1 == datos.getUsernames().size()){
                    System.out.println("La cuenta que busca no esta registrada");
                }
            }
        }
        
        if (e.getSource() == BTNCancel){
            Espacio.dispose();
            new MainScene(datos).setVisible(false);
        }
    }
    
}
