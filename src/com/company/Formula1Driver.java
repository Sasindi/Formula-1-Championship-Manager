package com.company;

import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable,Comparable<Formula1Driver>{

    int numberOfFirstPositions;
    int numberOfSecondPositions;
    int numberOfThirdPositions;
    int totalPoints;
    int numberOfRaces;




    //constructor with driver details
    public Formula1Driver(String name,String location,String teamName,int numberOfFirstPositions,int numberOfSecondPositions,int numberOfThirdPositions){

        super(name,location,teamName);
        this.numberOfFirstPositions=numberOfFirstPositions;
        this.numberOfSecondPositions=numberOfSecondPositions;
        this.numberOfThirdPositions=numberOfThirdPositions;

    }

    public Formula1Driver(){ //https://www.javatpoint.com/super-keyword  and  1.	https://www.youtube.com/watch?v=1ZDApgnufSI
        super(); //reuse parent constructor
    }


    public int getNumberOfFirstPositions() {
        return numberOfFirstPositions;
    }

    public void setNumberOfFirstPositions(int numberOfFirstPositions) {
        this.numberOfFirstPositions = numberOfFirstPositions;
    }

    public int getNumberOfSecondPositions() {
        return numberOfSecondPositions;
    }

    public void setNumberOfSecondPositions(int numberOfSecondPositions) {
        this.numberOfSecondPositions = numberOfSecondPositions;
    }

    public int getNumberOfThirdPositions() {
        return numberOfThirdPositions;
    }

    public void setNumberOfThirdPositions(int numberOfThirdPositions) {
        this.numberOfThirdPositions = numberOfThirdPositions;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }


    //compare drivers according to the points and positions
    @Override
    public int compareTo(Formula1Driver obj) {  //https://www.youtube.com/watch?v=8FxnM6pqbZ8
        if(totalPoints==obj.totalPoints){

            //check position count when total points are same
            if(numberOfFirstPositions==obj.numberOfFirstPositions){
                return 0;
            }else if(numberOfFirstPositions<obj.numberOfFirstPositions){
                return 1;
            }else{
                return -1;
            }

        }else if(totalPoints<obj.totalPoints){
            return 1;
        }else {
            return -1;
        }
    }
}


