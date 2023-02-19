import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Forma extends JFrame{
    
    private Container container;

    private JTextField textField;
    private JButton redButton;
    private JButton blueButton;
    private JButton yellowButton;
    private JButton red1Button;

    private JButton fvis;
    private JButton tvis;
    private JButton clear;

    private JButton umn;
    private JButton plu;
    private JButton zer;

    public Forma(){

        super("Форма");
        super.setBounds(100, 100, 500, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLayout(null);

        container = super.getContentPane();

        textField = new JTextField();
        textField.setBounds(10, 10, 465, 30);

        redButton = new JButton("Красный");
        redButton.setBounds(10, textField.getY()+textField.getHeight()+10, 100, 20);
        redButton.addActionListener(new ColorAction());
        blueButton = new JButton("Синий");
        blueButton.setBounds(10, redButton.getY()+redButton.getHeight()+10, 100, 20);
        blueButton.addActionListener(new ColorAction());
        yellowButton = new JButton("Желтый");
        yellowButton.setBounds(10, blueButton.getY()+blueButton.getHeight()+10, 100, 20);
        yellowButton.addActionListener(new ColorAction());
        red1Button = new JButton("Красный");
        red1Button.setBounds(10, yellowButton.getY()+yellowButton.getHeight()+10, 100, 20);
        red1Button.addActionListener(new ColorAction());
        fvis = new JButton("Скрыть");
        fvis.setBounds(10, red1Button.getY()+red1Button.getHeight()+10, 100, 20);
        fvis.addActionListener(new SettingAction());
        tvis = new JButton("Показать");
        tvis.setBounds(10, fvis.getY()+fvis.getHeight()+10, 100, 20);
        tvis.addActionListener(new SettingAction());
        clear = new JButton("Очистить");
        clear.setBounds(10, tvis.getY()+tvis.getHeight()+10, 100, 20);
        clear.addActionListener(new SettingAction());
        umn = new JButton("*****");
        umn.setBounds(10, clear.getY()+clear.getHeight()+10, 100, 20);
        umn.addActionListener(new AddAction());
        plu = new JButton("+++++");
        plu.setBounds(10, umn.getY()+umn.getHeight()+10, 100, 20);
        plu.addActionListener(new AddAction());
        zer = new JButton("00000");
        zer.setBounds(10, plu.getY()+plu.getHeight()+10, 100, 20);
        zer.addActionListener(new AddAction());

        container.add(textField);
        container.add(redButton);
        container.add(blueButton);
        container.add(yellowButton);
        container.add(red1Button);
        container.add(fvis);
        container.add(tvis);
        container.add(clear);
        container.add(umn);
        container.add(plu);
        container.add(zer);

    }

    private class ColorAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            switch (e.getActionCommand()) {
                case "Красный":
                    textField.setBackground(Color.red);
                    break;
                case "Синий":
                    textField.setBackground(Color.BLUE);
                    break;
                case "Желтый":
                    textField.setBackground(Color.yellow);
                    break;
            
                default:
                    break;
            }

        }

    }

    private class AddAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            textField.setText(textField.getText()+e.getActionCommand());
        }

    }

    private class SettingAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            switch (e.getActionCommand()) {
                case "Скрыть":
                    textField.setVisible(false);
                    break;
                case "Показать":
                    textField.setVisible(true);
                    break;
                case "Очистить":
                    textField.setText("");
                    break;
            
                default:
                    break;
            }

        }

    }

}
