package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Race extends Formula1ChampionshipManager implements Serializable {


    // create a arraylist and a array to handle positions of races
    ArrayList<String[]> positionsArrayList = new ArrayList<String[]>(); //https://stackoverflow.com/questions/3642205/java-arraylist-of-arrays
    String[] positionArray = new String[12];

    public ArrayList<String[]> getPositionsArrayList() {
        return positionsArrayList;
    }

    public void setPositionsArrayList(ArrayList<String[]> positionsArrayList) {
        this.positionsArrayList = positionsArrayList;
    }

    public String[] getPositionArray() {
        return positionArray;
    }

    public void setPositionArray(String[] positionArray) {
        this.positionArray = positionArray;
    }
}
