import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.sourceforge.jdatepicker.impl.*;

public class Forma extends JFrame{

    private Container container;

    private JPanel panel1;
    private JLabel info_text;
    private JLabel familia_text;
    private JTextField familia_input;
    private JLabel ima_text;
    private JTextField ima_input;
    private JLabel adress_text;
    private JTextField adress_input;

    private JPanel panel2;
    private JLabel info1_text;
    private JLabel tekush_text;
    private JTextField tekush_input;
    private JLabel pred_text;
    private JTextField pred_input;
    private JLabel tariff_text;
    private JTextField tariff_input;
    private JButton vichislit_button;
    private JLabel oplata_text;
    private JTextField oplata_input;
    private JLabel data_text;
    private UtilDateModel model;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;

    private JPanel panel3;
    private JLabel deistvie_text;
    private JButton prinat_button;
    private JButton ochistit_button;
    private JButton vihod_button;

    private JTextField[] inputs;

    Forma(){

        super("Froma");
        super.setBounds(200, 200, 625, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLayout(null);

        container = super.getContentPane();

        panel1 = new JPanel();
        info_text = new JLabel("Информация о клиенте");
        familia_text = new JLabel("Фамилия");
        familia_input = new JTextField();
        ima_text = new JLabel("Имя");
        ima_input = new JTextField();
        adress_text = new JLabel("Адрес");
        adress_input = new JTextField();

        panel2 = new JPanel();
        info1_text = new JLabel("Информация о клиенте");
        tekush_text = new JLabel("Текущее показание счетчика");
        tekush_input = new JTextField();
        pred_text = new JLabel("Предыдущее показание счетчика");
        pred_input = new JTextField();
        tariff_text = new JLabel("Тариф");
        tariff_input = new JTextField();
        vichislit_button = new JButton("Вычислить");
        oplata_text = new JLabel("К оплате");
        oplata_input = new JTextField();
        data_text = new JLabel("Дата платежа");
        model = new UtilDateModel();
        datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel);

        panel3 = new JPanel();
        deistvie_text = new JLabel("Действия:");
        prinat_button = new JButton("Принять");
        ochistit_button = new JButton("Очистить");
        vihod_button = new JButton("Выход");

        inputs = new JTextField[]{familia_input, ima_input, adress_input, oplata_input};


        info_text.setFont(new Font("SansSerif", Font.PLAIN, 10));
        info_text.setBounds(40, 10, 200, 20);

        panel1.setBounds(28, 15, 240, 185);
        panel1.setLayout(null);
        panel1.setBackground(new Color(230, 208, 245));
        panel1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        familia_text.setFont(new Font("SansSerif", Font.PLAIN, 11));
        familia_text.setBounds(30, 24, 200, 20);

        familia_input.setBounds(familia_text.getX(), familia_text.getY()+20, 180, 20);

        ima_text.setFont(new Font("SansSerif", Font.PLAIN, 11));
        ima_text.setBounds(familia_input.getX(), familia_input.getY()+20, 200, 20);

        ima_input.setBounds(ima_text.getX(), ima_text.getY()+20, 180, 20);

        adress_text.setFont(new Font("SansSerif", Font.PLAIN, 11));
        adress_text.setBounds(ima_input.getX(), ima_input.getY()+15, 200, 20);

        adress_input.setBounds(adress_text.getX(), adress_text.getY()+20, 180, 20);


        info1_text.setFont(new Font("SansSerif", Font.PLAIN, 10));
        info1_text.setBounds(340, 10, 200, 20);

        panel2.setBounds(panel1.getX()+panel1.getWidth()+60, panel1.getY(), 240, 315);
        panel2.setLayout(null);
        panel2.setBackground(new Color(230, 208, 245));
        panel2.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        tekush_text.setFont(new Font("SansSerif", Font.PLAIN, 11));
        tekush_text.setBounds(30, 24, 200, 20);

        tekush_input.setBounds(tekush_text.getX(), tekush_text.getY()+20, 180, 20);

        pred_text.setFont(new Font("SansSerif", Font.PLAIN, 11));
        pred_text.setBounds(tekush_input.getX(), tekush_input.getY()+20, 200, 20);

        pred_input.setBounds(pred_text.getX(), pred_text.getY()+20, 180, 20);

        tariff_text.setFont(new Font("SansSerif", Font.PLAIN, 11));
        tariff_text.setBounds(pred_input.getX(), pred_input.getY()+15, 200, 20);

        tariff_input.setBounds(tariff_text.getX(), tariff_text.getY()+20, 180, 20);

        vichislit_button.setFont(new Font("SansSerif", Font.PLAIN, 9));
        vichislit_button.setBounds(120-40, tariff_input.getY()+25, 80, 20);
        vichislit_button.addActionListener(new OplataAction());

        oplata_text.setFont(new Font("SansSerif", Font.PLAIN, 11));
        oplata_text.setBounds(tariff_input.getX(), vichislit_button.getY()+20, 200, 20);
        oplata_input.setEditable(false);

        oplata_input.setBounds(oplata_text.getX(), oplata_text.getY()+20, 180, 20);

        data_text.setFont(new Font("SansSerif", Font.PLAIN, 11));
        data_text.setBounds(oplata_input.getX(), oplata_input.getY()+25, 200, 20);

        datePicker.setBounds(data_text.getX(), data_text.getY()+25, 180, 20);
        

        deistvie_text.setFont(new Font("SansSerif", Font.PLAIN, 10));
        deistvie_text.setBounds(40, 210, 200, 20);

        panel3.setBounds(panel1.getX(), panel1.getY()+panel1.getHeight()+20, panel1.getWidth(), 110);
        panel3.setLayout(null);
        panel3.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        prinat_button.setFont(new Font("SansSerif", Font.PLAIN, 9));
        prinat_button.setBounds(32, 18, 176, 20);
        prinat_button.addActionListener(new PrinatAction());

        ochistit_button.setFont(new Font("SansSerif", Font.PLAIN, 9));
        ochistit_button.setBounds(prinat_button.getX(), prinat_button.getY()+prinat_button.getHeight()+7, 176, 20);

        vihod_button.setFont(new Font("SansSerif", Font.PLAIN, 9));
        vihod_button.setBounds(ochistit_button.getX(), ochistit_button.getY()+ochistit_button.getHeight()+7, 176, 20);

        panel1.add(familia_text);
        panel1.add(familia_input);
        panel1.add(ima_text);
        panel1.add(ima_input);
        panel1.add(adress_text);
        panel1.add(adress_input);

        panel2.add(tekush_text);
        panel2.add(tekush_input);
        panel2.add(pred_text);
        panel2.add(pred_input);
        panel2.add(tariff_text);
        panel2.add(tariff_input);
        panel2.add(vichislit_button);
        panel2.add(oplata_text);
        panel2.add(oplata_input);
        panel2.add(data_text);
        panel2.add(datePicker);

        panel3.add(prinat_button);
        panel3.add(ochistit_button);
        panel3.add(vihod_button);

        container.add(info_text);
        container.add(panel1);
        container.add(info1_text);
        container.add(panel2);
        container.add(deistvie_text);
        container.add(panel3);

    }

