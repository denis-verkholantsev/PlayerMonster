class Player extends Creature {
    private int healing = 4;
    private static final double availableHealing = 0.3;
    public Player(int attack, int defense, int health, int startRange, int stopRange){
        super(attack, defense, health, startRange, stopRange);
    }

    public boolean heal(){
        if (healing > 0 && health != maxHealth) {
            health = (int) Math.max(health + maxHealth * availableHealing, maxHealth);
            --healing;
            return true;
        }
        return false;
    }
}
