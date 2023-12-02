package entity;
import not_implemented.*;
import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PlayerCreator {
    String name;
    Background background;
    DndClass dndclass;
    Race race;
    public void setname(String v){
        this.name =v;
    }
    public void setbackground(Background v){
        this.background =v;
    }
    public void setdndclass(DndClass v){
        this.dndclass =v;
    }
    public void setrace(Race v) {
        this.race = v;
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
}