    private class OplataAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (Double.parseDouble(tekush_input.getText())>Double.parseDouble(pred_input.getText())){
                oplata_input.setText(Double.toString((Double.parseDouble(tekush_input.getText())-Double.parseDouble(pred_input.getText()))*Double.parseDouble(tariff_input.getText())));
            }
            else{
                JOptionPane.showMessageDialog(null, "Текущее значение должно быть больше предыдущего", "Внимание:", JOptionPane.DEFAULT_OPTION);
            }

        }

    }

    private class PrinatAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean tf = false;
            for (JTextField jTextField : inputs) {
                if (jTextField.getText().equals("")){
                    tf = true;
                    jTextField.setBackground(Color.red);
                }
                else{
                    jTextField.setBackground(Color.white);
                }
            }

            if (datePicker.getJFormattedTextField().getText().equals("")){
                tf = true;
                datePicker.setBackground(Color.red);
            }
            else{
                datePicker.setBackground(Color.white);
            }

            if (tf == true){
                JOptionPane.showMessageDialog(null, "Заполните все поля");
            }
            else{
                JOptionPane.showMessageDialog(null, "Платеж от " + datePicker.getJFormattedTextField().getText() + " " + oplata_input.getText() + " принят" + "\n" + "Платильщик " + familia_input.getText() + " " + ima_input.getText());
            }
        }

    }

}
