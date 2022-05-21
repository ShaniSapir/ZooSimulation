package graphics;
import animals.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.lang.Double.*;
import java.util.ArrayList;

import food.IEdible;
import food.Meat;
import kotlin.jvm.Synchronized;
import mobility.Point;
import plants.*;

import static graphics.IDrawable.PICTURE_PATH;

public class ZooPanel extends JPanel implements ActionListener, Runnable{

    private ArrayList<Animal> animal_arr;
    private Plant plant;
    private Meat meat_food;
    private Thread controller;
    private JButton addAnimal;
    //private JButton moveAnimal;
    private JButton clear;
    private JButton food;
    private JButton info;
    private JButton exit;

    // new buttons
    private JButton sleep;
    private JButton wake_up;


    private JButton lettuce;
    private JButton cabbage;
    private JButton meat;

    private BufferedImage img = null;

    public ZooPanel()
    {
        this.controller = new Thread(this);
        this.controller.start();
        animal_arr = new ArrayList<>();
        this.plant = null;
        this.meat_food = null;
        this.setLayout(new BorderLayout());

        //buttons definitions
        this.addAnimal = new JButton("Add Animal");
        this.sleep = new JButton("Sleep");
        this.wake_up = new JButton("Wake up");
        //this.moveAnimal = new JButton("Move Animal");
        this.clear = new JButton("Clear");
        this.food = new JButton("Food");
        this.lettuce = new JButton("lettuce");
        this.cabbage = new JButton("cabbage");
        this.meat = new JButton("meat");
        this.info = new JButton("Info");
        this.exit = new JButton("Exit");

        //JPanel paint_panel = new JPanel();
        JPanel buttons_panel =  new JPanel();
        buttons_panel.setLayout(new FlowLayout());
        buttons_panel.add(addAnimal);
        buttons_panel.add(sleep);
        buttons_panel.add(wake_up);
        //buttons_panel.add(moveAnimal);
        buttons_panel.add(clear);
        buttons_panel.add(food);
        buttons_panel.add(info);
        buttons_panel.add(exit);



        //paint_panel.setBackground(null);
        buttons_panel.setBackground(Color.blue);
        this.add(buttons_panel, BorderLayout.SOUTH);
        this.setVisible(true);
        this.addAnimal.addActionListener(this);
        this.sleep.addActionListener(this);
        this.wake_up.addActionListener(this);
        //this.moveAnimal.addActionListener(this);
        this.clear.addActionListener(this);
        this.food.addActionListener(this);

        this.info.addActionListener(this);
        this.exit.addActionListener(this);
    }


    /**
     * Drawes the objects
     * @param g drawes the object
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (this.img != null)
        {
            g.drawImage(this.img, 0, 0, getWidth(), getHeight(), this);
        }

        for (int i = 0; i < this.animal_arr.size(); ++i)
        {
            this.animal_arr.get(i).drawObject(g);
        }

        if(plant != null)
        {
            plant.drawObject(g);
        }

        if(meat_food != null)
        {
            meat_food.drawObject(g);
        }
    }

    /**
     * checks if the value changed
     * @return if the value was changed
     */
    private boolean isChange()
    {
        for (int i = 0; i < this.animal_arr.size(); ++i)
        {
            if (this.animal_arr.get(i).getChanges() == true)
                return true;
        }
        return false;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.addAnimal)
        {
            if (this.animal_arr.size() == 10 )
            {
                JOptionPane.showMessageDialog(null, "You can't add more than 10 animals!");
            }
            else
            {
                AddAnimalDialog dialog = new AddAnimalDialog(this,"Add Animal");

            }
        }
        else if(e.getSource() == this.sleep)
        {
            for (int i = 0; i < this.animal_arr.size(); ++i)
            {
                this.animal_arr.get(i).setSuspended();
            }
        }

        else if(e.getSource() == this.wake_up)
        {
            for (int i = 0; i < this.animal_arr.size(); ++i)
            {
                this.animal_arr.get(i).setResumed();
            }

        }

        else if(e.getSource() == this.clear)
        {
            this.animal_arr.clear();
        }

        else if(e.getSource() == this.food)
        {
            JButton[] buttonsArr = {lettuce, cabbage, meat};
            this.lettuce.addActionListener(this);
            this.cabbage.addActionListener(this);
            this.meat.addActionListener(this);
            JOptionPane.showOptionDialog(null, "Please choose food:", "food",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttonsArr, null);

        }

        else if (e.getSource() == this.lettuce)
        {
            plant = new Lettuce();
            repaint();
        }

        else if(e.getSource() == this.cabbage)
        {
            plant = new Cabbage();
            repaint();
        }

        else if(e.getSource() == this.meat)
        {

            meat_food = new Meat("meat");
            repaint();

        }

        else if(e.getSource() == this.info)
        {
            String[] columns = {"Animal", "Color", "Weight", "Hor-Speed", "Ver-Speed", "Eat Counter"};
            JDialog dialog = new JDialog();
            DefaultTableModel dTable = new DefaultTableModel(0, 6);
            dTable.addRow(columns);
            JTable table = new JTable(dTable);
            dialog.add(new JScrollPane());
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            dialog.setSize(500,380);
            dialog.setLocation(380,100);
            dialog.add(table);

            int counter = 0;
            for (int i = 0; i < animal_arr.size(); ++i)
            {
                Object[] animalFieldArr = new Object[6];
                animalFieldArr[0] = animal_arr.get(i).getAnimalName();
                animalFieldArr[1] = animal_arr.get(i).getColor();
                animalFieldArr[2] = animal_arr.get(i).getWeight();
                animalFieldArr[3] = animal_arr.get(i).getHorSpeed();
                animalFieldArr[4] = animal_arr.get(i).getVerSpeed();
                animalFieldArr[5] = animal_arr.get(i).getEatCount();
                counter = counter + animal_arr.get(i).getEatCount();
                dTable.addRow(animalFieldArr);
            }
            Object[] lastRow = new Object[6];
            lastRow[0] = "Total";
            lastRow[1] = "   ";
            lastRow[2] = "   ";
            lastRow[3] = "   ";
            lastRow[4] = "   ";
            lastRow[5] = counter;
            dTable.addRow(lastRow);

        }

        else if(e.getSource() == this.exit) {
            Thread.interrupted();
            this.animal_arr.clear();
            System.exit(0);
        }

    }

    public ZooPanel getPan()
    {
        return this;
    }

    public void addAnimalArr(Animal animal)
    {
        this.animal_arr.add(animal);
    }

    public ArrayList<Animal> getAnimalArr()
    {
        return animal_arr;
    }


    public int getSizeArr()
    {
        return this.animal_arr.size();
    }


    public void setImg(BufferedImage img)
    {
        this.img = img;
    }

    public void setMeat_food()
    {
        this.meat_food = null;
    }

    public Meat getMeat_food()
    {
        return this.meat_food;
    }

    public void setPlant_food()
    {
        this.plant = null;
    }

    public Plant getPlant_food()
    {
        return this.plant;
    }


    /**
     * Run method
     */
    @Override
    public void run()
    {
        while(true)
        {
            repaint();
        }

    }
}
