public class Function {
    public int minimal_four(int a, int b, int c, int d){
        int g = a;
        if (a<=b && a<=c && a<=d){
            g = a;
        }
        if (b<=a && b<=c && b<=d){
            g = b;
        }
        if (c<=b && c<=a && c<=d){
            g = c;
        }
        if (d<=b && d<=c && d<=a){
            g = d;
        }
        return g;
    }

    public int kol_max_chisl(int a, int b, int c, int d){
        int g = a;
        int kol = 0;
        if (a>=b && a>=c && a>=d){
            g = a;
        }
        if (b>=a && b>=c && b>=d){
            g = b;
        }
        if (c>=b && c>=a && c>=d){
            g = c;
        }
        if (d>=b && d>=c && d>=a){
            g = d;
        }
        if (g == a){
            kol++;
        }
        if (g == b){
            kol++;
        }
        if (g == c){
            kol++;
        }
        if (g == d){
            kol++;
        }
        return kol;
    }
    
    public int minimal_five(int a, int b, int c, int d, int e){
        int g = a;
        if (a<=b && a<=c && a<=d && a<=e){
            g = a;
        }
        if (b<=a && b<=c && b<=d && b<=e){
            g = b;
        }
        if (c<=b && c<=a && c<=d && c<=e){
            g = c;
        }
        if (d<=b && d<=c && d<=a && d<=e){
            g = d;
        }
        if (e<=b && e<=c && e<=d && e<=a){
            g = e;
        }
        return g;
    }

    public int maximum_five(int a, int b, int c, int d, int e){
        int g = a;
        if (a>=b && a>=c && a>=d && a>=e){
            g = a;
        }
        if (b>=a && b>=c && b>=d && b>=e){
            g = b;
        }
        if (c>=b && c>=a && c>=d && c>=e){
            g = c;
        }
        if (d>=b && d>=c && d>=a && d>=e){
            g = d;
        }
        if (e>=b && e>=c && e>=d && e>=a){
            g = e;
        }
        return g;
    }

    public String compare(String name1, String name2){
        String value = "Люди не являются тезками";
        if (name1.toLowerCase().equals(name2.toLowerCase())){
            value = "Данные люди являются тезками";
        }
        return value;
    }

    public String seasons(int mounth){
        String season;
        switch (mounth){
            case 12:
            case 1:
            case 2:
                season = "Зима";
                break;
            case 3:
            case 4:
            case 5:
                season = "Весна";
                break;
            case 6:
            case 7:
            case 8:
                season = "Лето";
                break;
            case 9:
            case 10:
            case 11:
                season = "Осень";
                break;
            default:
                season = "Я не знаю такого месяца";
                break;
        }
        return season;
    }
}