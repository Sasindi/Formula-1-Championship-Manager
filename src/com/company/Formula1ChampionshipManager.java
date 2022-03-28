package com.company;


import java.io.*;
import java.util.*;


public class Formula1ChampionshipManager implements ChampionshipManager, Serializable {


    Scanner input = new Scanner(System.in);
    // create arraylist to put objects with driver details
    ArrayList<Formula1Driver> driverArrayList = new ArrayList<Formula1Driver>();




    @Override
    public void createDriver(){  //create a new driver

        System.out.print("\nEnter name : ");
        String name = input.nextLine();

        System.out.print("\nEnter location : ");
        String location = input.nextLine();

        System.out.print("\nEnter Team :");
        String team = input.nextLine();

        //check that user entered team name already in use or not

        if(driverArrayList.size()!=0){

            for (int tCount=0;tCount<driverArrayList.size();tCount++) {

                if (team.equals(driverArrayList.get(tCount).getTeamName())) {
                    System.out.println("\n******************Invalid!! Try again!!!******************\n");
                    System.out.print("\nEnter Team :");
                    team = input.nextLine();
                    tCount = 0;
                }
            }

        }

        int firstPositionCount = 0;
        int secondPositionCount = 0;
        int thirdPositionCount = 0;

        //create a new object with the details of the new driver and add it to the driverArrayList
        Formula1Driver formulaObject = new Formula1Driver(name,location,team, firstPositionCount, secondPositionCount, thirdPositionCount);
        driverArrayList.add(formulaObject);  //	https://www.delftstack.com/howto/java/adding-objects-to-arraylist/

    }

    @Override
    public void deleteDriverAndTeam() {
        System.out.println("Enter the driver name you want to delete :");
        String driverName = input.nextLine();

        //variable to check whether that user entered name already in the driverArrayList or not
        int deleted =0;

        for(int driverCount=0;driverCount<driverArrayList.size();driverCount++){
            if(driverName.equals(driverArrayList.get(driverCount).getName())){
                driverArrayList.remove(driverCount);
                deleted =1;
            }
        }
        if (deleted==0){ //when user entered name not in the ArrayList, print error message
            System.out.println("\n**********************Invalid Name!**********************\n");
        }

    }

    @Override
    public void changeTheDriver() {

        //remove the existing driver from the team user entered and add new driver to it
        System.out.println("Enter the team name you want to change the driver :");
        String changeTeam= input.nextLine();
        System.out.println("Enter the driver name you want to assign to the team :");
        String changedDriver = input.nextLine();
        System.out.println("Enter the driver's location :");
        String changedLocation = input.nextLine();

        //checks whether the team name entered by the user is already in the arraylist
        for(int driverCount=0;driverCount<driverArrayList.size();driverCount++){
            if(changeTeam.equals(driverArrayList.get(driverCount).getTeamName())){

                //create a new object and add it to the driverArrayList
                int firstPositionCount = 0;
                int secondPositionCount = 0;
                int thirdPositionCount = 0;
                Formula1Driver changeObject = new Formula1Driver(changedDriver,changedLocation,changeTeam, firstPositionCount, secondPositionCount, thirdPositionCount);
                driverArrayList.add(changeObject);

                //remove the changed team from array list
                driverArrayList.remove(driverCount);
            }
        }

    }

