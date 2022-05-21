package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;

import static graphics.IDrawable.PICTURE_PATH;

public class ZooFrame extends JFrame
{

    public ZooFrame(String name)
    {
        //frame
        super(name);
        this.setSize(1000, 600);
        this.add(new ZooPanel());


        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        //menus
        JMenu file = new JMenu("File");
        JMenu background = new JMenu("Background");
        JMenu help = new JMenu("Help");

        //options
        JMenuBar mb = new JMenuBar();
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem image = new JMenuItem("Image");
        JMenuItem green = new JMenuItem("Green");
        JMenuItem none = new JMenuItem("None");
        JMenuItem _help = new JMenuItem("Help");

        file.add(exit);
        background.add(image);
        background.add(green);
        background.add(none);
        help.add(_help);

        mb.add(file);
        mb.add(background);
        mb.add(help);
        this.setJMenuBar(mb);
        ZooPanel panel = new ZooPanel();
        this.add(panel);
        JLabel label = new JLabel();
        this.setVisible(true);
        this.add(label);
        //this.setVisible(true);




        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setImg(null);
                label.setIcon(null);
                panel.setBackground(Color.GREEN);
              //  getContentPane().setBackground(Color.GREEN);

                /*label.setIcon(null);
                getContentPane().setBackground(Color.GREEN);*/
            }
        });

        image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try { panel.setImg(ImageIO.read(new File(PICTURE_PATH + "\\" + "savanna.png"))); }
                catch (IOException ex) { System.out.println("Cannot load image"); }
                panel.repaint();

            }
        });

        none.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setImg(null);
                label.setIcon(null);
                panel.setBackground(null);

            }
        });

        //JDialog d = new JDialog(this, "Dialog Example", true);
        //d.setVisible(true);

        _help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = new JOptionPane();
                pane.showMessageDialog(null, "Home Work 2 GUI");
            }
        });

    }


    public static void main(String[] args)
    {
        new ZooFrame("Zoo");
        //ZooFrame n = new ZooFrame("Zoo");
        //ZooPanel b = new ZooPanel();
        //n.add(b);

    }





}
