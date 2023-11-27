package entity;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import entity.Character;
import entity.DndClass;
import entity.Inventory;
import entity.Item;
import not_implemented.*;
import com.google.gson.*;
import java.io.File;
import java.io.FileWriter;

public class Player2  {
    public String name;


    public void setName(String g) {
        this.name = g;
    }

    public void generatejson () throws IOException {
        Gson g = new Gson();
        //File myObj = new File(this.name + ".txt");
        FileWriter myWriter = new FileWriter(this.name + ".txt");
        myWriter.write(g.toJson(this));
        myWriter.close();
    }

}
