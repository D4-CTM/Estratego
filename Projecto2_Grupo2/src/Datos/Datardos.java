package Datos;

import java.util.ArrayList;

public class Datardos {

    /**
     * @return the change
     */
    public boolean isChange() {
        return change;
    }

    /**
     * @param change the change to set
     */
    public void setChange(boolean change) {
        this.change = change;
    }

    /**
     * @return the Heroes
     */
    public ArrayList<Integer> getHeroes() {
        return Heroes;
    }

    /**
     * @param Heroes the Heroes to set
     */
    public void setHeroes(ArrayList<Integer> Heroes) {
        this.Heroes = Heroes;
    }

    /**
     * @return the Villanos
     */
    public ArrayList<Integer> getVillanos() {
        return Villanos;
    }

    /**
     * @param Villanos the Villanos to set
     */
    public void setVillanos(ArrayList<Integer> Villanos) {
        this.Villanos = Villanos;
    }

    /**
     * @return the user
     */
    public String getUser(String text) {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the Usernames
     */
    public ArrayList<String> getUsernames() {
        return Usernames;
    }

    /**
     * @param Usernames the Usernames to set
     */
    public void setUsernames(ArrayList<String> Usernames) {
        this.Usernames = Usernames;
    }

    /**
     * @return the Names
     */
    public ArrayList<String> getNames() {
        return Names;
    }

    /**
     * @param Names the Names to set
     */
    public void setNames(ArrayList<String> Names) {
        this.Names = Names;
    }

    /**
     * @return the Passes
     */
    public ArrayList<String> getPasses() {
        return Passes;
    }

    /**
     * @param Passes the Passes to set
     */
    public void setPasses(ArrayList<String> Passes) {
        this.Passes = Passes;
    }

    /**
     * @return the Puntos
     */
    public ArrayList<Integer> getPuntos() {
        return Puntos;
    }

    /**
     * @param Puntos the Puntos to set
     */
    public void setPuntos(ArrayList<Integer> Puntos) {
        this.Puntos = Puntos;
    }

    /**
     * @return the Losses
     */
    public ArrayList<Integer> getLosses() {
        return Losses;
    }

    /**
     * @param Losses the Losses to set
     */
    public void setLosses(ArrayList<Integer> Losses) {
        this.Losses = Losses;
    }

    /**
     * @return the Wins
     */
    public ArrayList<Integer> getWins() {
        return Wins;
    }

    /**
     * @param Wins the Wins to set
     */
    public void setWins(ArrayList<Integer> Wins) {
        this.Wins = Wins;
    }
    
    public static ArrayList<String> Usernames = new ArrayList();
    public static ArrayList<String> Names = new ArrayList();
    public static ArrayList<String> Passes = new ArrayList();
    public static ArrayList<Integer> Puntos = new ArrayList();
    public static ArrayList<Integer> Losses = new ArrayList();
    public static ArrayList<Integer> Wins = new ArrayList();
    public static ArrayList<Integer> Heroes = new ArrayList();
    public static ArrayList<Integer> Villanos = new ArrayList();
    public static String user;
    public static String oponent;
    public static String faltante;
    public static boolean start;
    public static boolean change;
    
    
    /**
     * @param string the value of string
     * @return the java.lang.String
     */
    public String getFaltante(String string) {
        return faltante;
    }

    /**
     * @param faltante the faltante to set
     */
    public void setFaltante(String faltante) {
        this.faltante = faltante;
    }

    /**
     * @param string the value of string
     * @return the java.lang.String
     */
    public String getOponent(String string) {
        return oponent;
    }

    /**
     * @param oponent the oponent to set
     */
    public void setOponent(String oponent) {
        this.oponent = oponent;
    }
    
    /**
     * @return the start
     */
    public boolean isStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(boolean start) {
        this.start = start;
    }
}
