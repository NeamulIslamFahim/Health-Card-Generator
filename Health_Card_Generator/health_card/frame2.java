package health_card;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class frame2 extends JFrame implements ActionListener {

    private Container c;
    private JLabel headlabel, head2label, id, name, contact, date, blood, imglabel, head2label2, headlabel2, imglabel2;
    private Font ft, ft1, ft2, ft3;
    private JButton print;
    private JPanel panel, panel2, panel3;
    private ImageIcon img, img2, img3, img4, logo;
    public int pageNum;

    public frame2() {
        components();
    }

    public void id(String w) {
        id.setText(w);
    }

    public void name(String x) {
        name.setText(x);
    }

    public void contact(String y) {
        contact.setText(y);
    }

    public void date(String z) {
        date.setText(z);
    }

    public void blood(String p) {
        blood.setText(p);
    }

    public void components() {
        c = this.getContentPane();
        c.setLayout(null);

        ft = new Font("Monospace", Font.BOLD, 20);
        ft1 = new Font("Times New Roman", Font.PLAIN, 18);
        ft2 = new Font("Times New Roman", Font.BOLD, 16);
        ft3 = new Font("Times New Roman", Font.BOLD, 17);
        
        //logo
        logo = new ImageIcon(getClass().getResource("plus2.png"));
        this.setIconImage(logo.getImage());
        
        //panel3
        panel3 = new JPanel();
        panel3.setBounds(10, 10, 1175, 300);
        panel3.setLayout(null);
        c.add(panel3);

        //Panel
        panel = new JPanel();
        panel.setBounds(10, 10, 575, 290);
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        panel.setLayout(null);
        panel3.add(panel);

        //subhead
        head2label = new JLabel("Health Card");
        head2label.setBounds(250, 5, 200, 100);
        head2label.setFont(ft);
        head2label.setForeground(Color.RED);
        panel.add(head2label);

        //id
        id = new JLabel();
        id.setBounds(10, 100, 200, 20);
        id.setFont(ft3);
        panel.add(id);

        //Name
        name = new JLabel();
        name.setBounds(10, 150, 500, 20);
        name.setFont(ft3);
        panel.add(name);

        //Contact
        contact = new JLabel();
        contact.setBounds(10, 200, 300, 20);
        contact.setFont(ft3);
        panel.add(contact);

        //Date
        date = new JLabel();
        date.setBounds(350, 100, 300, 20);
        date.setFont(ft3);
        panel.add(date);

        //blood
        blood = new JLabel();
        blood.setBounds(350, 150, 300, 20);
        blood.setFont(ft3);
        panel.add(blood);

        //Heading
        img2 = new ImageIcon(getClass().getResource("plus.png"));
        headlabel = new JLabel(img2);
        headlabel.setLayout(null);
        headlabel.setBounds(100, 5, 200, 90);
        panel.add(headlabel);

        //Background Image
        img = new ImageIcon(getClass().getResource("bg_pic.jpg"));
        imglabel = new JLabel(img);
        imglabel.setLayout(null);
        imglabel.setBounds(-5, -5, 580, 300);
        panel.add(imglabel);

        //Another card
        //Panel
        panel2 = new JPanel();
        panel2.setBounds(600, 10, 575, 290);
        panel2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        panel2.setLayout(null);
        panel3.add(panel2);

        //subhead
        head2label2 = new JLabel("Health Card");
        head2label2.setBounds(250, 100, 200, 100);
        head2label2.setFont(ft);
        head2label2.setForeground(Color.RED);
        panel2.add(head2label2);

        //Heading
        img3 = new ImageIcon(getClass().getResource("plus.png"));
        headlabel2 = new JLabel(img3);
        headlabel2.setLayout(null);
        headlabel2.setBounds(100, 100, 200, 90);
        panel2.add(headlabel2);

        //Background Image
        img4 = new ImageIcon(getClass().getResource("bg_pic.jpg"));
        imglabel2 = new JLabel(img4);
        imglabel2.setLayout(null);
        imglabel2.setBounds(-5, -5, 580, 300);
        panel2.add(imglabel2);

        //print button
        print = new JButton("Print out");
        print.setBounds(530, 310, 150, 50);
        c.add(print);

        print.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        PrinterJob job = PrinterJob.getPrinterJob();

        job.setJobName("Print data");

        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics pg, PageFormat pf, int i) throws PrinterException {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D q2 = (Graphics2D) pg;
                q2.translate(pf.getImageableX(), pf.getImageableY());
                q2.scale(0.30, 0.30);

                panel3.printAll(pg);

                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
            };
        }
    }

    public static void main(String[] args) {

        frame2 frame = new frame2();

        //Frame
        frame.setVisible(true);
        frame.setBounds(550, 300, 1200, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Health Card");
    }

}
