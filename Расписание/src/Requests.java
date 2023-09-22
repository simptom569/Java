import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;
import java.lang.Math;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.format.DateTimeFormatter;


public class Requests {

    private String get_uuid(int length){
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String result = "";
        for (int i = 0; i < length; i++){
            result += character.charAt((int)Math.floor(Math.random()*character.length()));
        }

        return result;
    }

    public String[] get_department() throws Exception {

        Document doc = Jsoup.connect("https://rsue.ru/raspisanie/")
                            .userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Mobile Safari/537.36")
                            .get();
        
        Elements department = doc.select("select#type")
                                 .select("option");

        String[] departments = new String[department.size()-1];

        for (int i = 0; i < department.size()-1; i++){
            departments[i] = department.get(i+1).text();
        }

        return departments;

    }

    public String[] get_course(int department) throws Exception {

        Response doc1 = Jsoup.connect("https://rsue.ru/raspisanie/query.php")
                             .userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Mobile Safari/537.36")
                             .data("query", "getKinds")
                             .data("type_id", Integer.toString(department))
                             .method(Method.POST)
                             .execute();

        JSONArray course = new JSONArray(doc1.body());
        String[] courses = new String[course.length()];

        for (int i = 0; i < course.length(); i++){
            courses[i] = course.getJSONObject(i).getString("kind");
        }

        return courses;

    }

    public String[] get_group(int department, int course) throws Exception {

        Response doc2 = Jsoup.connect("https://rsue.ru/raspisanie/query.php")
                             .userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Mobile Safari/537.36")
                             .data("query", "getCategories")
                             .data("type_id", Integer.toString(department))
                             .data("kind_id", Integer.toString(course))
                             .method(Method.POST)
                             .execute();

        JSONArray group = new JSONArray(doc2.body());
        String[] groups = new String[group.length()];

        for (int i = 0; i < group.length(); i++){
            groups[i] = group.getJSONObject(i).getString("category");
        }

        return groups;

    }

