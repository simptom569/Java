import java.awt.*;
import javax.swing.*;
// import javax.swing.event.*;

public class TextEditor extends JFrame{
    
    private Container container;
    private JMenuBar menu;
    
    private JMenu createFile;
    private JMenuItem createTXT;
    private JMenuItem createWord;
    private JMenuItem createExcel;
    private JMenuItem createCSV;

    private JMenuItem editFile;
    private JMenu editWord;
    private JMenu editTXT;
    private JMenu editExcel;
    private JMenu editCSV;

    private JMenuItem writeTXTFile;
    private JMenuItem addTXTFile;
    private JMenuItem readTXTFile;
    private JMenuItem writeWordFile;
    private JMenuItem addWordFile;
    private JMenuItem readWordFile;
    private JMenuItem writeExcelFile;
    private JMenuItem addExcelFile;
    private JMenuItem readExcelFile;
    private JMenuItem writeCSVFile;
    private JMenuItem addCSVFile;
    private JMenuItem readCSVFile;

    private JMenu viewReports;

    private JMenu admin;

    private JMenu exit;

    public TextEditor(){
        super("Text Editor");
        super.setBounds(200, 200, 700, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = super.getContentPane();
        container.setLayout(new BorderLayout());

        menu = new JMenuBar();

        createFile = new JMenu("Создание файла");
        createTXT = new JMenuItem("Формат TXT");
        createWord = new JMenuItem("Формат Word");
        createExcel = new JMenuItem("Формат Excel");
        createCSV = new JMenuItem("Формат CSV");

        editFile = new JMenu("Работа с файлами различных форматов");
        editTXT = new JMenu("Формат TXT");
        editWord = new JMenu("Формат Word");
        editExcel = new JMenu("Формат Excel");
        editCSV = new JMenu("Формат CSV");
        
        writeTXTFile = new JMenuItem("Записать в файл");
        addTXTFile = new JMenuItem("Дописать в файл");
        readTXTFile = new JMenuItem("Чтение их файла");
        writeWordFile = new JMenuItem("Записать в файл");
        addWordFile = new JMenuItem("Дописать в файл");
        readWordFile = new JMenuItem("Чтение их файла");
        writeExcelFile = new JMenuItem("Записать в файл");
        addExcelFile = new JMenuItem("Дописать в файл");
        readExcelFile = new JMenuItem("Чтение их файла");
        writeCSVFile = new JMenuItem("Записать в файл");
        addCSVFile = new JMenuItem("Дописать в файл");
        readCSVFile = new JMenuItem("Чтение их файла");

        viewReports = new JMenu("Просмотр отчетов");

        admin = new JMenu("Администрирование");

        exit = new JMenu("Выход");

        editTXT.add(writeTXTFile);
        editTXT.add(addTXTFile);
        editTXT.add(readTXTFile);
        editWord.add(writeWordFile);
        editWord.add(addWordFile);
        editWord.add(readWordFile);
        editExcel.add(writeExcelFile);
        editExcel.add(addExcelFile);
        editExcel.add(readExcelFile);
        editCSV.add(writeCSVFile);
        editCSV.add(addCSVFile);
        editCSV.add(readCSVFile);

        createFile.add(createTXT);
        createFile.add(createWord);
        createFile.add(createExcel);
        createFile.add(createCSV);
        
        editFile.add(editTXT);
        editFile.add(editWord);
        editFile.add(editExcel);
        editFile.add(editCSV);

        menu.add(createFile);
        menu.add(editFile);
        menu.add(viewReports);
        menu.add(admin);
        menu.add(exit);
        super.setDefaultLookAndFeelDecorated(true);
        super.setJMenuBar(menu);
    }

}
