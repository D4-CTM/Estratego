package Pop_Ups;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegSuggestion  extends JFrame implements ActionListener{
    
    public RegSuggestion(){
        Sugerencia();
    }
    
    JFrame Pop;
    JButton Cancel;
    private void Sugerencia(){
        //Main JFrame;
        Pop = new JFrame();
        
        Pop.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icon.png")).getImage());
        Pop.setAlwaysOnTop(true);
        Pop.setResizable(false);
        Pop.setSize(450, 265);
        Pop.setLocationRelativeTo(null);
        Pop.setTitle("Account registration parameters");
        Pop.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //Main Panel
        JPanel PopGround = new JPanel();
        
        PopGround.setSize(450,265);
        PopGround.setLayout(null);
        PopGround.setBackground(Color.black);
        
        //Titlo
        JLabel UpperText = new JLabel();
        
        UpperText.setFont(new Font("Lucida Bright",3,28));
        UpperText.setBounds(47, 10, 400, 35);
        UpperText.setForeground(Color.white);
        UpperText.setText("Registration parameters");
        //Intro parametros
        JLabel txt = new JLabel();
        
        txt.setFont(new Font("Lucida Bright",0,18));
        txt.setBounds(15, 50, 500, 35);
        txt.setForeground(Color.white);
        txt.setText("To create the account is needed:");
        //first text
        JLabel firsttxt = new JLabel();
        
        firsttxt.setFont(new Font("Lucida Bright",0,16));
        firsttxt.setBounds(25, 75, 500, 35);
        firsttxt.setForeground(Color.white);
        firsttxt.setText("- Everything to be filled");
        //second text
        JLabel secondtxt = new JLabel();
        
        secondtxt.setFont(new Font("Lucida Bright",0,16));
        secondtxt.setBounds(25, 95, 500, 35);
        secondtxt.setForeground(Color.white);
        secondtxt.setText("- The name to only contain letters");
        //Intro pass parametros
        JLabel passtxt = new JLabel();
        
        passtxt.setFont(new Font("Lucida Bright",0,18));
        passtxt.setBounds(15, 120, 500, 35);
        passtxt.setForeground(Color.white);
        passtxt.setText("The password should:");
        //third text
        JLabel thirdtxt = new JLabel();
        
        thirdtxt.setFont(new Font("Lucida Bright",0,16));
        thirdtxt.setBounds(25, 145, 500, 35);
        thirdtxt.setForeground(Color.white);
        thirdtxt.setText("- Contain only letters and numbers");
        //forth text
        JLabel forthtxt = new JLabel();
        
        forthtxt.setFont(new Font("Lucida Bright",0,16));
        forthtxt.setBounds(25, 165, 500, 35);
        forthtxt.setForeground(Color.white);
        forthtxt.setText("- Have a length of 5 characters");
        //fifth text
        JLabel fifthtxt = new JLabel();
        
        fifthtxt.setFont(new Font("Lucida Bright",0,16));
        fifthtxt.setBounds(25, 185, 500, 35);
        fifthtxt.setForeground(Color.white);
        fifthtxt.setText("- Start with an upper case");
        //boton de regresar
        Cancel = new JButton();
        
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Lucida Bright",3,22));
        Cancel.setBounds(0,0,45,45);
        Cancel.setText("«");
        //Adicion de complementos
        Pop.add(PopGround);
        PopGround.add(UpperText);
        PopGround.add(txt);
        PopGround.add(firsttxt);
        PopGround.add(secondtxt);
        PopGround.add(passtxt);
        PopGround.add(thirdtxt);
        PopGround.add(forthtxt);
        PopGround.add(fifthtxt);
        PopGround.add(Cancel);
        
        Pop.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cancel){
            Pop.dispose();
        }
    }
    
}
