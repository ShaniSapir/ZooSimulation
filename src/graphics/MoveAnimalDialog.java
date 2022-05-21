package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MoveAnimalDialog extends JDialog {

    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JRadioButton radio4;
    private JRadioButton radio5;
    private JRadioButton radio6;
    private JRadioButton radio7;
    private JRadioButton radio8;
    private JRadioButton radio9;
    private JRadioButton radio10;
    private JRadioButton[] radioButtonArr;
    private ButtonGroup group;

    private JButton moveButton;
    private JTextField x_location;
    private JTextField y_location;



    public MoveAnimalDialog(ZooPanel pan, String dialog_name)
    {
        super(new Frame(), dialog_name);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(700, 250);
        this.setLocation(new Point(330, 140));
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JLabel label = new JLabel("Please choose animal you want to move:");
        this.add(label);

        group = new ButtonGroup();
        radioButtonArr = new JRadioButton[]{radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10};
        /*for(int i = 0; i < pan.getSizeArr(); ++i)
        {
            radioButtonArr[i] = new JRadioButton("Name: " + pan.getAnimalArr().get(i).getAnimalName() + "     " + "Color: " + pan.getAnimalArr().get(i).getColor() + "     " + "Size: " + Integer.toString(pan.getAnimalArr().get(i).getSize()));
            this.add(radioButtonArr[i]);
        }*/

        for(int i = 0; i < pan.getSizeArr(); ++i)
        {
            radioButtonArr[i] = new JRadioButton("Name: " + pan.getAnimalArr().get(i).getAnimalName() + "     " + "Color: " + pan.getAnimalArr().get(i).getColor() + "     " + "Size: " + Integer.toString(pan.getAnimalArr().get(i).getSize()));
            radioButtonArr[i].addActionListener(null);
            this.add(radioButtonArr[i]);
            group.add(radioButtonArr[i]);
        }



        this.moveButton = new JButton("Move Animal");
        JLabel x_label = new JLabel("Insert new location on the X-Axis between 0-800: ");
        JLabel y_label = new JLabel("Insert new location on the Y-Axis between 0-600: ");
        this.x_location = new JTextField();
        this.x_location.setMaximumSize(new Dimension(100, 50));
        this.y_location = new JTextField();
        this.y_location.setMaximumSize(new Dimension(100, 50));

        this.add(x_label);
        this.add(this.x_location);
        this.add(y_label);
        this.add(this.y_location);
        this.add(this.moveButton);

        this.moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                int index = 0;
                for (int i = 0; i < pan.getSizeArr(); ++i)
                {
                    if (radioButtonArr[i].isSelected() == true)
                    {
                        flag = true;
                        index = i;
                    }
                }

                if (flag == false)
                {
                    JOptionPane.showMessageDialog(null, "Please choose one animal");
                }
                else if (x_location.getText().matches("[0-9]+") == false)
                {
                    JOptionPane.showMessageDialog(pan,"The input should contain only digits, Please enter the x location in the correct range 0-800");
                }
                else if (Integer.parseInt(x_location.getText()) < 0 || Integer.parseInt(x_location.getText()) > 800)
                {
                    JOptionPane.showMessageDialog(pan,"Wrong x location of animal, Please enter correct x location in the range 0-800");
                }
                else if (y_location.getText().matches("[0-9]+") == false)
                {
                    JOptionPane.showMessageDialog(pan,"The input should contain only digits, Please enter the y location in the correct range 0-800");
                }
                else if (Integer.parseInt(y_location.getText()) < 0 || Integer.parseInt(y_location.getText()) > 800)
                {
                    JOptionPane.showMessageDialog(pan,"Wrong y location of animal, Please enter correct y location in the range 0-800");
                }
                else
                {
                    pan.getAnimalArr().get(index).setLocation(new mobility.Point(Integer.parseInt(x_location.getText()),
                            Integer.parseInt(y_location.getText())));
                    pan.getAnimalArr().get(index).setChanges(true);
                    pan.repaint();
                    //pan.manageZoo();
                    dispose();
                }

            }
        });
        this.setVisible(true);

    }


}