    @Override
    public void displayDriver() {

        System.out.println("Enter a driver name to show details : ");
        String driverName = input.nextLine();

        int checkDriver=0;

        //Display all the details of the driver that user asked to display
        for(int driverCount=0;driverCount<driverArrayList.size();driverCount++){
            if(driverName.equals(driverArrayList.get(driverCount).getName())){
                System.out.println("Name of the driver : "+driverArrayList.get(driverCount).getName());
                System.out.println("location           : "+driverArrayList.get(driverCount).getLocation());
                System.out.println("Team name          : "+driverArrayList.get(driverCount).getTeamName());
                System.out.println("1st positions      : "+driverArrayList.get(driverCount).getNumberOfFirstPositions());
                System.out.println("2nd positions      : "+driverArrayList.get(driverCount).getNumberOfSecondPositions());
                System.out.println("3rd positions      : "+driverArrayList.get(driverCount).getNumberOfThirdPositions());
                System.out.println("Total points       : "+driverArrayList.get(driverCount).getTotalPoints());
                System.out.println("number of races    : "+driverArrayList.get(driverCount).getNumberOfRaces());

                checkDriver=1;
            }
        }
        if(checkDriver==0){
            System.out.println("--------------------Invalid Name!!!--------------\n The name you entered is not in the driver list!!!\n**************************************************************\n");
        }

    }

