public class App {
    public static void main(String[] args) throws Exception {
        Cat ourCat = new Cat();
        ourCat.eat();
        ourCat.sleep();
        String sayCat = ourCat.speak("Play with me");
        System.out.print(sayCat);
        Dog ourDog = new Dog();
        ourDog.eat();
        ourDog.sleep();
        String sayDog = ourDog.speak("Play with me");
        System.out.print(sayDog);
    }
}