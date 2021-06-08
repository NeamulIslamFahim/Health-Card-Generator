package health_card;

import javax.swing.JFrame;

public class Card {

    public static void main(String[] args) {
        frame1 frame = new frame1();

        //Frame
        frame.setVisible(true);
        frame.setBounds(550, 300, 605, 465);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Health Card");

    }

}
