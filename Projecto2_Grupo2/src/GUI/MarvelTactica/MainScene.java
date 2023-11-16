package GUI.MarvelTactica;

import Datos.Datardos;
import Pop_Ups.Incomplete_Data;
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
import javax.swing.JTextField;

public class MainScene extends JFrame implements ActionListener{
    Datardos datos = new Datardos();
    
    public MainScene(Datardos datos){
        MainMenu();
    }
    
    JFrame Canva;
    JButton Jugar, Practica, Ajustes, Estadisticas, Registro;
    
    private void MainMenu(){
        //JFrame general
        Canva = new JFrame();
        
        Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icon.png")).getImage());
        Canva.setSize(800,650);
        Canva.setResizable(false);
        Canva.setTitle("MARVEL'S STRATEGO");
        Canva.setLocationRelativeTo(null);
        Canva.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       
        //Panel entero (todo el JFrame)
        JPanel Panel = new JPanel();
        
        Panel.setLayout(null);
        Panel.setSize(800,650);
        Panel.setBackground(Color.black);
        
        //Panel de Menu
        JPanel Opciones = new JPanel();
        
        Opciones.setLayout(null);
        Opciones.setBackground(new Color(210,33,33,100));
        Opciones.setBounds(50, -5, 320, 650);
        Opciones.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,4));
        
        //Panel de logo
        ImageIcon image = new ImageIcon(getClass().getResource("Logo.png"));
        Image Scaleimage = image.getImage().getScaledInstance(260, 140, Image.SCALE_SMOOTH);
        ImageIcon neoimage = new ImageIcon(Scaleimage);
        JLabel imagen = new JLabel();
        
        
        imagen.setIcon(neoimage);
        imagen.setBounds(25, 30, 260, 140);
        
        //Boton de juego
        Jugar = new JButton();
        
        Jugar.setText("SOLO PLAY");
        Jugar.addActionListener(this);
        Jugar.setFont(new Font("Lucida Bright",3,20));
        Jugar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Jugar.setBounds(80,325,160,30);
        
        //Boton de practica
        Practica = new JButton();
        
        Practica.setText("PRACTICE");
        Practica.addActionListener(this);
        Practica.setFont(new Font("Lucida Bright",3,20));
        Practica.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Practica.setBounds(80,475,160,30);
        
        //Boton de Ajustes
        Ajustes = new JButton();
        
        Ajustes.setText("SETTINGS");
        Ajustes.addActionListener(this);
        Ajustes.setFont(new Font("Lucida Bright",3,20));
        Ajustes.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Ajustes.setBounds(80,525,160,30);
        
        //Boton de Estadisticas
        Estadisticas = new JButton(); 
        
        Estadisticas.setText("USER DATA");
        Estadisticas.addActionListener(this);
        Estadisticas.setFont(new Font("Lucida Bright",3,20));
        Estadisticas.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Estadisticas.setBounds(80,575,160,30);
        
        //Panel de perfil
        JPanel Personal = new JPanel();
        
        Personal.setLayout(null);
        Personal.setBackground(new Color(210,33,33,100));
        Personal.setBounds(550,-5,350,85);
        Personal.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,4));
        
        //Boton creacion de cuenta
        Registro = new JButton();
        
        Registro.addActionListener(this);
        Registro.setLayout(null);
        Registro.setBounds(15,18,50,50);
        Registro.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow,3));
        //txtbox 'Nombre de usuario'
        JTextField UsernameBox = new JTextField("User");
            
        UsernameBox.setText(datos.getUser(""));
        UsernameBox.setEditable(false);
        UsernameBox.setBounds(75,18,150,50);
        UsernameBox.setFont(new Font("Lucida Bright",3,18));
        
        //adicion de componentes generales
        Canva.add(Panel);
        Panel.add(Opciones);
        Panel.add(Personal);
        //Componentes del panel 'Menu'
        Opciones.add(imagen);
        Opciones.add(Jugar);
        Opciones.add(Practica);
        Opciones.add(Ajustes);
        Opciones.add(Estadisticas);
        //Componentes del panel 'Personales'
        Personal.add(Registro);
        Personal.add(UsernameBox);
        
        Canva.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Jugar && datos.getUsernames().size()>=2 && !"Guest".equals(datos.getUser(""))){
            Canva.dispose();
            datos.setOponent("Heroe");
            new BandChoose(datos).setVisible(false);      
        } else if (e.getSource()==Jugar){
            datos.setFaltante("Register 2 accounts to play");
            new Incomplete_Data(datos).setVisible(false);
        }

        if (e.getSource()==Practica){
            datos.setOponent("Heroe");
            Canva.dispose();
            new Map(datos).setVisible(false);
            //&& !"Guest".equals(datos.getUser(""))
        } else if (e.getSource()==Practica ){
            datos.setFaltante("Log in to an account");
            new Incomplete_Data(datos).setVisible(false);
        }
        
        if (e.getSource()==Ajustes){
            
        }
        
        if (e.getSource()==Estadisticas && !"Guest".equals(datos.getUser(""))){
            new Stats(datos).setVisible(false);
        } else if (e.getSource()==Estadisticas){
            datos.setFaltante("Log in to an account");
            new Incomplete_Data(datos).setVisible(false);
        }
        
        if (e.getSource()==Registro){
            Canva.dispose();
            new LogoReg(datos.getUsernames(), datos.getNames(), datos.getPasses()).setVisible(false);
        }
    }
    
}
