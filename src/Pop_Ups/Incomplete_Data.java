package Pop_Ups;

import Datos.Datardos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Incomplete_Data extends JFrame implements ActionListener{
    Datardos message = new Datardos();
    
    public Incomplete_Data(Datardos datos){
        PopPop();
    }
    
    JButton Regresar;
    JFrame Canva;
    
    private void PopPop(){
        //Main Frame
        Canva = new JFrame();
        
        Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icon.png")).getImage());
        Canva.setSize(425,150);
        Canva.setResizable(false);
        Canva.setTitle("Incomplete data");
        Canva.setLocationRelativeTo(null);
        Canva.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //JPanel padre
        JPanel Caja = new JPanel();
        
        Caja.setBackground(Color.black);
        Caja.setLayout(null);
        Caja.setSize(400,325);
        ///Boton regresar
        Regresar = new JButton();
        
        Regresar.addActionListener(this);
        Regresar.setText("«");
        Regresar.setFont(new Font("Lucida Bright",3,22));
        Regresar.setBounds(0,0,45,45);
        //Upper text
        JLabel UpperText = new JLabel();
        
        UpperText.setText("You should");
        UpperText.setBounds(0, 5, 425, 45);
        UpperText.setFont(new Font("Lucida Bright",3,30));
        UpperText.setVerticalAlignment(JLabel.CENTER);
        UpperText.setHorizontalAlignment(JLabel.CENTER);
        UpperText.setForeground(Color.white);
        //Info text
        JLabel Warning = new JLabel();
        
        Warning.setText(message.getFaltante(""));
        Warning.setFont(new Font("Lucida Bright",3,26));
        Warning.setForeground(Color.white);
        Warning.setBounds(0, 55, 410, 45);
        Warning.setVerticalAlignment(JLabel.CENTER);
        Warning.setHorizontalAlignment(JLabel.CENTER);
        
        //adicion de complementos
        Canva.add(Caja);
        Caja.add(UpperText);
        Caja.add(Warning);
        Caja.add(Regresar);
        
        Canva.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Regresar){
            Canva.dispose();
        }
    }
    
}
