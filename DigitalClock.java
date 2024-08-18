package Minor_Project;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.text.*;


class Clock extends JLabel implements ActionListener{

    String pattern;
    SimpleDateFormat sdf;

    public Clock(String pattern){

        this.pattern = pattern;

        switch(pattern) {
            case "date" : sdf = new SimpleDateFormat("   dd MMMM, yyyy");
                setFont(new Font("DialogInput", Font.PLAIN, 16));
                setHorizontalAlignment(LEFT);
                setForeground(Color.MAGENTA);
                break;

            case "time" :  sdf = new SimpleDateFormat("hh:mm:ss a");
                setFont(new Font("Monospaced", Font.PLAIN, 44));
                setHorizontalAlignment(CENTER);
                setForeground(Color.CYAN);
                break;

            case "day" :  sdf = new SimpleDateFormat("EEEE  ");
                setFont(new Font("DialogInput", Font.PLAIN, 16));
                setHorizontalAlignment(RIGHT);
                setForeground(Color.MAGENTA);
                break;

            default :
                sdf = new SimpleDateFormat();
                break;
        }

        Timer t = new Timer(1000, this);
        t.start();
    }

public static class DigitalClock {
    public static void main(String[] args) {

        Clock date = new Clock("date");
        Clock time = new Clock("time");
        Clock day = new Clock("day");

        JFrame f = new JFrame("Watch");
        f.setSize(360, 220);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(3,1));
        f.getContentPane().setBackground(Color.BLACK);
        f.setResizable(false);

        f.add(date);
        f.add(time);
        f.add(day);
        f.setVisible(true);

    }
}
    @Override
    public void actionPerformed(ActionEvent ae) {

        Date d = new Date();
        setText(sdf.format(d));

    }
}
