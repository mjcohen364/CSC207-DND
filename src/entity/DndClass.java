package entity;

import java.sql.Array;
import java.util.ArrayList;

import entity.Item;
import not_implemented.*;

public class DndClass {
    ArrayList<Proficiency> classProficiencies = new ArrayList<Proficiency>();
    DndSubClass subclass;
    ArrayList<Item> classEquipment = new ArrayList<Item>();
    ArrayList<Feature> classFeatures = new ArrayList<Feature>();
    ArrayList<Spell> classSpells = new ArrayList<Spell>();
}