    @Override
    public void displayDriverTable() {
        Collections.sort(driverArrayList); //sort the details into descending order

        // display table according to a string format
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        //https://www.javatpoint.com/how-to-print-table-in-java-using-formatter
        System.out.println(String.format("%20s %20s %20s %20s %20s %20s %20s %20s","Driver Name |","Location |","Team Name |","1st positions count |","2nd position count |","3rd position count |","Total points |","Total races |"));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Formula1Driver driver : driverArrayList){
            System.out.println(String.format("%20s %20s %20s %20s %20s %20s %20s %20s",
                    driver.getName()+"|",
                    driver.getLocation()+"|",
                    driver.getTeamName()+"|",
                    driver.getNumberOfFirstPositions()+"|",
                    driver.getNumberOfSecondPositions()+"|",
                    driver.getNumberOfThirdPositions()+"|",
                    driver.getTotalPoints()+"|",
                    driver.getNumberOfRaces()+"|"));
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }


    }


    public void pointsDriverGot(Race newR) { //count the total points, positions and number of races

        for(int value=2;value<12;value++){
            if(value==2){

                //get the driver object related to a name of the specific driver
                Formula1Driver driver = getDriver(newR.getPositionArray()[value]);

                //set values for positions,total points and number of races of the driver
                driver.setNumberOfFirstPositions(driver.getNumberOfFirstPositions()+1);
                driver.setTotalPoints(driver.getTotalPoints()+25);
                driver.setNumberOfRaces(driver.getNumberOfRaces()+1);

            }else if(value==3){

                //get the driver object related to a name of the specific driver
                Formula1Driver driver = getDriver(newR.getPositionArray()[value]);

                //set values for positions,total points and number of races of the driver
                driver.setNumberOfSecondPositions(driver.getNumberOfSecondPositions()+1);
                driver.setTotalPoints(driver.getTotalPoints()+18);
                driver.setNumberOfRaces(driver.getNumberOfRaces()+1);

            }else if(value==4){

                //get the driver object related to a name of the specific driver
                Formula1Driver driver = getDriver(newR.getPositionArray()[value]);

                //set values for positions,total points and number of races of the driver
                driver.setNumberOfThirdPositions(driver.getNumberOfThirdPositions()+1);
                driver.setTotalPoints(driver.getTotalPoints()+15);
                driver.setNumberOfRaces(driver.getNumberOfRaces()+1);

            }else if(value==5){

                //get the driver object related to a name of the specific driver
                Formula1Driver driver = getDriver(newR.getPositionArray()[value]);

                //set values for total points and number of races of the driver
                driver.setTotalPoints(driver.getTotalPoints()+12);
                driver.setNumberOfRaces(driver.getNumberOfRaces()+1);

            }else if(value==6){

                //get the driver object related to a name of the specific driver
                Formula1Driver driver = getDriver(newR.getPositionArray()[value]);

                //set values for total points and number of races of the driver
                driver.setTotalPoints(driver.getTotalPoints()+10);
                driver.setNumberOfRaces(driver.getNumberOfRaces()+1);

            }else if(value==7){

                //get the driver object related to a name of the specific driver
                Formula1Driver driver = getDriver(newR.getPositionArray()[value]);

                //set values for total points and number of races of the driver
                driver.setTotalPoints(driver.getTotalPoints()+8);
                driver.setNumberOfRaces(driver.getNumberOfRaces()+1);

            }else if(value==8){

                //get the driver object related to a name of the specific driver
                Formula1Driver driver = getDriver(newR.getPositionArray()[value]);

                //set values for total points and number of races of the driver
                driver.setTotalPoints(driver.getTotalPoints()+6);
                driver.setNumberOfRaces(driver.getNumberOfRaces()+1);

            }else if(value==9){

                //get the driver object related to a name of the specific driver
                Formula1Driver driver = getDriver(newR.getPositionArray()[value]);

                //set values for total points and number of races of the driver
                driver.setTotalPoints(driver.getTotalPoints()+4);
                driver.setNumberOfRaces(driver.getNumberOfRaces()+1);

            }else if(value==10){

                //get the driver object related to a name of the specific driver
                Formula1Driver driver = getDriver(newR.getPositionArray()[value]);

                //set values for total points and number of races of the driver
                driver.setTotalPoints(driver.getTotalPoints()+2);
                driver.setNumberOfRaces(driver.getNumberOfRaces()+1);

            }else{

                //get the driver object related to a name of the specific driver
                Formula1Driver driver = getDriver(newR.getPositionArray()[value]);

                //set values for total points and number of races of the driver
                driver.setTotalPoints(driver.getTotalPoints()+1);
                driver.setNumberOfRaces(driver.getNumberOfRaces()+1);

            }
        }



    }

    //find the driver object related to a specific driver
    public Formula1Driver getDriver(String name){
        for(Formula1Driver driver : driverArrayList){
            if(driver.getName().equalsIgnoreCase(name)){
                return driver;
            }
        }
        return null;
    }


    public void fileRead() throws IOException, ClassNotFoundException { //load arraylist from the file

        //https://www.youtube.com/watch?v=l__bi60QeBU

        try {
            FileInputStream fin = new FileInputStream("testFile.txt");
            ObjectInputStream object = new ObjectInputStream(fin);

            driverArrayList = (ArrayList<Formula1Driver>) object.readObject();

            fin.close();
            object.close();
        }catch(FileNotFoundException Ignored){

        }


    }

    public void saveDetails() throws IOException { // save arraylist into the file

        //https://www.youtube.com/watch?v=l__bi60QeBU
        FileOutputStream fos = new FileOutputStream("testFile.txt");
        ObjectOutputStream object = new ObjectOutputStream(fos);

        object.writeObject(driverArrayList);
        object.flush();
        fos.close();
        object.close();
    }

    //if user want to add a race, system should have details of 10 drivers
    public void addRace() {

        Race r1 = new Race(); //create a race object

        String driver = "";

        System.out.println("Enter the race : ");
        String race = input.nextLine();
        r1.getPositionArray()[0] = race;  // add the name of the race to the positionArray

        System.out.println("Enter the date : ");
        String date = input.nextLine();
        r1.getPositionArray()[1] = date; //add the date to the positionArray

        for (int count = 2; count < 12; count++) {

            //variable to check the name is exist or not
            int countToRepeat=0;

            System.out.println("Enter the name of the driver who won the " + (count - 1) + " place : ");
            driver = input.nextLine();


            for (int driverCount = 0; driverCount < driverArrayList.size(); driverCount++) {

                if (driver.equals(driverArrayList.get(driverCount).getName())) {
                    countToRepeat=1;
                    r1.getPositionArray()[count] = driver; //add the driver names to the positionArray according to the position they got
                    break;
                }

            }

            // print error message and repeat the process when user enter a name which is not in the driver arraylist
            if(countToRepeat==0){
                System.out.println("\n************Name you entered is invalid!************\n");
                count=count-1;
            }
        }

        //add positionArray to the 'positions' array list
        r1.getPositionsArrayList().add(r1.getPositionArray());

        //calculate the points drivers got according to the positions by calling pointsDriverGot  method
        pointsDriverGot(r1);

    }


}

