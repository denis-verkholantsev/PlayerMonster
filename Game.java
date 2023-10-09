import java.util.Scanner;

class Game{
    public static void play(Player player, Monster monster){
        Scanner scanner = new Scanner(System.in);
        while (player.isAlive() && monster.isAlive()) {
            player.attack(monster);
            if (monster.isAlive()) {
                monster.attack(player);
            }
            System.out.println("After the last round, the situation is as follows\nMonster's health is "+
                    monster.getHealth()+"\nPlayer's health is "+ player.getHealth()+"\n");
            if(!player.isAlive() || !monster.isAlive()){
                break;
            }
            System.out.print("\nDo you want to heal player? (yes/no): ");
            String input = scanner.next().toLowerCase();
            if (input.equals("yes")) {
                boolean healResult= player.heal();
                if (healResult){
                    System.out.println("We healed him. His health is " + player.getHealth());
                }else{
                    System.out.println("You cannot heal");
                }
            }else {
                System.out.println("If you don't want to, fine.");
            }
        }
        if(!player.isAlive() && !monster.isAlive()){
            System.out.println("Draw");
        }
        else if (player.isAlive() && !monster.isAlive()) {
            System.out.println("Player defeated Monster" );
        } else {
            System.out.println("Monster defeated Player");
        }
    }
}