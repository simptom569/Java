public class Cat {
    private int weight;
    private String name;
    private String color;

    public void eat(){
        System.out.print("Cat-Eating...\n");
    }

    public void sleep(){
        System.out.print("Cat-Sleeping zzzzz.....\n");
    }

    public String speak(String words){
        String phrase = words + "..mau..!\n";
        return phrase;
    }
}
