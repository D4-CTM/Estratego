package projecto2_grupo2;

import Datos.Datardos;
import GUI.MarvelTactica.MainScene;

public class Projecto2_Grupo2 {

    public static void main(String[] args) {
        Datardos dato = new Datardos();
        dato.getUsernames().add("Guest");
        dato.getPasses().add("");
        dato.getNames().add("Guest");
        dato.setUser("Guest");
        dato.setChange(false);
        
        new MainScene(dato).setVisible(false);
    }

}
