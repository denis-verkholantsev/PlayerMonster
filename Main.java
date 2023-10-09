
public class Main {
    public static void main(String[] args) {
        Player player = new Player(20, 15, 100, 1, 30);
        Monster monster = new Monster(25, 18, 110, 15, 25);
        Game.play(player, monster);
    }
}