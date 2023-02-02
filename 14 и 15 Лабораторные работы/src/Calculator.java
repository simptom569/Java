import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

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
    private JButton delete;
    private JButton point;

    public Calculator(){
        super("Калькулятор");
        super.setBounds(200, 200, 220, 270);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

        container = super.getContentPane();
        container.setLayout(new BorderLayout());
        
        sign = ' ';
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
        delete = new JButton("<");
        point = new JButton(",");

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
        delete.addActionListener(new DeleteEvent());
        point.addActionListener(new PointEvent());

        textfield.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 30));
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textfield.setText("0");

        panel1.setLayout(new GridLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        panel2.setLayout(new GridLayout(5, 4, 10, 10));
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
        panel2.add(point);
        panel2.add(button0);
        panel2.add(ravno);
        panel2.add(delit);
        panel2.add(delete);

        container.add(panel1, BorderLayout.NORTH);
        container.add(panel2, BorderLayout.CENTER);
    }

    class ButtonEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (textfield.getText().equals("0")){
                textfield.setText(e.getActionCommand());
            }
            else{
                textfield.setText(textfield.getText() + e.getActionCommand());
            }
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
            boolean if_minus;
            boolean if_sign = true;

            if (text.startsWith("-") && sign == '-'){
                if_minus = true;
                text = text.substring(1, text.length());
            }
            else{
                if_minus = false;
            }

            value = text.split("\\" + sign);

            switch (sign) {
                case '+':
                    if_sign = true;
                    result = Double.toString(Double.parseDouble(value[0]) + Double.parseDouble(value[1]));
                    break;
                case '-':
                    if_sign = true;
                    if (if_minus){
                        result = Double.toString(Double.parseDouble("-" + value[0]) - Double.parseDouble(value[1]));
                    }
                    else{
                        result = Double.toString(Double.parseDouble(value[0]) - Double.parseDouble(value[1]));
                    }
                    break;
                case '*':
                    if_sign = true;
                    result = Double.toString(Double.parseDouble(value[0]) * Double.parseDouble(value[1]));
                    break;
                case '/':
                    if_sign = true;
                    result = Double.toString(Double.parseDouble(value[0]) / Double.parseDouble(value[1]));
                    break;

                default:
                    if_sign = false;
                    result = Double.toString(Double.parseDouble(value[0]));
                    break;
            }

            if(result.split("\\.")[1].equals("0")){
                result = result.substring(0, result.length()-2);
            }

            textfield.setText(result);

            if (if_sign){
                sign = ' ';
                for (JButton but : buttons){
                    but.addActionListener(new SignEvent());
                }
            }
            
        }

    }

    class DeleteEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            textfield.setText("0");
            if (sign != ' '){
                for (JButton but : buttons){
                    but.addActionListener(new SignEvent());
                }
            }
        }

    }

    class PointEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] text = textfield.getText().split("(?<=[-+*/])|(?=[-+*/])");
            System.out.println(Arrays.toString(text));
            System.out.println(text[text.length-1]);
            if (!text[text.length-1].equals("*") && !text[text.length-1].equals("-") && !text[text.length-1].equals("+") && !text[text.length-1].equals("/") && text[text.length-1].indexOf(".") == -1){
                textfield.setText(textfield.getText() + ".");
            }
        }

    }

}