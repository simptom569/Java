import org.json.JSONObject;
import java.util.ArrayList;
import java.io.FileWriter;


public class Main {
    
    public static void main(String[] args) throws Exception {

        /* MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true); */

        Requests requests = new Requests();
        ArrayList<JSONObject> shedules = new ArrayList<JSONObject>();

        String[] ss1 = requests.get_department();

        for (int i = 0; i < ss1.length; i++){
            String[] ss2 = requests.get_course(i+1);
            
            for (int j = 0; j < ss2.length; j++){
                String[] ss3 = requests.get_group(i+1, j+1);

                for (int k = 0; k < ss3.length; k++){
                    shedules.add(requests.get_schedule(i+1, j+1, k+1));
                }
            }
        }

        JSONObject gg = requests.merge_schedule(shedules);

        // JSONObject gg = requests.get_schedule(3, 1, 9);

        /* Если в данной неделе нет занятий на учебный день и id today не появился то берет значение nedelya-select из другой учебной недели
         * Нужно исправить ето
        */

        // requests.get_all_aud(gg, "Аудитории четвертого корпуса Тургеневская, 49");

        // JSONObject gg = requests.get_schedule(3, 3, 3);

        FileWriter file = new FileWriter("output.json");
        file.write(gg.toString(4));
        file.close();


    }

}
