import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    
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
        super("Контактная форма");
        super.setBounds(200, 200, 250, 300);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

        container = super.getContentPane();
        container.setLayout(new BorderLayout());

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

        textfield.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 30));
        textfield.setEditable(false);

        panel1.setLayout(new GridLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        
        panel2.setLayout(new GridLayout(4, 4, 10, 10));
        panel2.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

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

}