    public JSONObject get_schedule(int department, int course, int group) throws Exception {

        Document doc3 = Jsoup.connect("https://rsue.ru/raspisanie/")
                             .userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Mobile Safari/537.36")
                             .data("query", "getCategories")
                             .data("f", Integer.toString(department))
                             .data("k", Integer.toString(course))
                             .data("g", Integer.toString(group))
                             .data("uuid", get_uuid(group))
                             .post();
        
        JSONObject shedules = new JSONObject();
        int start_index = -1;
        LocalDate date = LocalDate.now();
        ArrayList<Element> rasp = new ArrayList<Element>();
        Elements cols = doc3.body().select("div.col-lg-2");

        // System.out.println(department + " " + course + " " + group);

        for (int i = 0; i < cols.size(); i++){

            /* if (date.getDayOfWeek().toString().equals("SUNDAY")){
                date = date.plusDays(1);
                System.out.println(1);
            } */

            if (cols.get(i).selectFirst("div.col-lg-12") != null){
                if (cols.get(i).selectFirst("div.col-lg-12").id().equals("nedelya-select")){
                    start_index = i;
                    break;
                }
            }
            else{
                if (cols.get(i).id().equals("today")){
                    start_index = i;
                    break;
                }
            }
        }

        if (start_index == -1){
            for (int i = 0; i < cols.size(); i++){
                if (cols.get(i).id().equals("today")){
                    start_index = i;
                }
            }
        }
        
        if (start_index == -1){
            start_index = 0;
        }

        rasp.addAll(cols.subList(start_index, cols.size()));
        rasp.addAll(cols.subList(0, start_index));

        for (Element el: rasp){
            JSONObject rasp_day = new JSONObject();

            for (Element el1: el.select("div.day")){
                String time = el1.select("span.time").get(0).ownText().replace("\u2014", "-");
                JSONObject raspisanie = new JSONObject();

                raspisanie.put("name", el1.select("span.lesson").text());
                raspisanie.put("educator", el1.select("span.prepod").text());
                raspisanie.put("audence", el1.select("span.aud").last().text());
                raspisanie.put("from", Integer.toString(department) + " " + Integer.toString(course) + " " + Integer.toString(group));

                if (rasp_day.has(time)){
                    JSONArray rasp_time = rasp_day.getJSONArray(time);
                    rasp_time.put(raspisanie);
                }
                else{
                    JSONArray rasp_time = new JSONArray();
                    rasp_time.put(raspisanie);
                    rasp_day.put(time, rasp_time);
                }
            }

            while (true){
                if (el.selectFirst("div.col-lg-12") != null){
                    if(!el.selectFirst("div.col-lg-12").text().toLowerCase().equals(date.getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")).toLowerCase())){
                        /* System.out.println(el.selectFirst("div.col-lg-12").text().toLowerCase());
                        System.out.println(date.getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")).toLowerCase()); */
                        date = date.plusDays(1);
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }

            /* if (date.getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")).toLowerCase().equals("воскресенье")){
                date = date.plusDays(1);
            } */

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");
            // System.out.println(date.toString());
            String dates = date.format(formatter);
            date = date.plusDays(1);
            /* if (el.selectFirst("div.col-lg-12") != null){
                if (el.selectFirst("div.col-lg-12").text().equals("Суббота")){
                    date = date.plusDays(1);
                }
            } */
            // System.out.println(date.getDayOfWeek().toString());
            /* if (date.getDayOfWeek().toString().equals("SATURDAY")){
                date = date.plusDays(1);
            } */
            
            shedules.put(dates, rasp_day);
            
            // System.out.println(rasp_day.toString());
            /* создаем JSONObject со всеми днями
             * создаем JSONArray для расписаний в ето время
             * далее создаем JSONObject c расписанием
             * помещаем каждую пару в JSONArray
             * создаем ключ по времени с параметров в виде JSONArray
             * создаем ключ по дню с параметром JSONObject
             */
        }

        return shedules;

    }

    public JSONObject merge_schedule(ArrayList<JSONObject> raspisanie){

        JSONObject schedule = new JSONObject();

        for (JSONObject rasp: raspisanie){
            for (String day: rasp.keySet()){
                JSONObject rasp_day = rasp.getJSONObject(day);

                if (schedule.has(day)){
                    JSONObject schedule_day = schedule.getJSONObject(day);

                    for (String time: rasp_day.keySet()){
                        JSONArray rasp_time = rasp_day.getJSONArray(time);

                        if (schedule_day.has(time)){
                            JSONArray schedule_time = schedule_day.getJSONArray(time);

                            for (int i = 0; i < rasp_time.length(); i++){
                                schedule_time.put(rasp_time.getJSONObject(i));
                            }
                        }
                        else{
                            schedule_day.put(time, rasp_time);
                        }
                    }
                }
                else{
                    schedule.put(day, rasp_day);
                }
            }
        }

        /* перебор всех групп
         * перебор всех дней
         * проверка есть ли етот день
         * если есть, то
         *     взять оттуда JSONObject
         *     взять JSONObject из перебираемого елмента
         *     начать проходиться из JSONObject перебираемого
         *     проверка есть ли такое время
         *     если да, то
         *         берем оттуда JSONArray
         *         перебираем JSONArray
         */

        return schedule;

    }

    public ArrayList<String> get_all_aud(JSONObject schedule, String adress){

        ArrayList<String> all_aud = new ArrayList<String>();

        for (String day: schedule.keySet()){
            JSONObject day_json = schedule.getJSONObject(day);

            for (String time: day_json.keySet()){
                JSONArray time_json = day_json.getJSONArray(time);

                for (int i = 0; i < time_json.length(); i++){
                    JSONObject rasp_json = time_json.getJSONObject(i);
                    String aud = rasp_json.getString("audence").substring(4);
                    if (aud.startsWith(".")){
                        aud = aud.substring(1);
                    }

                    switch (adress) {
                        case "Аудитории второго корпуса Островского, 62":
                            if (aud.startsWith("*")){
                                if (!all_aud.contains(aud)){
                                    all_aud.add(aud);
                                }
                            }
                            break;
                        case "Аудитории третьего корпуса Горького, 166":
                            if (aud.startsWith("#")){
                                if (!all_aud.contains(aud)){
                                    all_aud.add(aud);
                                }
                            }
                            break;
                        case "Аудитории четвертого корпуса Тургеневская, 49":
                            if (aud.startsWith("&")){
                                if (!all_aud.contains(aud)){
                                    all_aud.add(aud);
                                }
                            }
                            break;
                        case "Аудитории первого корпуса Большой Садовой, 69":
                            if (!aud.startsWith("#") && !aud.startsWith("&") && !aud.startsWith("*")){
                                if (!all_aud.contains(aud)){
                                    all_aud.add(aud);
                                }
                            }
                            break;
                    
                        default:
                            break;
                    }
                }
            }
        }

        System.out.println(all_aud.toString());

        /* после выборки адресса вуза, проходимся по всем дням и по всему времени и по всему списку собирая все адуитории етого адресса в список
         * после берем выбранный день и время
         * перебираем их и исключаем из списка аудитории которые есть в выбранные значения
         * показываем все то, что осталось в списке
         */

        return all_aud;

    }

}