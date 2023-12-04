package entity;
import not_implemented.*;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PlayerCreator {
    String name;
    String background;
    String dndclass;
    String race;
    public void setname(String v){
        this.name =v;
    }
    public void setbackground(String v){
        this.background =v;
    }
    public void setdndclass(String v){
        this.dndclass =v;
    }
    public void setrace(String v) {
        this.race = v;
    }

    public String getbackground(){
        return this.background;
    }
    public String getdndclass(){
        return this.dndclass;
    }
    public String getrace() {
        return this.race;
    }
    public void incorporate(Player player){

    }
    public Player readjson (String path) throws IOException {
        Gson g = new Gson();
        String content = new String(Files.readAllBytes(Paths.get(path)));
        return g.fromJson(content, Player.class);
    }
    static public Player2 readjson2 (String path) throws IOException {
        Gson g = new Gson();
        String content = new String(Files.readAllBytes(Paths.get(path)));
        return g.fromJson(content, Player2.class);
    }
    static public PlayerCreator readjson3 (String path) {
        try {
        Gson g = new Gson();
        String content = new String(Files.readAllBytes(Paths.get(path)));
        return g.fromJson(content, PlayerCreator.class);
        } catch (IOException io) {
            //idk
        }
        return null;
    }
    public void generatejson() {
        Gson g = new Gson();
        //File myObj = new File(this.name + ".txt");
        try {
            FileWriter myWriter = new FileWriter(this.name + ".txt");
            myWriter.write(g.toJson(this));
            myWriter.close();
        } catch (IOException io) {
            System.out.println("fail");//idk
        }
        Gson s = new Gson();
        try {
            FileWriter myWriter = new FileWriter(this.name + " export.json");
            myWriter.write(s.toJson(new Player2(this)));
            myWriter.close();
        } catch (IOException io) {
            System.out.println("fail");//idk
        }
    }
}
