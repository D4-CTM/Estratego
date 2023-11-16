package GUI.MarvelTactica;

import Datos.Datardos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Map extends JFrame implements ActionListener{
    Datardos datos = new Datardos();
    Random Randy;
    
    public Map(Datardos datos){
        MapHeroe();
    }

    JFrame Canva;
    JPanel Mapa;
    JButton Ginyu;
    int row0, row1, row2, column0, column1, column2;
    JButton[][] Tile = new JButton[12][12];
    String change;
    boolean MoVa[] = new boolean[4];
    //[rango en si][0-Heroes||1-Villanos]
    int troops[][] = new int [13][2];
    int loop, column, row, columna, fila;
    
    private void MapHeroe(){
        Randy = new Random();
        for (int HoV = 0; HoV < 2; HoV++){
            troops[0][HoV] = 1;
            troops[1][HoV] = 1;
            troops[2][HoV] = 8;
            troops[3][HoV] = 5;
            troops[4][HoV] = 4;
            troops[5][HoV] = 4;
            troops[6][HoV] = 4;
            troops[7][HoV] = 3;
            troops[8][HoV] = 2;
            troops[9][HoV] = 1;
            troops[10][HoV] = 1;
            troops[11][HoV] = 6;
        }
        
        //JFrame general
        Canva = new JFrame();
        
        Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icon.png")).getImage());
        Canva.setSize(800,650);
        Canva.setResizable(false);
        Canva.setTitle("MARVEL'S STRATEGO");
        Canva.setLocationRelativeTo(null);
        Canva.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //Map background
        JPanel Caja = new JPanel();
        
        Caja.setLayout(null);
        Caja.setSize(800,650);
        Caja.setBackground(Color.black);
        //Square size
        Mapa = new JPanel();
        
        Mapa.setLayout(null);
        Mapa.setBounds(150, 80, 500, 500);
        Mapa.setBackground(Color.BLACK);
        //Boton de inicio
        Ginyu = new JButton();
        
        Ginyu.addActionListener(this);
        Ginyu.setBounds(150, 30, 150, 40);
        Ginyu.setFont(new Font("Lucida Bright",3,30));
        Ginyu.setText("Change");
        //Villains side
        fila = -50;
        for (row = 0; row < 12; row++){
            columna = -50;
            for (column = 0; column < 5; column++){
                Tile[row][column] = new JButton();
                
                if ((row!=0&&row!=11)&&(column!=0)){
                    do{
                        loop = Randy.nextInt(15);
                        if ((column!=1&&loop==0)){
                            do{
                                loop = Randy.nextInt(15);
                            } while (loop==0);
                        }
                    } while (loop > 11 || troops[loop][0] <= 0);
                } else loop = 15;
                
                Tile[row][column].setText(String.valueOf(loop));
                Tile[row][column].setName("villain");
                Tile[row][column].addActionListener(this);
                Tile[row][column].setBackground(new Color(255,0,0,255));
                Tile[row][column].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                Tile[row][column].setBounds(fila, columna,50,50);
                Mapa.add(Tile[row][column]);
                columna += 50;
                
                if ((row!=0&&row!=11)&&(column!=0))
                    troops[loop][0]--;
            }
            fila += 50;
        }
        
        for (loop = 0; loop <=11; loop++){
            System.out.println("Tiles ["+loop+"][0]: "+troops[loop][0]);
        }
        
        //Midgard
        fila = -50;
        for (row = 0; row < 12; row++){
            columna = 200;
            for (column = 5; column < 7; column++){
                Tile[row][column] = new JButton();
                if (row==3||row==4||row==7||row==8){
                    Tile[row][column].setName("Ocupado");
                    Tile[row][column].setBackground(new Color(100,100,100,255));
                } else {
                    Tile[row][column].setName("free");
                    Tile[row][column].setBackground(new Color(0,0,0,255));
                }
                Tile[row][column].setText("0");
                Tile[row][column].addActionListener(this); 
                Tile[row][column].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                Tile[row][column].setBounds(fila, columna,50,50);
                Mapa.add(Tile[row][column]);
                columna += 50;
            }
            fila += 50;
        }
        //Heroe's side
        fila = -50;
        for (row = 0; row < 12; row++){
            columna = 300;
            for (column = 7; column < 12; column++){
                Tile[row][column] = new JButton();
                if ((row!=0&&row!=11)&&(column!=11)){
                    do{
                        loop = Randy.nextInt(15);
                        if ((column!=10&&loop==0)){
                            do{
                                loop = Randy.nextInt(15);
                            } while (loop==0);
                        }
                    } while (loop > 11 || troops[loop][1] <= 0);
                } else loop = 15;
                
                Tile[row][column].setText(String.valueOf(loop));
                Tile[row][column].setName("Heroe");
                Tile[row][column].addActionListener(this);
                Tile[row][column].setBackground(new Color(0,0,0,255));
                Tile[row][column].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                Tile[row][column].setBounds(fila, columna,50,50);
                Mapa.add(Tile[row][column]);
                columna += 50;
                                
                if ((row!=0&&row!=11)&&(column!=11))
                    troops[loop][1]--;
            }
            fila += 50;
        }
        
        for (loop = 0; loop <=11; loop++){
            System.out.println("Tiles ["+loop+"][1]: "+troops[loop][1]);
        }
        //Adicion de complementos
        Canva.add(Caja);
        Caja.add(Mapa);
        Caja.add(Ginyu);
        
        Canva.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (row = 0; row < 12; row++){
            for (column = 0; column < 12; column++){
                if (e.getSource()==Tile[row][column]){
                    if ((!Tile[row][column].getText().equals("0")&&(!Tile[row][column].getText().equals("11")))&&datos.isStart()==false && Tile[row][column].getName().equals(datos.getOponent(""))){
                        Tile[row][column].setBackground(new Color(0,0,0,255));
                        change = Tile[row][column].getName();
                        loop = Integer.parseInt(Tile[row][column].getText());
                        row0 = row;
                        column0 = column;
                        
                        row1 = row - 1;
                        if (!Tile[row1][column0].getName().equals("Ocupado")&&!Tile[row1][column0].getName().equals(datos.getOponent(""))){ 
                            Tile[row1][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                            Tile[row1][column0].setBackground(new Color(0,100,0,255));
                            MoVa[0] = true;
                        } else MoVa[0] = false;
                        
                        row2 = row + 1;
                        if ((!Tile[row2][column0].getName().equals("Ocupado"))&&!Tile[row2][column0].getName().equals(datos.getOponent(""))){ 
                            Tile[row2][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                            Tile[row2][column0].setBackground(new Color(0,100,0,255));
                            MoVa[1] = true;
                        } else MoVa[1] = false;
                        
                        column1 = column - 1;  
                        if ((!Tile[row0][column1].getName().equals("Ocupado"))&&(!Tile[row0][column1].getName().equals(datos.getOponent("")))){ 
                            Tile[row0][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                            Tile[row0][column1].setBackground(new Color(0,100,0,255));
                            MoVa[2] = true;
                        } else MoVa[2] = false;
                        
                        column2 = column + 1; 
                        if (!Tile[row0][column2].getName().equals(datos.getOponent(""))){ 
                            Tile[row0][column2].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                            Tile[row0][column2].setBackground(new Color(0,100,0,255));
                            MoVa[3] = true;
                        } else MoVa[3] = false;
                        
                        if (MoVa[0]==true||MoVa[1]==true||MoVa[2]==true||MoVa[3]==true)
                            datos.setStart(true);
                        
                    } else if (datos.isStart()==true && (!Tile[row][column].getName().equals("Ocupado")&&!Tile[row][column].getName().equals(datos.getOponent(""))) &&(((row==row1||row==row2)&&column==column0)||((column==column1||column==column2)&&row==row0))){
                        MoVa[0]=false;
                        
                        if ((Tile[row0][column0].getText().equals("3")&&Tile[row][column].getText().equals("11"))||(Tile[row0][column0].getText().equals("1")&&Tile[row][column].getText().equals("10")))
                            MoVa[0]=true;
                            
                        if (MoVa[0]==true||(Integer.parseInt(Tile[row][column].getText())<Integer.parseInt(Tile[row0][column0].getText()))){
                            Tile[row][column].setBackground(new Color(Tile[row0][column0].getColorModel().getNumColorComponents()));
                            Tile[row][column].setName(change);    
                            Tile[row][column].setText(String.valueOf(loop)); 
                        } else if (Integer.parseInt(Tile[row][column].getText())==Integer.parseInt(Tile[row0][column0].getText())){
                            Tile[row][column].setText("0");
                            Tile[row][column].setName("free");
                            Tile[row][column].setBackground(new Color(0,0,0,255));
                        }
                            Tile[row0][column0].setBackground(new Color(0,0,0,255));
                            Tile[row0][column0].setName("free");
                            Tile[row0][column0].setText("0");
                        
                        Tile[row1][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                        Tile[row1][column0].setBackground(new Color(0,0,0,255));
                        
                        Tile[row2][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                        Tile[row2][column0].setBackground(new Color(0,0,0,255));
                        
                        Tile[row0][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                        Tile[row0][column1].setBackground(new Color(0,0,0,255));
                        
                        Tile[row0][column2].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                        Tile[row0][column2].setBackground(new Color(0,0,0,255));
                        
                        for (row1 = 0; row1 < 12; row1++){
                            for (column1 = 0; column1 < 12; column1++){
                                if (Tile[row1][column1].getName().equals("villain")||Tile[row1][column1].getName().equals("Heroe")){                             
                                Tile[row1][column1].setBackground(new Color(0,0,255,255));
                                Tile[row1][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,3));
                                }
                            }
                        }
                        
                    } else if (datos.isStart()==true && Tile[row][column]==Tile[row0][column0]){
                        Tile[row1][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                        Tile[row1][column0].setBackground(new Color(0,0,0,255));
                        
                        Tile[row2][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                        Tile[row2][column0].setBackground(new Color(0,0,0,255));
                        
                        Tile[row0][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                        Tile[row0][column1].setBackground(new Color(0,0,0,255));
                        
                        Tile[row0][column2].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                        Tile[row0][column2].setBackground(new Color(0,0,0,255));
                        
                        datos.setStart(false);
                    }
                }                    
            }           
        }     
        
        if (e.getSource()==Ginyu){
            if (change.equals("Heroe")){
                for (row1 = 0; row1 < 12; row1++){
                    for (column1 = 0; column1 < 12; column1++){
                        if (Tile[row1][column1].getName().equals("villain")){                             
                            Tile[row1][column1].setBackground(new Color(255,0,0,255));
                            Tile[row1][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,3));
                        }
                    }
                }
                datos.setOponent("villain");
            } else if (change.equals("villain")){
                for (row2 = 0; row2 < 12; row2++){
                    for (column2 = 0; column2 < 12; column2++){
                        if (Tile[row2][column2].getName().equals("Heroe")){                             
                            Tile[row2][column2].setBackground(new Color(0,255,0,255));
                            Tile[row2][column2].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,3));
                        }
                    }
                }
               datos.setOponent("Heroe");
            }

            datos.setStart(false);
        }
    }
    
}
