public class Dog {
    private int weight;
    private String name;
    private String color;

    public void eat(){
        System.out.print("Dog-Eateing...\n");
    }

    public void sleep(){
        System.out.print("Dog-sleeping zzzzz....\n");
    }

    public String speak(String words){
        String phrase = words + "..gau..!\n";
        return phrase;
    }
}
