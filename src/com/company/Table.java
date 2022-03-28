package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Table {

    public void interface1(){

        //https://www.youtube.com/watch?v=vQfcKRMDoa8
        JFrame frame1 = new JFrame(); // create a frame object

        frame1.setSize(1000,1000);
        frame1.setLayout(new FlowLayout());
        frame1.setTitle("Formula1 Championship");
        frame1.setLocationRelativeTo(null); //to get the frame to middle
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program


        //create buttons
        //https://www.youtube.com/watch?v=jkgHNm5_qSk&list=PLHKWE8jk3adYBRKEEDZgmHc2Xu-c4V9M3&index=3
        JButton button1 = new JButton("Ascending");
        JButton button2 = new JButton("Descending");
        frame1.add(button1);
        frame1.add(button2);

        ascendingTable(button1);
        descendingTable(button2);

        frame1.setVisible(true);
    }

    //table 1
    public void ascendingTable(JButton button1){

        //get new frame
        JFrame frame2 = new JFrame();
        frame2.setSize(1000,1000);
        frame2.setLayout(new FlowLayout());
        frame2.setTitle("Formula1 Championship");
        frame2.setLocationRelativeTo(null); //to get the frame to middle


        frame2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //https://docs.oracle.com/javase/7/docs/api/javax/swing/WindowConstants.html

        //https://www.youtube.com/watch?v=OTpbt8mwxMs&list=PLHKWE8jk3adYBRKEEDZgmHc2Xu-c4V9M3&index=11
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data[][]={ {"jhon","colombo","team1"},
                        {"kamal","kandy","team2"},
                        {"amal","negambo","team3"}};
                String column[]={"Name","Location","Team"};
                JTable jt=new JTable(data,column);
                jt.setBounds(30,40,200,300);
                JScrollPane sp=new JScrollPane(jt);
                frame2.add(sp);
                frame2.setVisible(true); }
        });
    }
    //table 2
    public void descendingTable(JButton button2){

        //get new frame
        JFrame frame3 = new JFrame();
        frame3.setSize(1000,1000);
        frame3.setLayout(new FlowLayout());
        frame3.setTitle("Formula1 Championship");
        frame3.setLocationRelativeTo(null); //to get the frame to middle

        frame3.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //https://www.youtube.com/watch?v=OTpbt8mwxMs&list=PLHKWE8jk3adYBRKEEDZgmHc2Xu-c4V9M3&index=11
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data[][]={ {"jhon","colombo","team1"},
                        {"kamal","kandy","team2"},
                        {"amal","negambo","team3"}};
                String column[]={"Name","Location","Team"};
                JTable jt=new JTable(data,column);
                jt.setBounds(30,40,200,300);
                JScrollPane sp=new JScrollPane(jt);
                frame3.add(sp);
                frame3.setVisible(true); }
        });
    }


}

