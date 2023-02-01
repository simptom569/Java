import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    
    private char sign;
    private String text;
    private JButton[] buttons;

    private Container container;
    private JPanel panel1;
    private JPanel panel2;
    private JTextField textfield;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton plus;
    private JButton minus;
    private JButton umnozit;
    private JButton delit;
    private JButton ravno;

    public Calculator(){
        super("Калькулятор");
        super.setBounds(200, 200, 220, 270);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

        container = super.getContentPane();
        container.setLayout(new BorderLayout());
        
        sign = '0';
        buttons = new JButton[4];

        panel1 = new JPanel();
        panel2 = new JPanel();
        textfield = new JTextField(20);
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        button0 = new JButton("0");
        plus = new JButton("+");
        minus = new JButton("-");
        umnozit = new JButton("*");
        delit = new JButton("/");
        ravno = new JButton("=");

        buttons[0] = plus;
        buttons[1] = minus;
        buttons[2] = umnozit;
        buttons[3] = delit;

        button1.addActionListener(new ButtonEvent());
        button2.addActionListener(new ButtonEvent());
        button3.addActionListener(new ButtonEvent());
        button4.addActionListener(new ButtonEvent());
        button5.addActionListener(new ButtonEvent());
        button6.addActionListener(new ButtonEvent());
        button7.addActionListener(new ButtonEvent());
        button8.addActionListener(new ButtonEvent());
        button9.addActionListener(new ButtonEvent());
        button0.addActionListener(new ButtonEvent());
        plus.addActionListener(new SignEvent());
        minus.addActionListener(new SignEvent());
        umnozit.addActionListener(new SignEvent());
        delit.addActionListener(new SignEvent());
        ravno.addActionListener(new EquallyEvent());

        textfield.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 30));
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);

        panel1.setLayout(new GridLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        panel2.setLayout(new GridLayout(4, 4, 10, 10));
        panel2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        panel1.add(textfield);

        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(plus);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(minus);
        panel2.add(button7);
        panel2.add(button8);
        panel2.add(button9);
        panel2.add(umnozit);
        panel2.add(button0);
        panel2.add(delit);
        panel2.add(ravno);

        container.add(panel1, BorderLayout.NORTH);
        container.add(panel2, BorderLayout.CENTER);
    }

    class ButtonEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            textfield.setText(textfield.getText() + e.getActionCommand());
        }

    }

    class SignEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            sign = e.getActionCommand().charAt(0);
            for (JButton but : buttons){
                for (ActionListener al : but.getActionListeners()){
                    but.removeActionListener(al);
                }
            }
            textfield.setText(textfield.getText() + e.getActionCommand());
        }

    }

    class EquallyEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            text = textfield.getText();
            String[] value;
            String result;
            value = text.split("\\" + sign);

            switch (sign) {
                case '+':
                    result = Integer.toString(Integer.parseInt(value[0]) + Integer.parseInt(value[1]));
                    break;
                case '-':
                    result = Integer.toString(Integer.parseInt(value[0]) - Integer.parseInt(value[1]));
                    break;
                case '*':
                    result = Integer.toString(Integer.parseInt(value[0]) * Integer.parseInt(value[1]));
                    break;
                case '/':
                    result = Integer.toString(Integer.parseInt(value[0]) / Integer.parseInt(value[1]));
                    break;

                default:
                    result = value[0];
                    break;
            }

            textfield.setText(result);

            for (JButton but : buttons){
                but.addActionListener(new SignEvent());
            }
        }

    }

}