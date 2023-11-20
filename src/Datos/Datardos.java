package Datos;

import java.util.ArrayList;

public class Datardos {

    /**
     * @return the MirrorUsernames
     */
    public ArrayList<String> getMirrorUsernames() {
        return MirrorUsernames;
    }

    /**
     * @param MirrorUsernames the MirrorUsernames to set
     */
    public void setMirrorUsernames(ArrayList<String> MirrorUsernames) {
        this.MirrorUsernames = MirrorUsernames;
    }

    /**
     * @return the MirrorPuntos
     */
    public ArrayList<Integer> getMirrorPuntos() {
        return MirrorPuntos;
    }

    /**
     * @param MirrorPuntos the MirrorPuntos to set
     */
    public void setMirrorPuntos(ArrayList<Integer> MirrorPuntos) {
        this.MirrorPuntos = MirrorPuntos;
    }

    /**
     * @return the Taken
     */
    public ArrayList<String> getTaken() {
        return Taken;
    }

    /**
     * @param Taken the Taken to set
     */
    public void setTaken(ArrayList<String> Taken) {
        this.Taken = Taken;
    }

    /**
     * @return the practice
     */
    public boolean isPractice() {
        return practice;
    }

    /**
     * @param practice the practice to set
     */
    public void setPractice(boolean practice) {
        this.practice = practice;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @param string the value of string
     * @return the java.lang.String
     */
    public String getUser2(String string) {
        return user2;
    }

    /**
     * @param user2 the user2 to set
     */
    public void setUser2(String user2) {
        this.user2 = user2;
    }

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
    public static ArrayList<String> Taken = new ArrayList();
    public static ArrayList<String> MirrorUsernames = new ArrayList();
    public static ArrayList<Integer> Puntos = new ArrayList();
    public static ArrayList<Integer> MirrorPuntos = new ArrayList();
    public static ArrayList<Integer> Losses = new ArrayList();
    public static ArrayList<Integer> Wins = new ArrayList();
    public static ArrayList<Integer> Heroes = new ArrayList();
    public static ArrayList<Integer> Villanos = new ArrayList();
    public static String user;
    public static String user2;
    public static String oponent;
    public static String faltante;
    public static boolean practice;
    public static boolean selected;
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
