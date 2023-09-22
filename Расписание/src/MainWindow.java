import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.DimensionUIResource;


public class MainWindow extends JFrame {
    
    private Container container;
    private Requests requests;
    
    private JComboBox date_Box;
    private JComboBox time_Box;
    private JComboBox adress_Box;

    MainWindow(){

        super("Main");
        super.setBounds(50, 50, 920, 517);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setMinimumSize(new DimensionUIResource(640, 360));
        super.setLayout(null);

    }

}
