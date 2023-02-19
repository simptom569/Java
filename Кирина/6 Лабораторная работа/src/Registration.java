import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Registration extends JFrame{
    
    private Container container;
    private JLabel fioJLabel;
    private JLabel postJLabel;
    private JLabel phoneJLabel;
    private JLabel emailJLabel;
    private JLabel loginJLabel;
    private JLabel passwordJLabel;
    private JLabel resetJLabel;

    private JTextField fioJTextField;
    private JTextField postJTextField;
    private JTextField phoneJTextField;
    private JTextField emailJTextField;
    private JTextField loginJTextField;
    private JTextField passwordJTextField;
    private JTextField resetJTextField;
    private JTextField[] texts;

    private JButton saveJButton;
    private JLabel fillJLabel;
    private JLabel fieldJLabel;
    private JLabel point1JLabel;
    private JLabel point2JLabel;
    private JLabel point3JLabel;
    private JLabel point4JLabel;
    private JLabel point5JLabel;
    private JLabel point6JLabel;
    private JLabel point7JLabel;

    private JPanel panel;

    public Registration(){

        super("Регистрация");
        super.setBounds(100, 100, 500, 450);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLayout(null);

        container = super.getContentPane();
        container.setBackground(new Color(102, 205, 170));

        fioJLabel = new JLabel("ФИО");
        fioJLabel.setBounds(30, 50, 80, 20);
        postJLabel = new JLabel("Должность");
        postJLabel.setBounds(30, fioJLabel.getY()+fioJLabel.getHeight()+10, 80, 20);
        phoneJLabel = new JLabel("Телефон");
        phoneJLabel.setBounds(30, postJLabel.getY()+postJLabel.getHeight()+10, 80, 20);
        emailJLabel = new JLabel("E-mail");
        emailJLabel.setBounds(30, phoneJLabel.getY()+phoneJLabel.getHeight()+10, 80, 20);
        loginJLabel = new JLabel("Логин");
        loginJLabel.setBounds(30, emailJLabel.getY()+emailJLabel.getHeight()+40, 80, 20);
        passwordJLabel = new JLabel("Пароль");
        passwordJLabel.setBounds(30, loginJLabel.getY()+loginJLabel.getHeight()+10, 80, 20);
        resetJLabel = new JLabel("Повтор пароля");
        resetJLabel.setBounds(20, passwordJLabel.getY()+passwordJLabel.getHeight()+10, 90, 20);

        fioJTextField = new JTextField();
        fioJTextField.setBounds(fioJLabel.getX()+fioJLabel.getWidth()+10, 50, 230, 20);
        postJTextField = new JTextField();
        postJTextField.setBounds(postJLabel.getX()+postJLabel.getWidth()+10, fioJLabel.getY()+fioJLabel.getHeight()+10, 230, 20);
        phoneJTextField = new JTextField();
        phoneJTextField.setBounds(phoneJLabel.getX()+phoneJLabel.getWidth()+10, postJLabel.getY()+postJLabel.getHeight()+10, 230, 20);
        emailJTextField = new JTextField();
        emailJTextField.setBounds(emailJLabel.getX()+emailJLabel.getWidth()+10, phoneJLabel.getY()+phoneJLabel.getHeight()+10, 230, 20);
        loginJTextField = new JTextField();
        loginJTextField.setBounds(loginJLabel.getX()+loginJLabel.getWidth()+10, emailJLabel.getY()+emailJLabel.getHeight()+40, 230, 20);
        passwordJTextField = new JTextField();
        passwordJTextField.setBounds(passwordJLabel.getX()+passwordJLabel.getWidth()+10, loginJLabel.getY()+loginJLabel.getHeight()+10, 230, 20);
        resetJTextField = new JTextField();
        resetJTextField.setBounds(resetJLabel.getX()+resetJLabel.getWidth()+10, passwordJLabel.getY()+passwordJLabel.getHeight()+10, 230, 20);

        texts = new JTextField[7];
        texts[0] = fioJTextField;
        texts[1] = postJTextField;
        texts[2] = phoneJTextField;
        texts[3] = emailJTextField;
        texts[4] = loginJTextField;
        texts[5] = passwordJTextField;
        texts[6] = resetJTextField;

        fillJLabel = new JLabel("Заполните поля:");
        fillJLabel.setBounds(5, 5, 300, 10);
        fieldJLabel = new JLabel("Обязательные поля помечены *");
        fieldJLabel.setBounds(135, 20, 300, 10);

        point1JLabel = new JLabel("*");
        point2JLabel = new JLabel("*");
        point3JLabel = new JLabel("*");
        point4JLabel = new JLabel("*");
        point5JLabel = new JLabel("*");
        point6JLabel = new JLabel("*");
        point7JLabel = new JLabel("*");

        saveJButton = new JButton("Сохранить");
        saveJButton.setBounds(185, 370, 100, 25);
        saveJButton.setForeground(new Color(213, 228, 225));
        saveJButton.setBackground(new Color(0, 128, 128));
        saveJButton.addActionListener(new SaveAction());

        panel = new JPanel(null, false);

        panel.setBounds(10, 30, 450, 320);
        // panel.setBorder(BorderFactory.createBevelBorder(2));

        panel.add(fillJLabel);
        panel.add(fieldJLabel);
        
        panel.add(fioJLabel);
        panel.add(fioJTextField);
        point1JLabel.setBounds(fioJTextField.getX()+fioJTextField.getWidth()+10, 50, 10, 10);
        panel.add(point1JLabel);

        panel.add(postJLabel);
        panel.add(postJTextField);
        point2JLabel.setBounds(postJTextField.getX()+postJTextField.getWidth()+10, fioJTextField.getY()+fioJTextField.getHeight()+10, 10, 10);
        panel.add(point2JLabel);

        panel.add(phoneJLabel);
        panel.add(phoneJTextField);
        point3JLabel.setBounds(phoneJTextField.getX()+phoneJTextField.getWidth()+10, postJTextField.getY()+postJTextField.getHeight()+10, 10, 10);
        panel.add(point3JLabel);

        panel.add(emailJLabel);
        panel.add(emailJTextField);
        point4JLabel.setBounds(emailJTextField.getX()+emailJTextField.getWidth()+10, phoneJTextField.getY()+phoneJTextField.getHeight()+10, 10, 10);
        panel.add(point4JLabel);

        panel.add(loginJLabel);
        panel.add(loginJTextField);
        point5JLabel.setBounds(loginJTextField.getX()+loginJTextField.getWidth()+10, emailJTextField.getY()+emailJTextField.getHeight()+40, 10, 10);
        panel.add(point5JLabel);

        panel.add(passwordJLabel);
        panel.add(passwordJTextField);
        point6JLabel.setBounds(passwordJTextField.getX()+passwordJTextField.getWidth()+10, loginJTextField.getY()+loginJTextField.getHeight()+10, 10, 10);
        panel.add(point6JLabel);

        panel.add(resetJLabel);
        panel.add(resetJTextField);
        point7JLabel.setBounds(resetJTextField.getX()+resetJTextField.getWidth()+10, passwordJTextField.getY()+passwordJTextField.getHeight()+10, 10, 10);
        panel.add(point7JLabel);

        container.add(panel);
        container.add(saveJButton);

    }

    private class SaveAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean tf = false;
            for (JTextField text : texts) {
                if (text.getText().equals("")){
                    text.setBackground(Color.red);
                    tf = true;
                }
            }
            if (tf){
                JOptionPane.showMessageDialog(null, "Заполните обязательные поля", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}