package GUI.MarvelTactica;

import Datos.Datardos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogoReg extends JFrame implements ActionListener{
    Datardos datos = new Datardos();
    
    public LogoReg(ArrayList<String> usernames, ArrayList<String> names, ArrayList<String> passes){        
        Canva();
    }
    
    JPasswordField Pass;
    JTextField Username;
    JLabel Name;
    JButton LogIn, Register, Cancel, change, concretar, regresar, BTNReveal, DelAc;;
    JFrame Canvas;
    int gamble;
    
    private void Canva(){
        //Data getter
        for (int loop=0; loop < datos.getUsernames().size();loop++){
            if (datos.getUsernames().get(loop).equals(datos.getUser(""))){
                gamble = loop;
            }
        }
        //main JFrame info
        Canvas = new JFrame();
        
        Canvas.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icons\\Icon.png")).getImage());
        Canvas.setResizable(false);
        Canvas.setSize(800, 410);
        Canvas.setLocationRelativeTo(null);
        Canvas.setTitle("Account options");
        Canvas.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);        
        //General Panel
        JPanel Caja = new JPanel();
        
        Caja.setLayout(null);
        Caja.setSize(800,500);
        Caja.setBackground(Color.black);
        //Texto aclarativo
        JLabel UpperText = new JLabel();
        
        UpperText.setFont(new Font("Lucida Bright",3,30));
        UpperText.setBounds(0, 15, Caja.getWidth(), 35);
        UpperText.setVerticalAlignment(JLabel.CENTER);
        UpperText.setHorizontalAlignment(JLabel.CENTER);
        UpperText.setForeground(Color.white);
        UpperText.setText("Account information");
        //Name
        Name = new JLabel();
        
        Name.setText(datos.getNames().get(gamble));
        Name.setForeground(Color.white);
        Name.setFont(new Font("Lucida Bright",3,40));
        Name.setBounds(525, 70, 250, 50);
        //Username
        Username = new JTextField();
        
        Username.setText(datos.getUsernames().get(gamble));
        Username.setForeground(Color.gray);
        Username.setEditable(false);
        Username.setFont(new Font("Lucida Bright",3,22));
        Username.setBounds(50, 70, 450, 50);
        //Pass
        Pass = new JPasswordField();
        
        Pass.setText(datos.getPasses().get(gamble)); 
        Pass.setForeground(Color.gray);
        Pass.setEditable(false);
        Pass.setFont(new Font("Lucida Bright",3,22));
        Pass.setBounds(50, 145, 375, 50);
        //Boton revelar contrasegna
        ImageIcon image = new ImageIcon(getClass().getResource("Icons\\eye.png"));
        Image Scaleimage = image.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        ImageIcon Eye = new ImageIcon(Scaleimage);
        BTNReveal = new JButton();
        
        BTNReveal.addActionListener(this);
        BTNReveal.setIcon(Eye);
        BTNReveal.setBounds(450,145,50,50);
        //Boton Log in
        LogIn = new JButton();
        
        LogIn.addActionListener(this);
        LogIn.setFont(new Font("Lucida Bright",3,28));
        LogIn.setBounds(525,70,225,50);
        LogIn.setText("Log in");
        //Boton Registro
        Register = new JButton();
        
        Register.addActionListener(this);
        Register.setFont(new Font("Lucida Bright",3,28));
        Register.setBounds(525,145,225,50);
        Register.setText("Registration");
        //boton de cambiar datos
        change = new JButton();
        
        change.addActionListener(this);
        change.setFont(new Font("Lucida Bright",3,28));
        change.setBounds((Caja.getWidth()/2)-200,220,400,50);
        change.setText("Edit data");
        //boton 'cancelar cambios'
        concretar = new JButton();
        
        concretar.addActionListener(this);
        concretar.setFont(new Font("Lucida Bright",3,28));
        concretar.setBounds(50,220,300,50);
        concretar.setText("Save new data");
        //boton 'aceptar cambios'
        regresar = new JButton();
        
        regresar.addActionListener(this);
        regresar.setFont(new Font("Lucida Bright",3,28));
        regresar.setBounds(450,220,300,50);
        regresar.setText("cancel");
        
        //Boton de regresar
        Cancel = new JButton();
        
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Lucida Bright",3,22));
        Cancel.setBounds(0,0,45,45);
        Cancel.setText("«");
        //boton eliminar cuenta
        DelAc = new JButton();
        
        DelAc.addActionListener(this);
        DelAc.setText("Delete account");
        DelAc.setFont(new Font("Lucida Bright",3,30));
        DelAc.setBounds((Caja.getWidth()/2)-250,290,500,60);
        //Adicion de Opciones
        Caja.add(UpperText);
        Caja.add(LogIn);
        Caja.add(Cancel);
        Caja.add(Register);
        Caja.add(Username);
        Caja.add(Pass);
        Caja.add(BTNReveal);
        Caja.add(change);
        Caja.add(concretar);
        Caja.add(regresar);
        Caja.add(DelAc);
        
        regresar.setVisible(false);
        concretar.setVisible(false);
        
        Canvas.add(Caja);
        Canvas.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LogIn){
            new LogScene(datos).setVisible(false);
            Canvas.dispose();
        } else if (e.getSource() == Register){
            new RegScene(datos).setVisible(false);
            Canvas.dispose();
        } else if (e.getSource() == Cancel){
            Canvas.dispose();
            new MainScene(datos).setVisible(false);
        } else if (e.getSource()==BTNReveal && Pass.echoCharIsSet()){
            Pass.setEchoChar((char)0);            
        } else if (e.getSource()==BTNReveal && Pass.echoCharIsSet()==false){
            Pass.setEchoChar('\u2022');
        } else if (e.getSource()==change&&(!"Guest".equals(datos.getUser("")))){
            change.setVisible(false);
            Pass.setEditable(true);
            Pass.setForeground(Color.black);
            Username.setEditable(true);
            Username.setForeground(Color.black);
            regresar.setVisible(true);
            concretar.setVisible(true);
        } else if ((e.getSource()==concretar||e.getSource()==regresar)){
            if (e.getSource()==concretar && Pass.getText().length()>=5){
                for (int loop = 0; loop < datos.getUsernames().size(); loop++){
                     if (!Username.getText().equals(datos.getUsernames().get(loop))){
                    } else if (loop+1==datos.getUsernames().size()){
                        datos.getUsernames().set(gamble, Username.getText());
                        datos.setUser(Username.getText());
                        datos.getPasses().set(gamble, Pass.getText());

                        change.setVisible(true);
                        Pass.setEditable(false);
                        Pass.setForeground(Color.gray);
                        Username.setEditable(false);
                        Username.setForeground(Color.gray);
                        regresar.setVisible(false);
                        concretar.setVisible(false);
                    }
                }
            } else if (e.getSource()==regresar){
                Username.setText(datos.getUsernames().get(gamble));
                Pass.setText(datos.getPasses().get(gamble));
                datos.setUser(Username.getText());
                
                change.setVisible(true);
                Pass.setEditable(false);
                Pass.setForeground(Color.gray);
                Username.setEditable(false);
                Username.setForeground(Color.gray);
                regresar.setVisible(false);
                concretar.setVisible(false);
            } 
        }
        if (e.getSource()==DelAc && (change.isEnabled()==true||regresar.isEnabled()==true||concretar.isEnabled()==true) && !Username.getText().equals("Guest")){
                change.setEnabled(false);
                regresar.setEnabled(false);
                concretar.setEnabled(false);
                
                Username.setEditable(false); 
                Username.setText("Enter your password to delete");
                Pass.setText(null);
                Pass.setEditable(true);
            } else if (e.getSource()==DelAc && (change.isEnabled()==false||regresar.isEnabled()==false||concretar.isEnabled()==false) && (Pass.getText().equals(datos.getPasses().get(gamble)))){
                datos.getTaken().add(datos.getUsernames().get(gamble));
                
                datos.getMirrorUsernames().remove(gamble);
                datos.getUsernames().remove(gamble);
                datos.getNames().remove(gamble);
                datos.getPasses().remove(gamble);
                datos.getWins().remove(gamble);
                datos.getLosses().remove(gamble);
                datos.getPuntos().remove(gamble);
                datos.getMirrorPuntos().remove(gamble);
                datos.getHeroes().remove(gamble);
                datos.getVillanos().remove(gamble);
                datos.setUser("Guest");
                
                Canvas.dispose();
                new MainScene(datos).setVisible(false);
            }
        
    }
    
}
