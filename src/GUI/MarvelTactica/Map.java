package GUI.MarvelTactica;

import Datos.Datardos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    JLabel txtuser1, txtuser2;
    int row0, row1, row2, column0, column1, column2;
    JButton[][] Tile = new JButton[12][12];
    JButton Resign = new JButton();
    String change, turn;
    boolean MoVa[] = new boolean[4];
    boolean valid = false;
    //[rango en si][0-Heroes||1-Villanos]
    int troops[][] = new int [13][2];
    int R2Mov[][] = new int[4][11];
    int Mov, acc1, acc2;
    int loop, column, row, columna, fila;
    
    private void MapHeroe(){
        Randy = new Random();
        //loop inicializacion del mapa        
        for (row = 0; row < 12; row++){
            for (column = 0; column < 12; column++){
                Tile[row][column] = new JButton();
                
                Tile[row][column].setName("free");
                Tile[row][column].setText("0");
            }
        }
        
        for (loop=0; loop < datos.getUsernames().size(); loop++){
            if (datos.getUsernames().get(loop).equals(datos.getUser("")))
                acc1 = loop;
            if (datos.getUsernames().get(loop).equals(datos.getUser2("")))
                acc2 = loop;
        }
        
        //cantidad de heroes||villanos
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
        
        Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icons\\Icon.png")).getImage());
        Canva.setSize(1000,650);
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
        Mapa.setBounds(250, 80, 500, 500);
        Mapa.setBackground(Color.BLACK);
        //Boton de inicio
        Ginyu = new JButton();
        
        Ginyu.addActionListener(this);
        Ginyu.setBounds(250, 30, 200, 40);
        Ginyu.setFont(new Font("Lucida Bright",3,30));
        Ginyu.setText("Change");
        //Resign button
        Resign.addActionListener(this);
        Resign.setBounds(550, 30, 200, 40);
        Resign.setText("Resign");
        Resign.setFont(new Font("Lucida Bright",3,30));
        //user 1 side
        txtuser1 = new JLabel();
        txtuser1.setText(datos.getUser(""));
        if (datos.isSelected()==false){
            txtuser1.setName("villain");
        } else {
            turn = txtuser1.getText();
            txtuser1.setName("Heroe");
        }
        txtuser1.setForeground(Color.white);
        txtuser1.setBounds(0, 30, 250, 50);
        txtuser1.setVerticalAlignment(JLabel.CENTER);
        txtuser1.setHorizontalAlignment(JLabel.CENTER);  
        txtuser1.setFont(new Font("Lucida Bright",3,30)); 
        //user 2 side
        txtuser2 = new JLabel();
        txtuser2.setText(datos.getUser2(""));
        if (datos.isSelected()==true){
            txtuser2.setName("villain");
        } else{
            turn = txtuser2.getText(); 
            txtuser2.setName("Heroe");
        }
        txtuser2.setForeground(Color.white);   
        txtuser2.setBounds(750, 30, 250, 50);
        txtuser2.setVerticalAlignment(JLabel.CENTER);
        txtuser2.setHorizontalAlignment(JLabel.CENTER);
        txtuser2.setFont(new Font("Lucida Bright",3,30));
        //Villains side
        fila = -50;
        do{
           loop = Randy.nextInt(15);
        } while (loop > 9 || loop < 2);
        Tile[loop][1].setName("villain");
        Tile[loop][1].setText("0");
        troops[0][0]--;
        if (loop-1!=0){
            Tile[loop-1][1].setName("villain");
            Tile[loop-1][1].setText("11");
            troops[11][0]--;    
        }
        if (loop+1!=11){
            Tile[loop+1][1].setName("villain");
            Tile[loop+1][1].setText("11");
            troops[11][0]--;
        }
        Tile[loop][2].setName("villain");
        Tile[loop][2].setText("11");
        troops[11][0]--;
        for (row = 0; row < 12; row++){
            columna = -50;
            for (column = 0; column < 5; column++){ 
                
                if (Tile[row][column].getName().equals("free")){ 
                    if ((row!=0&&row!=11)&&(column!=0)){
                        do{
                            loop = Randy.nextInt(15);
                        } while (loop > 11 || troops[loop][0]==0);
                    } else loop = 15;

                    Tile[row][column].setText(String.valueOf(loop));
                    Tile[row][column].setName("villain");
                    if ((row!=0&&row!=11)&&(column!=0))
                        troops[loop][0]--;
                }
                Tile[row][column].addActionListener(this);
                Tile[row][column].setBackground(new Color(255,0,0,255));
                Tile[row][column].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                Tile[row][column].setBounds(fila, columna,50,50);
                Mapa.add(Tile[row][column]);
                columna += 50;

            }
            fila += 50;
        }
        
        //Midgard
        fila = -50;
        for (row = 0; row < 12; row++){
            columna = 200;
            for (column = 5; column < 7; column++){
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
        do{            
            loop = Randy.nextInt(15);
        } while (loop > 9 || loop < 2);
        Tile[loop][10].setName("Heroe");
        Tile[loop][10].setText("0");
        troops[0][1]--;
        if (loop!=1){
            Tile[loop-1][10].setName("Heroe");
            Tile[loop-1][10].setText("11");
            troops[11][1]--;           
        }
        if (loop!=10){
            Tile[loop+1][10].setName("Heroe");
            Tile[loop+1][10].setText("11");
            troops[11][1]--;
        }
        Tile[loop][9].setName("Heroe");
        Tile[loop][9].setText("11");
        troops[11][1]--;
        
        for (row = 0; row < 12; row++){
            columna = 300;
            for (column = 7; column < 12; column++){
                
                if (Tile[row][column].getName().equals("free")){
                    if ((row!=0&&row!=11)&&(column!=11)){
                        do{
                            loop = Randy.nextInt(15);
                        } while (loop > 11 || troops[loop][1] == 0);
                    } else loop = 15;
                                 
                    Tile[row][column].setText(String.valueOf(loop));
                    Tile[row][column].setName("Heroe");
                    if ((row!=0&&row!=11)&&(column!=11))
                        troops[loop][1]--;
                }
                Tile[row][column].addActionListener(this);
                Tile[row][column].setBackground(new Color(0,0,0,255));
                Tile[row][column].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,3));
                Tile[row][column].setBounds(fila, columna,50,50);
                Mapa.add(Tile[row][column]);
                columna += 50;       
            }
            fila += 50;
        }
        
        //Adicion de complementos
        Canva.add(Caja);
        Caja.add(Mapa);
        Caja.add(Resign);
        Caja.add(Ginyu);
        Caja.add(txtuser1);
        Caja.add(txtuser2);
        
        Canva.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Turn: "+turn);
        for (row = 0; row < 12; row++){
            for (column = 0; column < 12; column++){
                if (e.getSource()==Tile[row][column]){
//MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE MOSTRAR MOVIMIENTO DISPONIBLE 
                    if ((!Tile[row][column].getText().equals("0")&&(!Tile[row][column].getText().equals("11")))&&datos.isStart()==false && Tile[row][column].getName().equals(datos.getOponent(""))){
                        Tile[row][column].setBackground(new Color(0,0,0,255));
                        change = Tile[row][column].getName();
                        row0 = row;
                        column0 = column;
                        MoVa[0]=false;
                        MoVa[1]=false; 
                        MoVa[2]=false;
                        MoVa[3]=false;
                        if (!Tile[row][column].getText().equals("2")){
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
                            }

                            row2 = row + 1;
                            if ((!Tile[row2][column0].getName().equals("Ocupado"))&&!Tile[row2][column0].getName().equals(datos.getOponent(""))){ 
                                Tile[row2][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                                Tile[row2][column0].setBackground(new Color(0,100,0,255));
                                MoVa[1] = true;
                            }

                            column1 = column - 1;  
                            if ((!Tile[row0][column1].getName().equals("Ocupado"))&&(!Tile[row0][column1].getName().equals(datos.getOponent("")))){ 
                                Tile[row0][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                                Tile[row0][column1].setBackground(new Color(0,100,0,255));
                                MoVa[2] = true;
                            }

                            column2 = column + 1; 
                            if (!Tile[row0][column2].getName().equals(datos.getOponent(""))){ 
                                Tile[row0][column2].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                                Tile[row0][column2].setBackground(new Color(0,100,0,255));
                                MoVa[3] = true;
                            }

                            if (MoVa[0]==true||MoVa[1]==true||MoVa[2]==true||MoVa[3]==true)
                                datos.setStart(true);
//EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2                            
                        } else if (Tile[row][column].getText().equals("2")){
                            
                            for (int bucle = 0; bucle < 4; bucle++){
                                for (int rep = 0; rep < 11;rep++){
                                    R2Mov[bucle][rep]=0;
                                }
                            }
                            
                            Mov = 0;
                            for (column1 = column0; column1 <= 10;column1++){
                                if (!Tile[row0][column1].getName().equals(datos.getOponent(""))&&!Tile[row0][column1].getName().equals("Ocupado")){
                                    Tile[row0][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                                    Tile[row0][column1].setBackground(new Color(0,100,0,255));
                                    Mov++;
                                    R2Mov[0][Mov] = column1;
                                    MoVa[0]=true;
                                    if (!Tile[row0][column1].getText().equals("0"))
                                        column1 = 10;
                                }
                                if ((Tile[row0][column1].getName().equals("Ocupado")))
                                    column1 = 10;
                            }
                            Mov = 0;
                            for (column1 = column0; column1 >= 1;column1--){  
                                if (!Tile[row0][column1].getName().equals(datos.getOponent(""))&&!Tile[row0][column1].getName().equals("Ocupado")){
                                    Tile[row0][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                                    Tile[row0][column1].setBackground(new Color(0,100,0,255));
                                    Mov++;
                                    R2Mov[1][Mov] = column1;
                                    MoVa[1]=true;
                                    if (!Tile[row0][column1].getText().equals("0"))
                                        column1 = 1;
                                }
                                if ((Tile[row0][column1].getName().equals("Ocupado")))
                                    column1 = 1;
                            }   
                            Mov = 0;
                            for (row1 = row0; row1 <= 10;row1++){  
                                if (!Tile[row1][column0].getName().equals(datos.getOponent(""))&&!Tile[row1][column0].getName().equals("Ocupado")){
                                    Tile[row1][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                                    Tile[row1][column0].setBackground(new Color(0,100,0,255));
                                    Mov++;
                                    R2Mov[2][Mov] = row1;
                                    MoVa[2]=true;
                                    if (!Tile[row1][column0].getText().equals("0"))
                                        row1 = 10;
                                }
                                if ((Tile[row1][column0].getName().equals("Ocupado")))
                                    row1 = 10;
                            }
                            Mov = 0;
                            for (row1 = row0; row1 >= 1;row1--){ 
                                if (!Tile[row1][column0].getName().equals(datos.getOponent(""))&&!Tile[row1][column0].getName().equals("Ocupado")){
                                    Tile[row1][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,4));
                                    Tile[row1][column0].setBackground(new Color(0,100,0,255));
                                    Mov++;
                                    R2Mov[3][Mov] = row1;
                                    MoVa[3]=true;
                                    if (!Tile[row1][column0].getText().equals("0"))
                                        row1 = 1;
                                }
                                if ((Tile[row1][column0].getName().equals("Ocupado")))
                                    row1 = 1;
                            }
                            if (MoVa[0]==true||MoVa[1]==true||MoVa[2]==true||MoVa[3]==true)
                                datos.setStart(true);
                        }
//movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento movimiento 
                    } else if (datos.isStart()==true && (!Tile[row][column].getName().equals("Ocupado")&&!Tile[row][column].getName().equals(datos.getOponent("")))){
                        if (!Tile[row0][column0].getText().equals("2")&&(((row==row1||row==row2)&&column==column0)||((column==column1||column==column2)&&row==row0))){
                            
                            if (Tile[row][column].getText().equals("0") && !Tile[row][column].getName().equals("free")){
                                if (datos.isPractice()==false){
                                    if (turn.equals(txtuser2.getText())){
                                        datos.getPuntos().set(acc1, (datos.getPuntos().get(acc1) + 3));
                                        datos.getWins().set(acc1, (datos.getWins().get(acc1) + 1));
                                        datos.getLosses().set(acc2, datos.getLosses().get(acc2) + 1);
                                    } else if (turn.equals(txtuser1.getText())){
                                        datos.getPuntos().set(acc2, (datos.getPuntos().get(acc2) + 3));
                                        datos.getWins().set(acc2, (datos.getWins().get(acc2) + 1));
                                        datos.getLosses().set(acc1, datos.getLosses().get(acc1) + 1);
                                    }
                                    System.out.println("Acc2: \nPuntos: "+datos.getPuntos().get(acc2)+"\nWins: "+datos.getWins().get(acc2)+"\nLost: "+datos.getLosses().get(acc2));
                                }
                                System.out.println("Acc1: \nPuntos: "+datos.getPuntos().get(acc1)+"\nWins: "+datos.getWins().get(acc1)+"\nLost: "+datos.getLosses().get(acc1));
                                datos.setPractice(false);
                                Canva.dispose();
                                new MainScene(datos).setVisible(false);
                            }
                            
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
                            
                            if (Tile[row][column].getText().equals("11")){
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
                            
                            valid = true;
                            
                            if (turn.equals(txtuser1.getText())){
                                turn = txtuser2.getText();
                            } else turn = txtuser1.getText();
//EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2                             
                        } else if (Tile[row0][column0].getText().equals("2")&&(row==row0||column==column0)){
                            MoVa[0]=false;
                            R2Mov[1][0] = 10;
                            R2Mov[3][0] = 10;
                                for (int rep = 1; rep < 11;rep++){
                                    if (R2Mov[0][0] < R2Mov[0][rep]&&R2Mov[0][rep]!=0)
                                        R2Mov[0][0] = R2Mov[0][rep];
                                    if (R2Mov[1][0] > R2Mov[1][rep]&&R2Mov[1][rep]!=0)
                                        R2Mov[1][0] = R2Mov[1][rep];
                                    if (R2Mov[2][0] < R2Mov[2][rep]&&R2Mov[2][rep]!=0)
                                        R2Mov[2][0] = R2Mov[2][rep];
                                    if (R2Mov[3][0] > R2Mov[3][rep]&&R2Mov[3][rep]!=0)
                                        R2Mov[3][0] = R2Mov[3][rep];
                                }
                                
                                if (Tile[row][column].getText().equals("0") && !Tile[row][column].getName().equals("free")){
                                    if (datos.isPractice()==false){
                                    if (turn.equals(txtuser2.getText())){
                                        datos.getPuntos().set(acc1, (datos.getPuntos().get(acc1) + 3));
                                        datos.getWins().set(acc1, (datos.getWins().get(acc1) + 1));
                                        datos.getLosses().set(acc2, datos.getLosses().get(acc2) + 1);
                                    } else if (turn.equals(txtuser1.getText())){
                                        datos.getPuntos().set(acc2, (datos.getPuntos().get(acc2) + 3));
                                        datos.getWins().set(acc2, (datos.getWins().get(acc2) + 1));
                                        datos.getLosses().set(acc1, datos.getLosses().get(acc1) + 1);
                                    }
                                        System.out.println("Acc2: \nPuntos: "+datos.getPuntos().get(acc2)+"\nWins: "+datos.getWins().get(acc2)+"\nLost: "+datos.getLosses().get(acc2));
                                    }
                                    System.out.println("Acc1: \nPuntos: "+datos.getPuntos().get(acc1)+"\nWins: "+datos.getWins().get(acc1)+"\nLost: "+datos.getLosses().get(acc1));
                                    datos.setPractice(false);
                                    Canva.dispose();
                                    new MainScene(datos).setVisible(false);
                                }
                                
                            if (MoVa[0]==true||(Integer.parseInt(Tile[row][column].getText())<Integer.parseInt(Tile[row0][column0].getText()))){
                                Tile[row][column].setBackground(new Color(Tile[row0][column0].getColorModel().getNumColorComponents()));
                                Tile[row][column].setName(change);    
                                Tile[row][column].setText("2"); 
                            } else if (Integer.parseInt(Tile[row][column].getText())==Integer.parseInt(Tile[row0][column0].getText())){
                                Tile[row][column].setText("0");
                                Tile[row][column].setName("free");
                                Tile[row][column].setBackground(new Color(0,0,0,255));
                            }
                            
                            if (Tile[row][column].getText().equals("11")){
                                Tile[row][column].setText("0");
                                Tile[row][column].setName("free");
                                Tile[row][column].setBackground(new Color(0,0,0,255));
                            }
                            
                                Tile[row0][column0].setBackground(new Color(0,0,0,255));
                                Tile[row0][column0].setName("free");
                                Tile[row0][column0].setText("0");

                            if (R2Mov[0][0]!=0){
                                for (column1 = column0; column1 <= R2Mov[0][0];column1++){
                                    Tile[row0][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,3));
                                    Tile[row0][column1].setBackground(new Color(0,0,0,255));
                                }
                            }
                            
                            if (R2Mov[1][0]!=10){
                                for (column1 = column0; column1 >= R2Mov[1][0];column1--){
                                    Tile[row0][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,3));
                                    Tile[row0][column1].setBackground(new Color(0,0,0,255));                                    
                                }
                            }
                             
                            if (R2Mov[2][0]!=0){
                                for (row1 = row0; row1 <= R2Mov[2][0];row1++){
                                    Tile[row1][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,3));
                                    Tile[row1][column0].setBackground(new Color(0,0,0,255));                                    
                                }
                            }
                            
                            if (R2Mov[3][0]!=10){
                                for (row1 = row0; row1 >= R2Mov[3][0];row1--){ 
                                    Tile[row1][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,3));
                                    Tile[row1][column0].setBackground(new Color(0,0,0,255));
                                }                                
                            }
                        
                            for (row1 = 0; row1 < 12; row1++){
                                for (column1 = 0; column1 < 12; column1++){
                                    if (Tile[row1][column1].getName().equals("villain")||Tile[row1][column1].getName().equals("Heroe")){                             
                                    Tile[row1][column1].setBackground(new Color(0,0,255,255));
                                    Tile[row1][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN,3));
                                    }
                                }
                            }
                            
                            
                            if (turn.equals(txtuser1.getText())){
                                turn = txtuser2.getText();
                            } else turn = txtuser1.getText();
                            
                            valid = true;
                            datos.setStart(true);
                        }
                        valid = true;
//CANCELAR MOVIMIENTO CANCELAR MOVIMIENTO CANCELAR MOVIMIENTO CANCELAR MOVIMIENTO CANCELAR MOVIMIENTO CANCELAR MOVIMIENTO CANCELAR MOVIMIENTO CANCELAR MOVIMIENTO CANCELAR MOVIMIENTO 
                    } else if (datos.isStart()==true && Tile[row][column]==Tile[row0][column0]){
//EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 EN CASO DE SER RANGO 2 
                        if (Tile[row][column].getText().equals("2")){
                            R2Mov[1][0] = 10;
                            R2Mov[3][0] = 10;
                                for (int rep = 1; rep < 11;rep++){
                                    if (R2Mov[0][0] < R2Mov[0][rep]&&R2Mov[0][rep]!=0)
                                        R2Mov[0][0] = R2Mov[0][rep];
                                    if (R2Mov[1][0] > R2Mov[1][rep]&&R2Mov[1][rep]!=0)
                                        R2Mov[1][0] = R2Mov[1][rep];
                                    if (R2Mov[2][0] < R2Mov[2][rep]&&R2Mov[2][rep]!=0)
                                        R2Mov[2][0] = R2Mov[2][rep];
                                    if (R2Mov[3][0] > R2Mov[3][rep]&&R2Mov[3][rep]!=0)
                                        R2Mov[3][0] = R2Mov[3][rep];
                                }
                                
                            if (R2Mov[0][0]!=0){
                                for (column1 = column0; column1 <= R2Mov[0][0];column1++){
                                    Tile[row0][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,3));
                                    Tile[row0][column1].setBackground(new Color(0,0,0,255));
                                }
                            }
                            
                            if (R2Mov[1][0]!=10){
                                for (column1 = column0; column1 >= R2Mov[1][0];column1--){
                                    Tile[row0][column1].setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,3));
                                    Tile[row0][column1].setBackground(new Color(0,0,0,255));                                    
                                }
                            }
                             
                            if (R2Mov[2][0]!=0){
                                for (row1 = row0; row1 <= R2Mov[2][0];row1++){
                                    Tile[row1][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,3));
                                    Tile[row1][column0].setBackground(new Color(0,0,0,255));                                    
                                }
                            }
                            
                            if (R2Mov[3][0]!=10){
                                for (row1 = row0; row1 >= R2Mov[3][0];row1--){ 
                                    Tile[row1][column0].setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,3));
                                    Tile[row1][column0].setBackground(new Color(0,0,0,255));
                                }                                
                            }
                        
                        datos.setStart(false);
                        } else {
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
        }
        
        if (e.getSource()==Ginyu && valid == true){
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
            
            valid = false;
            datos.setStart(false);
        }
        if (e.getSource()==Resign&&valid==false){
            if (datos.isPractice()==false){
                if (turn.equals(txtuser2.getText())){
                    datos.getPuntos().set(acc1, (datos.getPuntos().get(acc1) + 3));
                    datos.getWins().set(acc1, (datos.getWins().get(acc1) + 1));
                    datos.getLosses().set(acc2, datos.getLosses().get(acc2) + 1);
                } else if (turn.equals(txtuser1.getText())){
                    datos.getPuntos().set(acc2, (datos.getPuntos().get(acc2) + 3));
                    datos.getWins().set(acc2, (datos.getWins().get(acc2) + 1));
                    datos.getLosses().set(acc1, datos.getLosses().get(acc1) + 1);
                }
                System.out.println("Acc2: \nPuntos: "+datos.getPuntos().get(acc2)+"\nWins: "+datos.getWins().get(acc2)+"\nLost: "+datos.getLosses().get(acc2));
            }
            System.out.println("Acc1: \nPuntos: "+datos.getPuntos().get(acc1)+"\nWins: "+datos.getWins().get(acc1)+"\nLost: "+datos.getLosses().get(acc1));
            datos.setPractice(false);
            Canva.dispose();
            new MainScene(datos).setVisible(false);
        }
    }
    
}