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

public class BandChoose extends JFrame implements ActionListener{
    Datardos datos = new Datardos();
    
    public BandChoose(Datardos datos){
        Elector();
    }
    int gamble, change;
    
    JFrame Canva;
    JButton Regresar, Heroes, Villains;
    private void Elector(){
        //Data getter
        for (int loop=0; loop < datos.getUsernames().size();loop++){
            if (datos.getUsernames().get(loop).equals(datos.getUser(""))){
                gamble = loop;
            }
        }
        //Main frame
        Canva = new JFrame();
                
        Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icons\\Icon.png")).getImage());
        Canva.setSize(400,325);
        Canva.setResizable(false);
        Canva.setTitle("Choose your side");
        Canva.setLocationRelativeTo(null);
        Canva.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        //Main Frame
        JPanel Caja = new JPanel();
        
        Caja.setLayout(null);
        Caja.setSize(400,325);
        Caja.setBackground(Color.black); 
        //Boton regresar
        Regresar = new JButton();
        
        Regresar.addActionListener(this);
        Regresar.setText("«");
        Regresar.setFont(new Font("Lucida Bright",3,22));
        Regresar.setBounds(0,0,45,45);
        //Upper text
        JLabel UpperText = new JLabel();
        
        UpperText.setText("Choose your side");
        UpperText.setBounds(0, 5, 400, 35);
        UpperText.setFont(new Font("Lucida Bright",3,30));
        UpperText.setVerticalAlignment(JLabel.CENTER);
        UpperText.setHorizontalAlignment(JLabel.CENTER);
        UpperText.setForeground(Color.white);
        //Hero's side
        Heroes = new JButton();
        
        Heroes.addActionListener(this);
        Heroes.setFont(new Font("Lucida Bright",3,24));
        Heroes.setBounds(10,240,175, 40);
        Heroes.setText("HEROES");
        //Villains's side
        Villains = new JButton();
        
        Villains.addActionListener(this);
        Villains.setFont(new Font("Lucida Bright",3,24));
        Villains.setBounds(200,240,175, 40);
        Villains.setText("VILLAINS");
        //Adicion de implementos
        Canva.add(Caja);
        Caja.add(Regresar);
        Caja.add(UpperText);
        Caja.add(Heroes);
        Caja.add(Villains);
        
        Canva.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        datos.setOponent("Heroe");
            datos.setStart(false);
        if (e.getSource()==Villains){
            Canva.dispose();
            datos.setSelected(false);
            datos.setChange(true);
            if (datos.isPractice()==true){
                datos.setUser2("Guest");
                new Map(datos).setVisible(false);
            } else{
                change = datos.getVillanos().get(gamble);
                change++;
                datos.getVillanos().set(gamble, change);
                new LogScene(datos).setVisible(false);
            }
        }
        
        if (e.getSource()==Heroes){
            Canva.dispose();
            datos.setSelected(true); 
            datos.setChange(true);
            if (datos.isPractice()==true){
                datos.setPractice(true);
                datos.setUser2("Guest");
                new Map(datos).setVisible(false);
            } else {                
                change = datos.getHeroes().get(gamble);
                change++;
                datos.getHeroes().set(gamble, change);
                new LogScene(datos).setVisible(false);
            }
        }
        
        if (e.getSource()==Regresar){
            new MainScene(datos).setVisible(false);
            Canva.dispose();
        }
    }

}
