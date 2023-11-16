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

public class Stats extends JFrame implements ActionListener{
    Datardos datos = new Datardos();
    
    public Stats(Datardos datos){
        DataEast();
    }
    int gamble = 0;
    
    JFrame Canva;
    JPasswordField Pass;
    JTextField Name, Username;
    JButton Regresar, BTNReveal;
    
    private void DataEast(){
        //Data getter
        for (int loop=0; loop < datos.getUsernames().size();loop++){
            if (datos.getUsernames().get(loop).equals(datos.getUser(""))){
                gamble = loop;
                System.out.println("User: ");
                System.out.println(datos.getUser(""));
            }
        }
        
        //Main Frame
        Canva = new JFrame();
    
        Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icon.png")).getImage());
        Canva.setSize(650,420);
        Canva.setResizable(false);
        Canva.setTitle("Player statistics");
        Canva.setLocationRelativeTo(null);
        Canva.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //main Panel
        JPanel Caja = new JPanel();
        
        Caja.setLayout(null);
        Caja.setSize(650,420);
        Caja.setBackground(Color.black);
        //Boton regresar
        Regresar = new JButton();
        
        Regresar.addActionListener(this);
        Regresar.setText("«");
        Regresar.setFont(new Font("Lucida Bright",3,22));
        Regresar.setBounds(0,0,45,45);
        //Upper text
        JLabel UpperText = new JLabel();
        
        UpperText.setText(datos.getUser("")+"'s information");
        UpperText.setBounds(0, 5, 650, 35);
        UpperText.setFont(new Font("Lucida Bright",3,30));
        UpperText.setVerticalAlignment(JLabel.CENTER);
        UpperText.setHorizontalAlignment(JLabel.CENTER);
        UpperText.setForeground(Color.white);
        //Name
        Name = new JTextField();
        
        Name.setText(datos.getNames().get(gamble));
        Name.setForeground(Color.black);
        Name.setEditable(false);
        Name.setFont(new Font("Lucida Bright",3,22));
        Name.setBounds(160, 55, 450, 40);
        //Username
        Username = new JTextField();
        
        Username.setText(datos.getUsernames().get(gamble));
        Username.setForeground(Color.black);
        Username.setEditable(false);
        Username.setFont(new Font("Lucida Bright",3,22));
        Username.setBounds(160, 105, 450, 40);
        //Pass
        Pass = new JPasswordField();
        JLabel txtPass = new JLabel();
        
        txtPass.setText("Password: ");
        txtPass.setForeground(Color.white);
        txtPass.setFont(new Font("Lucida Bright",3,22));
        txtPass.setBounds(20, 155, 300, 40);
        
        Pass.setText(datos.getPasses().get(gamble)); 
        Pass.setForeground(Color.black);
        Pass.setEditable(false);
        Pass.setFont(new Font("Lucida Bright",3,22));
        Pass.setBounds(160, 155, 400, 40);
        //Boton revelar contrasegna
        BTNReveal = new JButton();
        
        BTNReveal.addActionListener(this);
        BTNReveal.setBounds(570,155,40,40);
        //Wins
        JLabel txtWins = new JLabel();
        
        txtWins.setText("Winned games: "+datos.getWins().get(gamble));
        txtWins.setForeground(Color.white);
        txtWins.setFont(new Font("Lucida Bright",3,22));
        txtWins.setBounds(20, 205, 300, 40);
        //Losses
        JLabel txtLosses = new JLabel();
        
        txtLosses.setText("Lossed games: "+datos.getWins().get(gamble));
        txtLosses.setForeground(Color.white);
        txtLosses.setFont(new Font("Lucida Bright",3,22));
        txtLosses.setBounds(345, 205, 300, 40);
        //fav band
        JLabel txtBandos = new JLabel();
        
        txtBandos.setText("Games played as: ");
        txtBandos.setForeground(Color.white);
        txtBandos.setFont(new Font("Lucida Bright",3,22));
        txtBandos.setBounds(0, 255, 650, 35);
        txtBandos.setVerticalAlignment(JLabel.CENTER);
        txtBandos.setHorizontalAlignment(JLabel.CENTER);
        //Heroes
        JLabel txtHeroes = new JLabel();
        
        txtHeroes.setText("Heroes: "+datos.getHeroes().get(gamble));
        txtHeroes.setForeground(Color.white);
        txtHeroes.setFont(new Font("Lucida Bright",3,22));
        txtHeroes.setBounds(20, 305, 300, 40);
        //Villanos
        JLabel txtVillanos = new JLabel();
        
        txtVillanos.setText("Villains: "+datos.getVillanos().get(gamble));
        txtVillanos.setForeground(Color.white);
        txtVillanos.setFont(new Font("Lucida Bright",3,22));
        txtVillanos.setBounds(345, 305, 300, 40);
        //adicion de complementos
        Canva.add(Caja);
        Caja.add(UpperText);
        //Caja.add(txtName);
        Caja.add(Name);
        //Caja.add(txtUsername);
        Caja.add(Username);
        Caja.add(txtPass);
        Caja.add(Pass);
        Caja.add(BTNReveal);
        Caja.add(txtWins);
        Caja.add(txtLosses);
        Caja.add(txtBandos);
        Caja.add(txtHeroes);
        Caja.add(txtVillanos);
        
        Caja.add(Regresar);
                
        Canva.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Regresar){
            Canva.dispose();
        }
        
        if (e.getSource()==BTNReveal && Pass.echoCharIsSet()){
            Pass.setEchoChar((char)0);            
        } else {
            Pass.setEchoChar('\u2022');
        }
        
    }
    
}
