package health_card;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class frame1 extends JFrame implements ActionListener {

    private Container c;
    private JLabel head_label, head2_label, id, name, contact, date, blood;
    private Font f, f1, f2;
    private JTextField ta, ta1, ta2, ta3, ta4;
    private JButton btn1, btn2;
    private JPanel panel;
    private ImageIcon img2, logo;

    public frame1() {
        components();
    }

    public void components() {
        c = this.getContentPane();
        c.setLayout(null);
        f = new Font("Monospace", Font.BOLD, 20);
        f1 = new Font("Times New Roman", Font.PLAIN, 18);
        f2 = new Font("Times New Roman", Font.BOLD, 16);
        
        //logo
        logo = new ImageIcon(getClass().getResource("plus2.png"));
        this.setIconImage(logo.getImage());

        panel = new JPanel();
        panel.setBounds(10, 5, 570, 400);
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        panel.setLayout(null);
        c.add(panel);

        ta = new JTextField();
        ta1 = new JTextField();
        ta2 = new JTextField();
        ta3 = new JTextField();
        ta4 = new JTextField();

        //Heading
        img2 = new ImageIcon(getClass().getResource("plus.png"));
        head_label = new JLabel(img2);
        head_label.setLayout(null);
        head_label.setBounds(100, 5, 200, 90);
        panel.add(head_label);

        //subhead
        head2_label = new JLabel("Health Card");
        head2_label.setBounds(250, 5, 200, 100);
        head2_label.setForeground(Color.RED);
        head2_label.setFont(f);
        panel.add(head2_label);

        //id
        id = new JLabel("RegNo.    :");
        id.setBounds(10, 100, 150, 20);
        id.setFont(f1);
        ta.setBounds(120, 100, 130, 25);
        ta.setFont(f2);
        panel.add(id);
        panel.add(ta);

        //Name
        name = new JLabel("Name      :");
        name.setBounds(10, 150, 80, 20);
        name.setFont(f1);
        ta1.setBounds(120, 150, 300, 25);
        ta1.setFont(f2);
        panel.add(name);
        panel.add(ta1);

        //Contact
        contact = new JLabel("Contact   :");
        contact.setBounds(10, 200, 80, 20);
        contact.setFont(f1);
        ta2.setBounds(120, 200, 130, 25);
        ta2.setFont(f2);
        panel.add(contact);
        panel.add(ta2);

        //Date
        date = new JLabel("DOA       :");
        date.setBounds(10, 250, 80, 20);
        date.setFont(f1);
        ta3.setBounds(120, 250, 130, 25);
        ta3.setFont(f2);
        panel.add(date);
        panel.add(ta3);

        //blood
        blood = new JLabel("Blood      :");
        blood.setBounds(10, 300, 80, 20);
        blood.setFont(f1);
        ta4.setBounds(120, 300, 130, 25);
        ta4.setFont(f2);
        panel.add(blood);
        panel.add(ta4);

        //Button
        btn1 = new JButton("Entry");
        btn1.setBounds(100, 350, 100, 40);
        panel.add(btn1);

        btn2 = new JButton("Delete");
        btn2.setBounds(400, 350, 100, 40);
        panel.add(btn2);

        btn2.addActionListener(this);
        btn1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(btn2)) {
            ta.setText("");
            ta1.setText("");
            ta2.setText("");
            ta3.setText("");
            ta4.setText("");

        } else if (ae.getSource().equals(btn1)) {
            String Value = ta.getText();
            if (Value.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter information");
            } else {
                String w = ta.getText();
                String x = ta1.getText();
                String y = ta2.getText();
                String z = ta3.getText();
                String p = ta4.getText();

                frame2 frame = new frame2();
                frame.id("ID            :    " + w);
                frame.name("Name        :    " + x);
                frame.contact("Contact    :    " + y);
                frame.date("DOA         :    " + z);
                frame.blood("Blood      :    " + p);
                frame.setVisible(true);

                dispose();
                frame.setBounds(550, 300, 1200, 400);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("Health Card");
            }
        }

    }

    public static void main(String[] args) {

        frame1 frame = new frame1();

        //Frame
        frame.setVisible(true);
        frame.setBounds(550, 300, 600, 450);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Health Card");

    }

}
