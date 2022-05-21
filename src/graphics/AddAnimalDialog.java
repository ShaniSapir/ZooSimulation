package graphics;

import animals.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class AddAnimalDialog extends JDialog {

    private JComboBox<String> options;
    private JComboBox<String> color_options;
    private JTextField text_size;
    private JTextField text_horSpeed;
    private JTextField text_verSpeed;

    private String type;
    private String color;
    private int size;
    private int horSpeed;
    private int verSpeed;
    private Animal _animal;

    public AddAnimalDialog(ZooPanel pan, String dialog_name)
    {
        super(new Frame(), dialog_name);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(6, 2));
        this.setSize(1000, 250);
        this.setLocation(new Point(330, 140));
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);

        JLabel option_animal = new JLabel("Please choose an animal:");
        this.add(option_animal);
        this.options = new JComboBox<>();
        this.options.addItem("Elephant");
        this.options.addItem("Lion");
        this.options.addItem("Giraffe");
        this.options.addItem("Turtle");
        this.options.addItem("Bear");

        this.add(options);



        JLabel size_animal = new JLabel("Please enter size between 50 - 300");
        this.add(size_animal);
        this.text_size = new JTextField(10 );
        this.add(this.text_size);

        JLabel hor = new JLabel("Please enter horizontal speed between 1 - 10");
        this.add(hor);
        this.text_horSpeed = new JTextField(10 );
        this.add(this.text_horSpeed);

        JLabel ver = new JLabel("Please enter vertical speed between 1 - 10");
        this.add(ver);
        this.text_verSpeed = new JTextField(10 );
        this.add(this.text_verSpeed);

        // color options field
        JLabel colors = new JLabel("Please choose animal color:");
        this.add(colors);
        this.color_options = new JComboBox<>();
        this.color_options.addItem("Natural");
        this.color_options.addItem("Red");
        this.color_options.addItem("Blue");


        this.add(this.color_options);
        JButton add_button = new JButton("Add Animal");
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text_size.getText().matches("[0-9]+") == false)
                {
                    JOptionPane.showMessageDialog(pan,"The input should contain only digits, Please enter the size in the correct range 50 - 300");

                }
                else if (Integer.parseInt(text_size.getText()) < 50 || Integer.parseInt(text_size.getText()) > 300)
                {
                    JOptionPane.showMessageDialog(pan,"Wrong size of animal, Please enter the size in the correct range 50 - 300");
                }
                else if (text_horSpeed.getText().matches("[0-9]+") == false)
                {
                    JOptionPane.showMessageDialog(pan, "The input should contain only digits, Please enter the size in the correct range 1 - 10");

                }
                else if (Integer.parseInt(text_horSpeed.getText()) < 1 || Integer.parseInt(text_horSpeed.getText()) > 10)
                    JOptionPane.showMessageDialog(pan, "Wrong horizontal speed, Please enter the size in the correct range 1 - 10");

                else if (text_verSpeed.getText().matches("[0-9]+") == false)
                {
                    JOptionPane.showMessageDialog(pan, "The input should contain only digits, Please enter the size in the correct range 1 - 10");

                }

                else if (Integer.parseInt(text_verSpeed.getText()) < 1 || Integer.parseInt(text_horSpeed.getText()) > 10)
                    JOptionPane.showMessageDialog(pan, "Wrong vertical speed, Please enter the size in the correct range 1 - 10");

                else
                {
                    switch (options.getItemAt(options.getSelectedIndex()))
                    {
                        case "Elephant":
                        {
                            pan.addAnimalArr(new Elephant(Integer.parseInt(text_size.getText()), color_options.getItemAt(color_options.getSelectedIndex()),
                                    Integer.parseInt(text_horSpeed.getText()), Integer.parseInt(text_verSpeed.getText()), pan));
                            break;
                        }

                        case "Lion":
                        {
                            pan.addAnimalArr(new Lion(Integer.parseInt(text_size.getText()), color_options.getItemAt(color_options.getSelectedIndex()),
                                    Integer.parseInt(text_horSpeed.getText()), Integer.parseInt(text_verSpeed.getText()), pan));
                            break;
                        }

                        case "Giraffe":
                        {
                            pan.addAnimalArr(new Giraffe(Integer.parseInt(text_size.getText()), color_options.getItemAt(color_options.getSelectedIndex()),
                                    Integer.parseInt(text_horSpeed.getText()), Integer.parseInt(text_verSpeed.getText()), pan));
                            break;
                        }

                        case "Turtle":
                        {
                            pan.addAnimalArr(new Turtle(Integer.parseInt(text_size.getText()), color_options.getItemAt(color_options.getSelectedIndex()),
                                    Integer.parseInt(text_horSpeed.getText()), Integer.parseInt(text_verSpeed.getText()), pan));
                            break;
                        }

                        case "Bear":
                        {
                            pan.addAnimalArr(new Bear(Integer.parseInt(text_size.getText()), color_options.getItemAt(color_options.getSelectedIndex()),
                                    Integer.parseInt(text_horSpeed.getText()), Integer.parseInt(text_verSpeed.getText()), pan));
                            break;
                        }

                    }
                    System.out.println(pan.getSizeArr());
                    //pan.repaint();
                    //pan.manageZoo();
                    dispose();
                }
            }
        });
        this.add(add_button);
        pack();

    }

    /**
     *
     * @return type field
     */
    public String _getType()
    {
        return this.type;
    }

    public String _getColor()
    {
        return this.color;
    }

    /**
     *
     * @return size field
     */
    public int _getSize()
    {
        return this.size;
    }

    public int getHorSpeed()
    {
        return this.horSpeed;
    }

    public int getVerSpeed()
    {
        return this.verSpeed;
    }

    public Animal getAnimal()
    {
        return this._animal;
    }

}



