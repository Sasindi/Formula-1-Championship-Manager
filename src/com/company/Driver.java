package com.company;


import java.io.Serializable;

public abstract class Driver implements Serializable {

        String name;
        String location;
        String teamName;

        //constructor
        public Driver(String name,String location,String teamName){
            this.name=name;
            this.location=location;
            this.teamName=teamName;
        }

        //default constructor
        public Driver() {
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getName() {
            return name;
        }

        public String getTeamName() {
            return teamName;
        }

        public String getLocation() {
            return location;
        }

        public void setName(String name) {
            this.name = name;
        }


}
